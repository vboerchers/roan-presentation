package scriptlib

import org.freeplane.plugin.script.proxy.Proxy

class AddonTranslation {
static void exportToChildren(Proxy.Node node){
	List li=node.attributes.getAttributeNames()
	li.each{
		Proxy.Node attr=node.createChild()
		attr.text=it
		attr.details=node[it]		
	}
}

static void importFromChildren(Proxy.Node node){
	node.children.each{ node[it.text]=it.details}
	}

static void clearAttributes(Proxy.Node node){ node.attributes.clear()}

static void sortChildren(Proxy.Node node){ MenuFreeplane.executeMenuActions(['$SortNodes$0'])}
}
