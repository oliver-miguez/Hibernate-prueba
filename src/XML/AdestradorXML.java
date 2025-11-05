package XML;

import Model.AdestradorModel;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.util.List;

public class AdestradorXML {
    public static void XMLAdestrador(List<AdestradorModel>adestradorModels){
        try {
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter("XML Adestrador.xml"));

            xmlStreamWriter.writeStartDocument("1.0");

            xmlStreamWriter.writeStartElement("Adestradores");

            for(AdestradorModel adestradorModel : adestradorModels){

                xmlStreamWriter.writeStartElement("Adestrador");

                xmlStreamWriter.writeStartElement("ID");
                xmlStreamWriter.writeCharacters(""+adestradorModel.getId());
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeStartElement("Nome");
                xmlStreamWriter.writeCharacters(adestradorModel.getNome());
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeStartElement("Nacemento");
                xmlStreamWriter.writeCharacters(""+adestradorModel.getNacemento());
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeEndElement();

            }

            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();

        } catch (Exception e) {
            System.out.println("Error en el xml: "+e.getMessage());
        }
    }


}
