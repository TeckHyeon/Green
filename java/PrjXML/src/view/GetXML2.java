package view;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetXML2 {

	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException {
		// XML parsing 라이브러리 준비
		DocumentBuilderFactory  factory  = DocumentBuilderFactory.newInstance();
		DocumentBuilder         builder  = factory.newDocumentBuilder();
		
		// xml -> Document 로 파싱하기
		// org.w3c.dpm.Document import
		Document                document = builder.parse("src/data/data2.xml");
		
		Element                 root     = document.getDocumentElement();
		System.out.println( root.getNodeName() );
				
		// customer 의 자식노드 전체를 검색
		NodeList    childList  =  root.getChildNodes();  
		
		for (int i = 0; i < childList.getLength(); i++) {
			NodeList   itemList  =  childList.item(i).getChildNodes(); 
			
			for (int j = 0; j < itemList.getLength(); j++) {
				Node   item      =  itemList.item(j); 
				if( item.getNodeType()  == Node.ELEMENT_NODE ) {				
					System.out.print( item.getNodeName() + " : " );
					System.out.println( item.getTextContent() );
				} else {
					//System.out.println("space character 입니다");
				}
				
			}
		}
		
	}

}




























