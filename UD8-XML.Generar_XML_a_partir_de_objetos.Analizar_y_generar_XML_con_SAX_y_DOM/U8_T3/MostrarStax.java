import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MostrarStax {
    public static void main(String[] args) {
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader xmlReader = xmlInputFactory.createXMLEventReader(new FileInputStream("peliculas.xml"));

            while (xmlReader.hasNext()) {
                XMLEvent xmlEvent = xmlReader.nextEvent();

                if (xmlEvent.isStartElement()) {
                    StartElement startTag = xmlEvent.asStartElement();

                    String tagName = startTag.getName().getLocalPart();
                    switch (tagName) {
                        case "pelicula" :
                            System.out.print("\t" + "<" + startTag.getName().getLocalPart());
                            Attribute id = startTag.getAttributeByName(new QName("id"));
                            System.out.println(" " + id + ">");
                            break;
                        case "peliculas" :
                            System.out.println("<" + startTag.getName().getLocalPart() + ">");
                            break;
                        default:
                            System.out.print("\t\t" + "<" + startTag.getName().getLocalPart());
                            System.out.print(">");
                            break;
                    }
                } else if (xmlEvent.isEndElement()) {
                    EndElement endTag = xmlEvent.asEndElement();

                    String tagName = endTag.getName().getLocalPart();
                    switch (tagName) {
                        case "pelicula" :
                            System.out.println("\t" + "</" + endTag.getName().getLocalPart() + ">");
                            break;
                        default:
                            System.out.println("</" + endTag.getName().getLocalPart() + ">");
                            break;
                    }
                } else if (xmlEvent.isStartDocument()) {
                    System.out.println("Comienzo del parseado");
                } else if (xmlEvent.isEndDocument()) {
                    System.out.println("Fin del parseado");
                } else if (xmlEvent.isCharacters()) {
                    Characters texto = xmlEvent.asCharacters();
                    if (!texto.getData().contains("\n")) {
                        System.out.print(texto.getData());
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
