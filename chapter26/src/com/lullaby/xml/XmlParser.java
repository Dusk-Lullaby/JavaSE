package com.lullaby.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;

public class XmlParser {

    public static void main(String[] args) {
        // 构建一个SAX读取器
        SAXReader reader = new SAXReader();
        // 通过类的字节码对象获取一个给的资源，并将给资源读取到流的通道中
        InputStream inputStream = XmlParser.class.getResourceAsStream("student.xml");
        try {
            // SAX读取器从通道中读取一个文档对象
            Document document = reader.read(inputStream);
            // 获取文档的根元素，因为XML只会有一个个根元素
            Element root = document.getRootElement();
            // 获取根元素的标签名
            String tagName = root.getQualifiedName();
            System.out.println("XML文档根标签: " + tagName);
            // 获取根元素的下一级子元素
//            List<Element> elements = root.elements();
//            for (Element element : elements) {
//                // 获取元素的标签名
//                String tag = element.getQualifiedName();
//                System.out.println(tag);
//                // 获取元素的所有属性
//                List<Attribute> attributes = element.attributes();
//                for (Attribute attribute : attributes) {
//                    // 获取属性名
//                    String attrName = attribute.getName();
//                    // 获取属性值
//                    String value = attribute.getValue();
//                    System.out.print("属性: " + attrName + "=>" + value + "\t");
//                }
//                System.out.println();
//            }
            Iterator<Element> iterator = root.elementIterator("student");
            while (iterator.hasNext()) {
                Element element = iterator.next();
                // 获取元素的标签名
                String tag = element.getQualifiedName();
                System.out.println(tag);
//                // 获取元素的所有属性
//                List<Attribute> attributes = element.attributes();
//                for (Attribute attribute : attributes) {
//                    // 获取属性名
//                    String attrName = attribute.getName();
//                    // 获取属性值
//                    String value = attribute.getValue();
//                    System.out.print("属性: " + attrName + "=>" + value + "\t");
//                }
//                System.out.println();
                String name = element.attributeValue("name");
                String sex = element.attributeValue("sex");
                String age = element.attributeValue("age");
                System.out.println(name + "\t" + sex + "\t" + age);
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
