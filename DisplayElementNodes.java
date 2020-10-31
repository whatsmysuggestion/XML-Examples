import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.transform.*; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;

public class DisplayElementNodes {
	static public void main(String[] arg){
		try{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter a XML file name: ");
			String xmlFile = bf.readLine();
			File file = new File(xmlFile);
			if (file.exists()){
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(xmlFile);
				TransformerFactory tranFactory = TransformerFactory.newInstance(); 
				Transformer aTransformer = tranFactory.newTransformer(); 
				// Get nodes list of all elements
				NodeList list = doc.getElementsByTagName("*");
				for (int i=0; i<list.getLength(); i++){
					// Get element
					Element element = (Element)list.item(i);
					Source src = new DOMSource(element); 
					System.out.println("Node no: " + i + " is " + element.getNodeName());
					System.out.println( "Its corresponding xml representation:");
					Result dest = new StreamResult(System.out);
					aTransformer.transform(src, dest);
					System.out.println("\n");
				}
			}
			else{
				System.out.println(xmlFile + " (file name) doesn't found!");
			}
		}
		catch (Exception e){
			e.getMessage();
		}
	}
}