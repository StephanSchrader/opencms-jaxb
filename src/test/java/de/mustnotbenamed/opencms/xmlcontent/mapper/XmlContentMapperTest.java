package de.mustnotbenamed.opencms.xmlcontent.mapper;

import com.alkacon.bootstrap.schemas.OpenCmsBootstrapBlog;
import com.alkacon.bootstrap.schemas.OpenCmsBootstrapBlogs;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import javax.xml.bind.JAXBElement;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

public class XmlContentMapperTest {

    @Test
    public void unmarshal() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/blogentries/be_00002.xml");
        JAXBElement<OpenCmsBootstrapBlogs> element = new XmlContentMapper().unmarshal(inputStream, OpenCmsBootstrapBlogs.class);

        assertThat(element.getValue(), notNullValue());
    }

    @Test
    public void dump_OpenCmsBootstrapBlog() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/blogentries/be_00002.xml");
        OpenCmsBootstrapBlogs blogs = new XmlContentMapper().unmarshal(inputStream, OpenCmsBootstrapBlogs.class).getValue();

        List<OpenCmsBootstrapBlog> blogList = blogs.getBootstrapBlog();
        assumeThat(blogList, hasSize(greaterThan(0)));

        String dump = ReflectionToStringBuilder.toString(blogList.get(0), ToStringStyle.MULTI_LINE_STYLE, false, true);
        System.out.println(dump);
    }

}