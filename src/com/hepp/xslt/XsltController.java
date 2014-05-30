package com.hepp.xslt;

import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * A simple class to demonstrate howto use XSLT with java.
 * 
 * @author elmar.hepp@gmail.com
 *
 */
public class XsltController {

	public static void main(String[] args) {

		XsltController controller = new XsltController();
		controller.start();
	}

	private void start() {
		System.out.println("XsltController1 start");

		String filenameXslt = "transform.xslt";
		String inputXml = "input.xml";
		String output = "output.html";

		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Source xslt = new StreamSource(new File(filenameXslt));
			Transformer transformer = factory.newTransformer(xslt);

			Source input = new StreamSource(new File(inputXml));
			transformer.transform(input, new StreamResult(new File(output)));
		} catch (TransformerConfigurationException e) {
			System.err.println("TransformerConfigurationException for file " + filenameXslt + ", "
					+ e);
		} catch (TransformerException e) {
			System.err.println("TransformerException: " + e);
		}

		System.out.println("XsltController1 end");
	}

}
