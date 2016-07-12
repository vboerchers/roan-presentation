package scriptlib
//Author Jodi D.Krol 2014-04-11
import org.freeplane.plugin.script.proxy.Proxy
import org.freeplane.plugin.script.proxy.Proxy.Controller
class Globals {
	Globals(){}
	static Globals current=new Globals()
	
	private Controller c
	private Controller script_c //redundant??
	private Proxy.Node script_node
	//NodeLib nodeLib=new NodeLib()

	Globals init(Controller c, Proxy.Node node){
		this.c=c
		script_c=c
		script_node=node
		return this
	}
	
	Controller getC(){
		assert(script_c!=null):"ERROR: Controller scriptlib not inited"
		return script_c
	}
	
	Proxy.Node getNode(){
		assert(script_c!=null):"ERROR: Controller scriptlib not inited"
		return script_node
	}
}
