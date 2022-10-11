package com.example.Parking_XML1;

import java.io.File;



import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException
    {
    	Parking user= new Parking();
        user.setLatitude(100);
        user.setLongitude(100);
        user.setNbSpots(50);
        user.setSpotsavailable(20);
        JAXBContext contextObj = JAXBContext.newInstance(Parking.class);  
        Marshaller m= contextObj .createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
        File file =new File("/home/hussein/Desktop/park.xml");
        m.marshal(user, file);   
    }
}
