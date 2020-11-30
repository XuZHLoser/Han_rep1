import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
//这里调用的应该是DOM接口，SAX接口是基于事件的，而DOM接口是在内存中构建XML文档的关系树
public class Reader {
    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
//            System.out.println(reader.getClass().getResource("/").toString());
//            Document document = reader.read(reader.getClass()
//                    .getResourceAsStream("/struts.xml"));
            System.out.println("相对路径指定到："+
                    System.getProperty("user.dir"));
            Document document = reader.read("src/main/resources/struts.xml");
            Element mymvcElement = document.getRootElement();
            System.out.println(mymvcElement.getName());
            Element actionsElement = mymvcElement.element("actions");
            System.out.println(actionsElement.getName());
            System.out.println("");
            List<Element> actionList = actionsElement.elements("action");
            for (int i = 0; i < actionList.size(); i++) {
                Element actionElement = actionList.get(i);
                System.out.println(actionElement.getName());
                System.out.print("name=" +
                        actionElement.attribute("name").getValue());
                System.out.println("action class=" +
                        actionElement.attribute("class").getValue());
                List<Element> resultList = actionElement.elements("result");
                for (int j = 0; j < resultList.size(); j++) {
                    Element resultElement = resultList.get(j);
                    System.out.print(" result name="
                    +resultElement.attribute("name").getValue());
                    Attribute typeAttribute = resultElement.attribute("type");
                    if (typeAttribute != null) {
                        System.out.println(" type=" + typeAttribute.getValue());
                    } else {
                        System.out.println("");
                    }
                    System.out.println("  " + resultElement.getText().trim());
                    System.out.println("");
                }
                System.out.println("");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
