import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PeliculasSax extends DefaultHandler {

    public PeliculasSax() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("=============================================");
        System.out.println("Comienzo parseado del documento peliculas.xml");
        System.out.println("=============================================");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("=============================================");
        System.out.println("Finalizo parseado del documento peliculas.xml");
        System.out.println("=============================================");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        System.out.print("<" + qName);
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.print(" " + attributes.getQName(i) + "=" + attributes.getValue(i));
            }
        }
        System.out.print(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println("</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        String content = new String(ch,start,length);
        System.out.print(content);
    }
}
