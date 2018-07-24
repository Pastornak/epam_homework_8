package com.epam.lab.xml.homework.validator;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class XMLValidator {

	public static boolean validateAgainstXSD(String xmlFilename, String xsdFilename)
	{
	    try
	    {
	    	InputStream xml = new FileInputStream(xmlFilename);
			InputStream xsd = new FileInputStream(xsdFilename);
	        SchemaFactory factory = 
	            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	        Schema schema = factory.newSchema(new StreamSource(xsd));
	        Validator validator = schema.newValidator();
	        validator.validate(new StreamSource(xml));
	        return true;
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    return false;
	}
}
