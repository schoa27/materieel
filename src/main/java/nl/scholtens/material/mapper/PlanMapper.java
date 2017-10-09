package nl.scholtens.material.mapper;

import nl.scholtens.material.sources.Plan;
import org.springframework.core.io.ClassPathResource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;
import java.io.*;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;


public class PlanMapper {

    public Plan mapPlan(String file) throws JAXBException, JAXBException, SAXException, IOException {
        JAXBContext ctx = JAXBContext.newInstance("nl.scholtens.material.sources");
        Unmarshaller unmarshaller = ctx.createUnmarshaller();

        SchemaFactory schemaFactory = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
       
        unmarshaller.setSchema(schemaFactory.newSchema(getSchema()));

        return (Plan) unmarshaller.unmarshal(new FileInputStream(file));
    }

    private File getSchema() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("xsd/loc.xsd");
        InputStream inputStream = classPathResource.getInputStream();

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);

        File targetFile = new File("loc.xsd");
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);
        return targetFile;
    }

}
