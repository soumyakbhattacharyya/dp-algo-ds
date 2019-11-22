package workshop.dp;

import java.io.IOException;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import workshop.dp.Factory.Door;
import workshop.dp.FactoryMethod.URL_;

public class Runner {

	/*
	 * 
	 */
	public static void main(String[] args) throws IOException, ParserConfigurationException {

		/*
		 * 
		 * Factory
		 * 
		 */
		Door woodenDoor = Factory.create("wood", 80, 24);
		System.out.println("1) built " + woodenDoor);

		/*
		 * 
		 * Factory Method
		 * 
		 */

		// Typical Flow (or more technically Template Methods)

		// define the resource
		URL_ url = new URL_("http://", "localhost", 1100);

		// set factory to read the resource
		url.setURLStreamHandlerFactory(new FactoryMethod.URLStreamHandlerFactoryImpl());

		// connect using appropriate handler
		URLConnection connection = url.openConnection();

		// read
		// connection.getInputStream(); <- actual reader; commented out

		/*
		 * 
		 * Abstract Factory
		 * 
		 */

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();

		System.out.println(dbf.getClass());
		System.out.println(db.getClass());

		// Observe both of DocumentBuilderFactory & DocumentBuilder are abstract classes
		// at runtime, concrete implementations for both of these classes are being
		// supplied. The BuilderFactory and Builder instances can vary based on the
		// concrete implementations, however the contract remains enforced by the model

		/*
		 * 
		 * Builder
		 * 
		 */
		StringBuilder sb = new StringBuilder("INIT");
		String result = sb.append(true).append('J').append(new char[] { 'a', 'b' }).toString();
		System.out.println(result);

		/*
		 * 
		 * Prototype
		 * 
		 */
		// an object can create a copy (shallow/deep) of itself, provided it implements
		// Clonaeble

		/*
		 * 
		 * Singleton
		 * 
		 */

		Runtime runtime = Runtime.getRuntime();

	}

}
