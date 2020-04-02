import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class RecorridoSax {
    public static void main(String[] args) {

        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();

            DefaultHandler peliculasSax = new PeliculasSax();

            saxParser.parse(new File("peliculas.xml"), peliculasSax);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
