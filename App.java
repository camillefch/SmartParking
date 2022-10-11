package com.example.Parking_Json;

import java.io.IOException;

/**
 * THIS ISS FOR JSONNNNN
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
       Parser parse =new Parser();
       parse.run(null);
    }
}



/** this is for parsing into xml
 * public class App 
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
 *
 */
