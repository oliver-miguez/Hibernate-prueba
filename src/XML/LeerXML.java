package XML;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LeerXML {
    public static void leerXML() {
        try {
            // 1️⃣ Crear el lector de XML
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("XML Adestrador.xml"));

            // 2️⃣ Recorrer el XML evento por evento
            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Inicio de elemento: " + reader.getLocalName());
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        String texto = reader.getText().trim();
                        if (!texto.isEmpty()) {
                            System.out.println("  Texto: " + texto);
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("Fin de elemento: " + reader.getLocalName());
                        break;
                }
            }

            reader.close();

        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println("Error al leer xml: "+e.getMessage());
        }
    }
}
