package ParseXMLDemo;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 利用dom4j解析xml文件
 */
public class XmlParse {
    public static void main(String[] args) throws DocumentException {
        //1.获取一个解析器对象
        SAXReader saxReader = new SAXReader(); // SAX Stand for Simple API for XML
        //2.利用解析器把xml文件加载到内存中,并返回一个文档对象
        Document document = saxReader.read(new File("XMLDemo/xml/student.xml"));
        //3.获取到根标签
        Element rootElement = document.getRootElement();
        //4.通过根标签来获取student标签
        //elements():可以获取调用者所有的子标签.会把这些子标签放到一个集合中返回.
        //elements("标签名"):可以获取调用者所有的指定的子标签,会把这些子标签放到一个集合中并返回
        List<Element> studentElements = rootElement.elements("student");

        //这个集合用来装学生对象
        ArrayList<Student> list = new ArrayList<>();

        //5.遍历xml中的student标签集合,得到每一个student标签中的数据
        for (Element element : studentElements) {
            //获取id这个属性
            Attribute attribute = element.attribute("id");
            //获取id的属性值,即Value
            String id = attribute.getValue();

            //获取name标签
            Element nameElement = element.element("name");
            //获取这个标签的标签体的内容,即Text
            String name = nameElement.getText();
            //同样的操作，获取age标签体的Text
            Element ageElement = element.element("age");
            String age = ageElement.getText();

            //以获取到的数据为参数创建Student对象
            Student s = new Student(id, name, Integer.parseInt(age));
            list.add(s);
        }

        //6.遍历操作
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
