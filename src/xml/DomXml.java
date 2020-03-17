package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class DomXml {
    private static DocumentBuilderFactory dbFactory = null;
    private static DocumentBuilder db = null;
    private static Document document = null;
    private static List<User> users = null;
    static{
        try {
            dbFactory = DocumentBuilderFactory.newInstance();
            db = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
    public static List<User> getUser(String filename)throws Exception{
        document=db.parse (filename);
        NodeList userList=document.getElementsByTagName ("user");
        users=new ArrayList<> ();
        for(int i=0;i<userList.getLength ();i++){
            User user=new User ();
            Node node=userList.item (i);
            NodeList list=node.getChildNodes ();
            ArrayList<String> contents = new ArrayList<>();
            for(int j=1;j<list.getLength ();j+=2){
                Node cNode = list.item(j);
                String content = cNode.getFirstChild().getTextContent();
                contents.add(content);
            }
            user.setId (contents.get (0));
            user.setName (contents.get (1));
            user.setSex (contents.get (2));
            user.setAge (Integer.parseInt (contents.get (3)));
            users.add (user);
        }
        return users;
    }

    public static void main(String[] args) {
        String fileName = "src/xml/user.xml";
        try {
            List<User> list =DomXml.getUser (fileName);
            list.forEach (e-> System.out.println (e));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
