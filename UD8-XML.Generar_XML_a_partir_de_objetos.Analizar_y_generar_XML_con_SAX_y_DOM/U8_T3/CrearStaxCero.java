import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class CrearStaxCero {
    public static void main(String[] args) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        Pelicula p1 = new Pelicula(1, "El Hoyo", "Galder Gaztelu-Urritia",2020, "España");
        Pelicula p2 = new Pelicula(2, "El Faro", "Robert Eggers",2020, "Estados Unidos");
        Pelicula p3 = new Pelicula(3, "Parasitos", "Bong Joon-ho",2019, "Corea del Sur");
        Pelicula p4 = new Pelicula(4, "Perfect Blue", "Satoshi Kon",1998, "Japon");
        Pelicula p5 = new Pelicula(5, "Paprika", "Satoshi Kon",2006, "Japon");
        Pelicula p6 = new Pelicula(6, "Silent Voice", "Naoko Yamada",2016, "Japon");
        Pelicula p7 = new Pelicula(7, "Akira", "Katsushiro Otomo",1988, "Japon");
        Pelicula p8 = new Pelicula(8, "Disobedience", "Sebastian Lelio",2018, "Brasil");
        Pelicula p9 = new Pelicula(9, "Detachment", "Tony Kaye",2011, "Estados Unidos");
        Pelicula p10 = new Pelicula(10, "Snowpiercer", "Bong Joon-ho",2013, "Corea del Sur");

        peliculas.add(p1);
        peliculas.add(p2);
        peliculas.add(p3);
        peliculas.add(p4);
        peliculas.add(p5);
        peliculas.add(p6);
        peliculas.add(p7);
        peliculas.add(p8);
        peliculas.add(p9);
        peliculas.add(p10);

        try {
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
            XMLEventWriter xmlWriter = xmlOutputFactory.createXMLEventWriter(new FileOutputStream("stax.xml"));

            XMLEventFactory eventFactory = XMLEventFactory.newInstance();

            StartDocument startDocument = eventFactory.createStartDocument();
            xmlWriter.add(startDocument);

            Characters saltoDeLinea = eventFactory.createCharacters("\n");
            Characters saltoDeLineaTab = eventFactory.createCharacters("\n\t");
            Characters tabulador = eventFactory.createCharacters("\t");
            xmlWriter.add(saltoDeLinea);

            StartElement peliculasStartElement = eventFactory.createStartElement("","","peliculas");
            xmlWriter.add(peliculasStartElement);
            xmlWriter.add(saltoDeLinea);

            for (Pelicula p : peliculas) {
                StartElement peliculaStart = eventFactory.createStartElement("","","pelicula");
                StartElement nombreStart = eventFactory.createStartElement("","","nombre");
                StartElement directorStart = eventFactory.createStartElement("","","director");
                StartElement anyoStart = eventFactory.createStartElement("","","anyo");
                StartElement paisStart = eventFactory.createStartElement("","","pais");

                Attribute id = eventFactory.createAttribute("id", Integer.toString(p.getId()));

                EndElement peliculaEnd = eventFactory.createEndElement("","","pelicula");
                EndElement nombreEnd = eventFactory.createEndElement("","","nombre");
                EndElement directorEnd = eventFactory.createEndElement("","","director");
                EndElement anyoEnd = eventFactory.createEndElement("","","anyo");
                EndElement paisEnd = eventFactory.createEndElement("","","pais");

                Characters nombre = eventFactory.createCharacters(p.getNombre());
                Characters director = eventFactory.createCharacters(p.getDirector());
                Characters anyo = eventFactory.createCharacters(Integer.toString(p.getAnyo()));
                Characters pais = eventFactory.createCharacters(p.getPais());

                xmlWriter.add(tabulador);
                xmlWriter.add(peliculaStart);
                xmlWriter.add(id);
                xmlWriter.add(saltoDeLineaTab);
                xmlWriter.add(tabulador);

                xmlWriter.add(nombreStart);
                xmlWriter.add(nombre);
                xmlWriter.add(nombreEnd);
                xmlWriter.add(saltoDeLineaTab);
                xmlWriter.add(tabulador);

                xmlWriter.add(directorStart);
                xmlWriter.add(director);
                xmlWriter.add(directorEnd);
                xmlWriter.add(saltoDeLineaTab);
                xmlWriter.add(tabulador);

                xmlWriter.add(anyoStart);
                xmlWriter.add(anyo);
                xmlWriter.add(anyoEnd);
                xmlWriter.add(saltoDeLineaTab);
                xmlWriter.add(tabulador);

                xmlWriter.add(paisStart);
                xmlWriter.add(pais);
                xmlWriter.add(paisEnd);
                xmlWriter.add(saltoDeLineaTab);
                xmlWriter.add(tabulador);

                xmlWriter.add(peliculaEnd);
                xmlWriter.add(saltoDeLinea);

            }

            EndElement peliculasEndElement = eventFactory.createEndElement("","","peliculas");
            xmlWriter.add(peliculasEndElement);
            xmlWriter.add(saltoDeLinea);

            EndDocument endDocument = eventFactory.createEndDocument();
            xmlWriter.add(endDocument);

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
