import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class RecorridoDOM {
    public static void numNodosHijos() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("peliculas.xml"));

            //Saco el numero de hijos de la raiz
            Element root = doc.getDocumentElement();
            System.out.println("Numero de hijos del elemento raiz: " + root.getChildNodes().getLength());

            NodeList nl = root.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++) {
                if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("Nodo numero " + i + " es una ETIQUETA");
                } else if (nl.item(i).getNodeType() == Node.TEXT_NODE) {
                    System.out.println("Nodo numero " + i + " es un TEXTO");
                } else if (nl.item(i).getNodeType() == Node.COMMENT_NODE) {
                    System.out.println("Nodo numero " + i + " es un COMENTARIO");
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getStackTrace());
        }

    }

    public static void mostrarXMLDom() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("peliculas.xml"));

            NodeList nl1 = doc.getChildNodes();
            for (int i = 0; i < nl1.getLength(); i++) {
                if (nl1.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element e1 = (Element) nl1.item(i);
                    if (e1.hasAttributes()) {
                        System.out.print("<" + e1.getTagName() + " ");
                        NamedNodeMap nodeMap = e1.getAttributes();
                        for (int j = 0; j < nodeMap.getLength(); j++) {
                            Node node = nodeMap.item(j);
                            Attr atributo = e1.getAttributeNode(node.getNodeName());
                            System.out.print(atributo.getNodeName() + "=" + atributo.getValue() + " ");
                        }
                        System.out.println(">");
                    } else {
                        System.out.println("<" + e1.getTagName() + ">");
                    }


                    Element root = doc.getDocumentElement();
                    NodeList nl2 = root.getChildNodes();

                    for (int j = 0; j < nl2.getLength(); j++) {
                        if (nl2.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element e2 = (Element) nl2.item(j);
                            System.out.print("<" + e2.getTagName() + " ");
                            if (e2.hasAttributes()) {
                                NamedNodeMap nodeMap = e2.getAttributes();
                                for (int k = 0; k < nodeMap.getLength(); k++) {
                                    Node node = nodeMap.item(k);
                                    Attr atributo = e2.getAttributeNode(node.getNodeName());
                                    System.out.print(atributo.getNodeName() + "=" + atributo.getValue() + " ");
                                }
                            }
                            System.out.println(">");
                            System.out.println(e2.getTextContent());
                        }
                    }

                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void mostrarContenidoEtiqueta(Element etiq) {
        if (etiq.hasAttributes()) {
            System.out.print("<" + etiq.getTagName() + " ");
            NamedNodeMap nodeMap = etiq.getAttributes();
            for (int j = 0; j < nodeMap.getLength(); j++) {
                Node node = nodeMap.item(j);
                Attr atributo = etiq.getAttributeNode(node.getNodeName());
                System.out.print(atributo.getNodeName() + "=" + atributo.getValue() + " ");
            }
            System.out.println(">");
        } else {
            System.out.println("<" + etiq.getTagName() + ">");
        }
        System.out.println(etiq.getTextContent());
    }

    public static void main(String[] args) {

        System.out.println("========= PRIMER METODO =========");
        numNodosHijos();
        System.out.println("=================================");

        System.out.println("========= SEGUNDO METODO =========");
        mostrarXMLDom();
        System.out.println("==================================");

        System.out.println("========= TERCER METODO =========");
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("peliculas.xml"));

            NodeList nl = doc.getElementsByTagName("pelicula");
            for (int i = 0; i < nl.getLength(); i++) {
                mostrarContenidoEtiqueta((Element) nl.item(i));
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getStackTrace());
        }
        System.out.println("=================================");

    }
}
