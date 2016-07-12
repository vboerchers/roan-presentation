package roan
//Author Jodi D.Krol 2014-06
import scriptlib.NodeLib
import scriptlib.StringLib
import scriptlib.AThread
import org.freeplane.plugin.script.proxy.Proxy

class Navigate {



static Proxy.Node backNode(Proxy.Node node){
	def currentNode=Controller.current.currentNodeInRootAndInit 
	if(currentNode!=null) node=currentNode
	
	String nodeStr=Controller.leftStr(node)
	if (Controller.debug) println "DEBUG: backNode $nodeStr"
	
	if (node==null) return null
	else{
		Data data=new Data(node)
		Controller.current.setStateAndDelay(data, Data.State.BACK)
		Proxy.Node nextSibling=next_Sibling(node)
		if (node==NodeLib.root) return NodeLib.root
		else if(nextSibling==null) { 
			if (Controller.debug) println "DEBUG: BACK parent $node.parent.text";
			return backNode(node.parent)}
		else return nextSibling
		}
	}

static Proxy.Node next_Sibling(Proxy.Node node){
	 def currentNode=Controller.current.currentNodeInRootAndInit 
	  if(currentNode!=null) node=currentNode
		if (node==null) return null
		else if (node==NodeLib.root) return next_FirstChild(node)
		else if (node.parent==null) return null
		else {
			ArrayList children = node.parent.children

			if (node.parent==NodeLib.root) children=Controller.current.rootChildrenRightLeft(children)
		
			if (children==null||children==[]) return null
			else{
				Integer i=children.indexOf(node)
				if (i!=-1 && i+1< children.size())  return children.get(i+1) else return null
				}
		}
	}


static Proxy.Node next_FirstChild(Proxy.Node node){
	def currentNode=Controller.current.currentNodeInRootAndInit 
	if(currentNode!=null) node=currentNode
	
	if (node==null) return null
	//else if(node==NodeLib.root) next_FirstChildRightElseLeftOfRoot()
	else{
	ArrayList children=node.children
	if (node==NodeLib.root) children=Controller.current.rootChildrenRightLeft(children) 
	if (children!=null && children !="") return children[0] else return null
	}
}

// niet gebruikt...
static Boolean isPrevious(Data data, Proxy.Node node){//already passed, cycle
	if (data==null||data.history.previous==null) { return false}
	else if(data.history.previous.node==node) {return true}
	else return isPrevious(data.history.previous,node)
}
}

