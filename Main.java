import javax.xml.xpath.*;
import org.xml.sax.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import javax.xml.namespace.*;

class Main{
 private static final XPath xpath = XPathFactory.newInstance().newXPath();
 private static XPath getXPath(){
	return xpath;
 }

 private static void searcher(String str) throws Exception {
	String elname[] = new String[]
			{"symbol","name","number","group","period","noid"};
	for(String e : elname){
	 String formula = "/*/*[@"+e+"='"+str+"']";
	 NodeList nodes
	  = (NodeList) getXPath().evaluate(formula,
					  new InputSource(new FileInputStream("database.xml")),
					  XPathConstants.NODESET);
	 printResult(nodes);
	}
 }

 private static void printResult(NodeList nodes) throws Exception {
	for(int i = 0; i < nodes.getLength(); i++){
	 System.out.print(((Element)nodes.item(i)).getAttribute("number")+":");
	 System.out.print(((Element)nodes.item(i)).getAttribute("symbol")+" ");
	 System.out.println(((Element)nodes.item(i)).getAttribute("name"));
	}
 }

 public static void main(String[] args) throws Exception {
	Scanner scan = new Scanner(System.in);
	boolean f = true;
	System.out.println("--元素周期表データベース--");
	while(f){
		System.out.print(">");
		String str = scan.next();
		if(str.equals("exit")||str.equals("終了"))
		 f = false;
		else{
		 searcher(str);
		 System.out.println();
		}
	}
 }

}
