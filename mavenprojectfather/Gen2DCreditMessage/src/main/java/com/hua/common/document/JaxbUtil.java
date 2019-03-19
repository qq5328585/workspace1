package com.hua.common.document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JaxbUtil {

    public static String convertToXml(Object object){
        return  convertToXml(object,"UTF-8");
    }

    public static String convertToXml(Object obj,String encoding){
        String result = null;
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING,encoding);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT,true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(obj,stringWriter);
            result = stringWriter.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static <T>T conVeryToJavaBean(String xml,Class<T> c){
        T t = null;
        try{
          JAXBContext jaxbContext = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            t= (T) unmarshaller.unmarshal(new StringReader(xml));
        }catch (Exception e){
            e.printStackTrace();
        }
        return  t;
    }

}
