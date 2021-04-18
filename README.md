## OpenCms Schema

Generate *opencms-xmlcontent.xsd* at runtime. Create a JSP inside the workplace and copy into: 

    org.opencms.xml.CmsXmlEntityResolver resolver = new org.opencms.xml.CmsXmlEntityResolver(null);
    org.xml.sax.InputSource source = resolver.resolveEntity(null, org.opencms.xml.CmsXmlContentDefinition.XSD_INCLUDE_OPENCMS);
    byte[] bytes = org.opencms.util.CmsFileUtil.readFully(source.getByteStream());
    String xsd = org.opencms.i18n.CmsEncoder.createString(bytes, "UTF-8");

## Catalog File

In combination with catalogs, you can make JAXB use a.xsd inside a-XXX.jar instead of https://example.org/a.xsd.

    REWRITE_SYSTEM "https://example.org/a.xsd" "maven:org.example:a!/a.xsd"
