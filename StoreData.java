import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.transform.*; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;

public class StoreData{
	static public void main(String[] arg) {
		try{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter XML file name: ");
			String xmlFile = bf.readLine();
			File file = new File(xmlFile);
			if (file.exists()){
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(xmlFile);
//				Create transformer
				Transformer tFormer = TransformerFactory.newInstance().newTransformer();
//				Output Types (text/xml/html)
				tFormer.setOutputProperty(OutputKeys.METHOD, "text");
//				Write the document to a file
				Source source = new DOMSource(doc);
//             
				Result result = new StreamResult(new File("vk.txt"));
				tFormer.transform(source, result);
				System.out.println("File creation successfully!");
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