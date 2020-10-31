import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.transform.*; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;

public class AddDocType{
	static public void main(String[] args){
		try{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter XML file name: ");
			String xmlFile = bf.readLine();
			System.out.println();
			File file = new File(xmlFile);
			if (file.exists()){
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(xmlFile);
//				Create transformer
				Transformer tFormer = TransformerFactory.newInstance().newTransformer();
//				Set system id
				//tFormer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "systmId");
//				Set public id
				tFormer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "publicId");
				Source source = new DOMSource(doc);
				Result result = new StreamResult(System.out);
				tFormer.transform(source, result);
				System.out.println();
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