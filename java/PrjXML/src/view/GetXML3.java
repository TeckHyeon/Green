package view;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetXML3 {

	public static void main(String[] args) 
			throws SAXException, IOException, ParserConfigurationException {
		
		DocumentBuilderFactory  factory  = DocumentBuilderFactory.newInstance();
		DocumentBuilder         builder  = factory.newDocumentBuilder();
		
		Document                document = builder.parse("src/data/data3.xml");
		
		Element                 root     = document.getDocumentElement();
		System.out.println( root.getNodeName() );
		
		NodeList               nodeList  = root.getChildNodes();
		//System.out.println( nodeList.getLength() ); //7
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			NodeList    itemList  =  nodeList.item(i).getChildNodes();
			
			for (int j = 0; j < itemList.getLength() ; j++) {
				Node   item  = itemList.item(j);
				switch(  item.getNodeType() ) {
				case Node.ELEMENT_NODE : // enum
					if( item.hasAttributes()  ) {
						NamedNodeMap map = item.getAttributes();
						for (int k = 0; k < map.getLength(); k++) {
							Node attrNode = map.item(k); 
							String  key = attrNode.getNodeName();
							String  val = attrNode.getNodeValue();							
							System.out.println(key + " : " + val);							
						}
					}
					System.out.print( item.getNodeName()    + " : " );
					System.out.print( item.getTextContent() + "\n" );
					break;				
				case Node.TEXT_NODE:						
					//System.out.println("공백문자");					
				}						
			}
			
		}

	}

}












