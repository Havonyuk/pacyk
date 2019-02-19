package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            try {
                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    factory.setNamespaceAware(true);
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document document = builder.parse("toys.xml");

                    Element element = document.getDocumentElement();

                    if ("toys".equals(element.getTagName())) {
                        NodeList toys = element.getElementsByTagName("toy"); //дочерние элементы
                        for (int i = 0; i < toys.getLength(); ++i) {
                            Element stationery = (Element) toys.item(i);
                            String maker = null, country = null, name = null, shop = null, material = null, price = null;
                            NodeList props = stationery.getElementsByTagName("*"); // дочерние элементы
                            for (int j = 0; j < props.getLength(); ++j) { //кол-во дочерних узлов
                                Element prop = (Element) props.item(j);
                                if ("country".equals(prop.getTagName())) { //имя данного элемента
                                    country = prop.getTextContent();
                                } else if ("maker".equals(prop.getTagName())) {
                                    maker = prop.getTextContent();
                                } else if ("name".equals(prop.getTagName())) {
                                    name = prop.getTextContent();
                                } else if ("material".equals(prop.getTagName())) {
                                    material = prop.getTextContent();
                                } else if ("material".equals(prop.getTagName())) {
                                    material = prop.getTextContent();
                                } else if ("price".equals(prop.getTagName())) {
                                    price = prop.getTextContent();
                                }
                            }
                            if (country != null) {
                                System.out.println( "Страна " + country);
                            }
                            if (maker != null) {
                                System.out.println(" от производителя " + maker);
                            }
                            if (shop != null) {
                                System.out.println(" поставляет в " + shop);
                            }
                            if (name!= null) {
                                System.out.println(" товар " + name);
                            }
                            if (material!= null) {
                                System.out.println(" изготовленный из " + material);
                            }
                            if (price != null) {
                                System.out.println(" по цене за единицу продукта" + price);
                            }
                            System.out.println('\n');
                        }
                    }

                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

