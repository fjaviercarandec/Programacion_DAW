import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ModificarDOM {
    public static void main(String[] args) {

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = (Document) db.parse(new File("peliculas.xml"));

            Node root = doc.getDocumentElement();

            //Añado comentarios desde DOM
            Comment comentario = doc.createComment("COMENTARIO AÑADIDO DESDE DOM");
            NodeList nl1 = doc.getElementsByTagName("pelicula");
            for (int i = 0; i < nl1.getLength(); i++) {
                Element pelicula = (Element) nl1.item(i);
                root.insertBefore(comentario.cloneNode(false),pelicula);
            }

            //Añado etiqueta hija
            Element pelicula = doc.createElement("pelicula");
            pelicula.setAttribute("id", "006");
            Element nombre = doc.createElement("nombre");
            nombre.setTextContent("Silent Voice");
            Element director = doc.createElement("director");
            director.setTextContent("Naoko Yamada");
            Element anyo = doc.createElement("anyo");
            anyo.setTextContent("2016");
            Element pais = doc.createElement("pais");
            pais.setTextContent("Japon");

            pelicula.appendChild(nombre);
            pelicula.appendChild(director);
            pelicula.appendChild(anyo);
            pelicula.appendChild(pais);
            root.appendChild(pelicula);

            //Nuevo nodo que reemplaza a la primera
            Element pelicula2 = doc.createElement("pelicula");
            pelicula2.setAttribute("id", "007");
            Element nombre2 = doc.createElement("nombre");
            nombre2.setTextContent("Disobedience");
            Element director2 = doc.createElement("director");
            director2.setTextContent("Sebastian Lelio");
            Element anyo2 = doc.createElement("anyo");
            anyo2.setTextContent("2018");
            Element pais2 = doc.createElement("pais");
            pais2.setTextContent("Brasil");

            pelicula2.appendChild(nombre2);
            pelicula2.appendChild(director2);
            pelicula2.appendChild(anyo2);
            pelicula2.appendChild(pais2);

            Element primeraPelicula = (Element) doc.getElementsByTagName("pelicula").item(0);
            root.replaceChild(pelicula2, primeraPelicula);

            //Transformer
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/sxlt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");

            DOMSource origenDOM = new DOMSource(root);

            File nuevoPeliculas = new File("nuevoPeliculas.xml");
            StreamResult destino = new StreamResult(nuevoPeliculas);

            transformer.transform(origenDOM, destino);
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
