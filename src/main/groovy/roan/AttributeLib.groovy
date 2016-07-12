package roan
//Author Jodi D.Krol 2014-06

import org.freeplane.plugin.script.proxy.Proxy;

public class AttributeLib {
	
	 static Boolean isAttribute(Proxy.Node node,String key,String value){
		 return (node[key]!=null && node[key]==value)
	 }
	
	static void deleteIfEmpty(Proxy.Node node){
		 node.attributes.names.each{if (node[it]=="")  def dummy=node.attributes.removeAll(it) }
	 }
	
	static void deleteIfValue(Proxy.Node node, def value){
		node.attributes.names.each{if (node[it]==value)  def dummy=node.attributes.removeAll(it) }
	}
	
}
