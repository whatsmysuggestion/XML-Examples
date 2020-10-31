import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class DOMParserCheck {
	static public void main(String[] arg){
		try{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter File name: ");
			String xmlFile = bf.readLine();
			File file = new File(xmlFile);
			if(file.exists()){
				try {
	DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = dBF.newDocumentBuilder();
	InputSource is = new InputSource(xmlFile);
	Document doc = builder.parse(is);
	System.out.println(xmlFile + " is well-formed!");
				}
				catch (Exception e) {
					System.out.println(xmlFile + " isn't well-formed!");
					System.exit(1);
				}
			}
			else{
				System.out.print("File not found!");
			}
		}
		catch(IOException io){
			io.printStackTrace();
		}
	}
}