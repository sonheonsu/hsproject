package openapi;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class TEs {
	private String xmlData;
	private File file;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document doc;
	StringBuffer makeHtml;

	private final static String API_KEY = "4d4f666f6168656f39344871696e5a";
	
	
	public static void main(String[] args) {
		ArrayList<Cinema> c;

		TEs e = new TEs();
	
		for (int i = 0; i < 10; i++) {
			c = e.parseUtil(i+"");
			System.out.println(i+"호선");
			for(Cinema cinema : c){
				System.out.print(cinema.getAddress()+"\t");
			}
			System.out.println();
		}
		

		
		
	}


	// Search API Parsing
	public ArrayList<Cinema> parseUtil(String line){
//		System.out.println(query);

		String _urlStr = "http://openAPI.seoul.go.kr:8088/"+API_KEY+"/xml/SearchSTNBySubwayLineService/1/200/"+line+"/";

		Cinema cinema = null;

		try 
		{
			URL url = new URL(_urlStr);
			InputSource is = new InputSource(url.openStream());

			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			doc.getDocumentElement().normalize();

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		NodeList itemNodeList = doc.getElementsByTagName("row");
		ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();

		
//		System.out.println(itemNodeList.getLength());
		
		
		for (int s = 0; s < itemNodeList.getLength(); s++) 
		{
			
			Node itemNode = itemNodeList.item(s);

			if (itemNode.getNodeType() == Node.ELEMENT_NODE) 
			{
				

				Element itemElement = (Element) itemNode;

				//title
				NodeList titleNodeList = itemElement
						.getElementsByTagName("STATION_NM");
				Element titleElement = (Element) titleNodeList.item(0);
				NodeList childTitleNodeList = titleElement.getChildNodes();
				String title = ((Node) childTitleNodeList.item(0)).getNodeValue();

				// address
				NodeList addressNodeList = itemElement
						.getElementsByTagName("STATION_NM");
				Element addresssElement = (Element) addressNodeList.item(0);
				NodeList childAddressNodeList = addresssElement.getChildNodes();
				String address = ((Node) childAddressNodeList.item(0)).getNodeValue();

				// link
				NodeList linkNodeList = itemElement
						.getElementsByTagName("STATION_NM");
				Element linkElement = (Element) linkNodeList.item(0);
				NodeList childLinkNodeList = linkElement.getChildNodes();
				String link = ((Node) childLinkNodeList.item(0)).getNodeValue();

				//mapX
				NodeList mapxNodeList = itemElement
						.getElementsByTagName("STATION_NM");
				Element mapxElement = (Element) mapxNodeList.item(0);
				NodeList childmapXNodeList = mapxElement.getChildNodes();
				String mapX = ((Node) childmapXNodeList.item(0)).getNodeValue();

				//mapY
				NodeList mapyNodeList = itemElement
						.getElementsByTagName("STATION_NM");
				Element mapyElement = (Element) mapyNodeList.item(0);
				NodeList childmapyNodeList = mapyElement.getChildNodes();
				String mapY = ((Node) childmapyNodeList.item(0)).getNodeValue();

				cinema = new Cinema(title, mapX, mapY,address,link);
				cinemaList.add(cinema);

			}
		}
		return cinemaList;
	}
}
