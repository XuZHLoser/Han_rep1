import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DeleteAttr {
    public static void main(String[] args) throws IOException {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read("src" +
                    "/main/resources/struts.xml");
            Element mymvcElement = document.getRootElement();
            Element actionsElement = mymvcElement.element("actions");
            List<Element> actionList = actionsElement.elements("action");
            for (int i = 0; i < actionList.size(); i++) {
                Element actionElement = actionList.get(i);
                List<Element> resultList = actionElement.
                        elements("result");
                Element resultElement = null;
                for (int j = 0; j < resultList.size(); j++) {
                    resultElement = resultList.get(j);
                    String resultName = resultElement.
                            attribute("name").getValue();
                    if (resultName.equals("toShowUserinfoList")) {
                        Attribute typeAttribute = resultElement.
                                attribute("type");
                        if (typeAttribute != null) {
                            resultElement.remove(typeAttribute);
                        }
                    }
                }
            }
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(new FileWriter
                    ("src/main/resources/struts.xml"), format);
            writer.write(document);
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}