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

public class GetXml {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// XML parsing 라이브러리 준비
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// xml -> Document 로 파싱하기
		// org.w3c.dpm.Document import
		Document document = builder.parse("src/data/data3.xml");
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());
		// root 요소의 첫번째 노드는 #text :
		// Enter -> data의 가공이 필요 :
		// 모든 enter 공백을 제거
		Node firstNode = root.getFirstChild();
		System.out.println(firstNode.getNodeName() // #text
				+ "," + firstNode.getNodeValue() // 엔터와 공백 \n
				+ "," + firstNode.getNodeType()); // 3: text
		// enter의 다음 node를 찾는다
		Node customer = firstNode.getNextSibling();
		System.out.println(customer.getNodeName() // customer
				+ "," + customer.getNodeValue() + // null
				"," + customer.getNodeType()); // 1 : Element
		// customer 의 자식 노드 전체를 검색
		NodeList childList = customer.getChildNodes();
		System.out.println(childList.getLength());
		for (int i = 0; i < childList.getLength(); i++) {
			Node item = childList.item(i);
			if(item.getNodeType() == 1) {
			System.out.print(item.getNodeName() + " :");
			System.out.println(item.getTextContent());
			} else {
				System.out.println("space character 입니다");
			};
		}
	}
}
