//package core;
//
//import com.aspose.words.License;
//import com.aspose.words.SaveFormat;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//
//public class Demo1 {
//    public static void word2pdf(String docPath,String savePath){
//
//        try {
//            String s = "<License><Data><Products><Product>Aspose.Total for Java</Product><Product>Aspose.Words for Java</Product></Products><EditionType>Enterprise</EditionType><SubscriptionExpiry>20991231</SubscriptionExpiry><LicenseExpiry>20991231</LicenseExpiry><SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber></Data><Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature></License>";
//            ByteArrayInputStream is = new ByteArrayInputStream (s.getBytes());
//            License license = new License();
//            license.setLicense(is);
//            com.aspose.words.Document document = new com.aspose.words.Document(docPath);
//            document.save(new FileOutputStream (new File(savePath)), SaveFormat.PDF);
//        } catch (Exception e) {
//// TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        word2pdf ("C:\\Users\\zxd\\Desktop\\需求问题.docx","C:\\Users\\zxd\\Desktop\\秀气.pdf");
//    }
//}