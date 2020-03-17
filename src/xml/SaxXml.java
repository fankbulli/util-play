package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class SaxXml extends DefaultHandler {
    private List<User> list;
    private User user;
    private String content=null;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument ();
        System.out.println ("开始解析xml文件");
        list=new ArrayList<> ();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument ();
        System.out.println ("xml文件解析完毕");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement (uri, localName, qName, attributes);

        if (qName.equals ("user")){
            user=new User ();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement (uri, localName, qName);
        switch (qName){
            case "id":user.setId (content);break;
            case "name":user.setName (content);break;
            case "sex":user.setSex (content);break;
            case "age":user.setAge (Integer.parseInt (content));break;
            case "user":list.add (user);user=null;break;
            default:break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters (ch, start, length);
        content=new String (ch,start,length);
    }

    public List<User> getUsers(){
        return list;
    }

}
class Readxml{
    private static List<User> books = null;

    private SAXParserFactory sParserFactory = null;
    private SAXParser parser = null;


    public List<User> getBooks(String fileName) throws Exception{
        SAXParserFactory sParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = sParserFactory.newSAXParser();

        SaxXml handler = new SaxXml ();
        parser.parse(fileName, handler);

        return handler.getUsers ();

    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            books = new Readxml().getBooks("src/xml/user.xml");
            for(User u:books){
                System.out.println(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
