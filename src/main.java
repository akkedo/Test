import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class main {
	public static void main(String[] args){
		readXML();		
	}
	
	public static void readXML(){
		SAXBuilder builder = new SAXBuilder();
		Document doc;
		try {
			doc = builder.build("./src/test.xml");
			Element root = doc.getRootElement();
							
			List<Element> bookList = root.getChildren( "schule" );
			for( Element element : bookList ) { 
			 String category = element.getAttributeValue( "fach" );
			 String lehrer = element.getChildTextTrim( "lehrer" );
			 String stunden = element.getChildTextTrim( "stunden" );
			 
			 System.out.println("Fach : \t"+category);
			 System.out.println("Lehrer : \t"+lehrer);
			 System.out.println("Stunden : \t"+stunden);
			}
			
			   // Let's add a new node
			   Element book = new Element( "book" );
			   book.setAttribute( "category", "computer-programming" );
			   Element author = new Element( "author" );
			   author.addContent( "Steven Haines" );
			   Element title = new Element( "title" );
			   title.addContent( "Pro Java EE 5 Performance Management and Optimization" );
			   Element price = new Element( "price" );
			   price.addContent( "49.95" );
			   book.addContent( author );
			   book.addContent( title );
			   book.addContent( price );
			   root.addContent( book );
			   // Write the contents out to a new file
			   XMLOutputter outputter = new XMLOutputter( Format.getPrettyFormat() );
			   outputter.output( root, new FileOutputStream( "out.xml" ) );
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
