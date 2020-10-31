import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.transform.*; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;

public class DOMCloneElements {
	static public void main(String[] arg){
		try	{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter XML file name: ");
			String xmlFile = bf.readLine();
			File file = new File(xmlFile);
			if (file.exists()){
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(xmlFile);
				TransformerFactory tFactory = TransformerFactory.newInstance();
				Transformer tformer = tFactory.newTransformer();
				Source source = new DOMSource(doc);
				Result result = new StreamResult(System.out);
				System.out.println(xmlFile + " file: ");
				tformer.transform(source, result);
				System.out.println();
				System.out.print("Enter the element to clone: ");
				String clone = bf.readLine();
				System.out.print("Enter data to add: ");
				String addElement = bf.readLine();
				NodeList list = doc.getElementsByTagName(clone);
				Element element1 = (Element)list.item(0);
				Element copyElement = (Element) element1.cloneNode(true);
				element1.getParentNode().insertBefore(copyElement, element1.getNextSibling());
				element1.appendChild(doc.createTextNode(addElement));
				tformer.transform(source, result);
			}
			else{
				System.out.println("File not found!");
			}
		}
		catch (Exception e){
			e.getMessage();
		}
	}
}