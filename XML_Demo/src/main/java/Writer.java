
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Writer {
    public static void main(String[] args) {
        try {
            Document document = DocumentHelper.createDocument();
            Element mymvcElement = document.addElement("mymvc");
            Element actionElement = mymvcElement.addElement("actions");
            Element listActionElement = actionElement.addElement("action");
            listActionElement.addAttribute("name", "list");
            listActionElement.addAttribute("class", "controller.List");

            Element toListJSPResultElement = listActionElement.addElement("result");
            toListJSPResultElement.addAttribute("name", "toListJSP");
            toListJSPResultElement.setText("/list.jsp");

            Element toShowUserinfoListResultElement = listActionElement.addElement("result");
            toShowUserinfoListResultElement.addAttribute("name", "toShowUserinfoList");
            toShowUserinfoListResultElement.addAttribute("type", "redirect");
            toShowUserinfoListResultElement.setText("showUserinfoList.ghy");

            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(new FileWriter("src/main/resources/ghy.xml"), format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
