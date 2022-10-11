package com.example.Parking_Json;

import java.io.File;
import java.io.IOException;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Parser {
	  public void run(String[] args) throws IOException {
		  ObjectMapper objectMapper = new ObjectMapper();
		  Parking park= new  Parking(1, 100, 50, 100);
		  objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		  objectMapper.writeValue(new File("/home/hussein/Desktop/Parking.json"), park);
	  }
}
