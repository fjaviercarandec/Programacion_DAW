
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class DomDesdeCero {
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
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element root = doc.createElement("Peliculas");

            for (Pelicula p : peliculas) {
                Element pelicula = doc.createElement("pelicula");
                pelicula.setAttribute("id", Integer.toString(p.getId()));
                Element nombre = doc.createElement("nombre");
                nombre.setTextContent(p.getNombre());
                Element director = doc.createElement("director");
                director.setTextContent(p.getDirector());
                Element anyo = doc.createElement("anyo");
                anyo.setTextContent(Integer.toString(p.getAnyo()));
                Element pais = doc.createElement("pais");
                pais.setTextContent(p.getPais());

                pelicula.appendChild(nombre);
                pelicula.appendChild(director);
                pelicula.appendChild(anyo);
                pelicula.appendChild(pais);
                root.appendChild(pelicula);
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/sxlt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");

            DOMSource origenDOM = new DOMSource(root);

            File nuevoPeliculas = new File("cero.xml");
            StreamResult destino = new StreamResult(nuevoPeliculas);

            transformer.transform(origenDOM, destino);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

    }
}
