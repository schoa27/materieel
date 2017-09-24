package nl.scholtens.material.mapper;

import nl.scholtens.material.sources.Plan;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;


public class PlanMapper {

    public Plan mapPlan(String file) throws JAXBException,  JAXBException, SAXException, FileNotFoundException {
        JAXBContext ctx = JAXBContext.newInstance("nl.scholtens.material.sources");
        Unmarshaller unmarshaller = ctx.createUnmarshaller();

        SchemaFactory schemaFactory = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);

        File schemaFile = new File("src/main/resources/xsd/loc.xsd");
        Schema schema = schemaFactory.newSchema(schemaFile);

        unmarshaller.setSchema(schema);

        return (Plan) unmarshaller.unmarshal(new FileInputStream(file));

    }
}
