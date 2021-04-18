package de.mustnotbenamed.opencms.xmlcontent.mapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author schrader
 */
public class XmlContentMapper {

    public <T> JAXBElement<T> unmarshal(byte[] content, Class<T> aClass) throws JAXBException {
        return unmarshal(new ByteArrayInputStream(content), aClass);
    }

    public <T> JAXBElement<T> unmarshal(InputStream inputStream, Class<T> aClass) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(aClass);
        Unmarshaller u = jc.createUnmarshaller();

        return u.unmarshal(new StreamSource(inputStream), aClass);
    }

}
