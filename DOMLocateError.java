import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class DOMLocateError{
	static public void main(String[] arg){
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter File name: ");
			String xmlFile = bf.readLine();
			File file = new File(xmlFile);
			if(file.exists()){
				// Create a new factory
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				// Use the factory to create builder document.
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(xmlFile);
				System.out.println(xmlFile + " is well-formed!");
			}
			else{
				System.out.print("File not found!");
			}
		}
		catch (SAXParseException e) {
			System.out.println("type" + ": " + e.getMessage()+"\n");
			System.out.println("Line " + e.getLineNumber() + " Column "+ e.getColumnNumber());
		}
		catch (SAXException e) {
			System.err.println(e);
			System.exit(1);
		}
		catch (ParserConfigurationException e) {
			System.err.println(e);
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}
}