import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.transform.*; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;

public class RemoveElement {
	static public void main(String[] arg) {
		try{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter a XML file name: ");
			String xmlFile = bf.readLine();
			File file = new File(xmlFile);
			System.out.print("Enter an element which have to delete: ");
			String remElement = bf.readLine();
			if (file.exists()){
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(xmlFile);
				TransformerFactory tFactory = TransformerFactory.newInstance();
				Transformer tFormer = tFactory.newTransformer();
				
				Element element = (Element)doc.getElementsByTagName(remElement).item(0);
//				Remove the node
				element.getParentNode().removeChild(element);
//              Normalize the DOM tree to combine all adjacent nodes
				doc.normalize();
				Source source = new DOMSource(doc);
				Result dest = new StreamResult(System.out);
				tFormer.transform(source, dest);
				System.out.println();
				
				
			}
			else{
				System.out.println("File not found!");
			}
		}
		catch (Exception e){
			System.err.println(e);
			System.exit(0);
		}
	}
}