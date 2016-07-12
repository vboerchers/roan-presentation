package roan
//Author Jodi D.Krol 2014-06
import org.freeplane.plugin.script.proxy.Proxy
import scriptlib.NodeLib
import scriptlib.StyleLib
import scriptlib.Message

class Translate {
	
	
	static String initMessage=Message.textUtils.getText(
	"addons.roan.initMessage",
	"Menu actions performed:\nIcon for attributes is hidden.\n All attributes are hidden.\n Root attribute 'presentation' set "
)
	static final String sliderTooltip=Message.textUtils.getText(
		"addons.roan.sliderTooltip",
		"<html>Nr of seconds selected node displays.<br>Change slider for new value for selected node(s).<br>Value in root node determines default."
		)
	
	static final String playTitle=Message.textUtils.getText(
		"addons.roan.playTitle",
		"Play nodes"
		)
	static final String stepTitle=Message.textUtils.getText(
		"addons.roan.stepTitle",
		"Step next node"
		)
	
	static final String stopTitle=Message.textUtils.getText(
		"addons.roan.stopTitle",
		"Stop playing"
		)
	
	static final String attributes_OnTitle=Message.textUtils.getText(
		"addons.roan.attributes_OnTitle",
		"Hide attributes"
		)
	
	static final String attributes_OffTitle=Message.textUtils.getText(
		"addons.roan.attributes_OffTitle",
		"Show attributes"
		)
	
	static final String state_OnTitle=Message.textUtils.getText(
		"addons.roan.state_OnTitle",
		"Hide icon if node has states defined"
		)
	static final String state_OffTitle=Message.textUtils.getText(
		"addons.roan.state_OffTitle",
		"Show icon signalling that node has states defined"
		)
	///
	
	static final String init=Message.textUtils.getText(
		"addons.roan.init",
		"Initialize mind map"
		)
	
	static final String helpTitle=Message.textUtils.getText(
		"addons.roan.helpTitle",
		"Help"
		)
	
	static final String lockTitle=Message.textUtils.getText(
		"addons.roan.lockTitle",
		"Set password on map (encrypt)"
		)
	
	static final String homeTitle=Message.textUtils.getText(
		"addons.roan.homeTitle",
		"RoAn-Home: Select and fold root"
		)
	
	static final String menuTitle=Message.textUtils.getText(
		"addons.roan.menuTitle", //delete menunode action
		"RoAn-Presentation"
		)
	static final String editTitle=Message.textUtils.getText(
		"addons.roan.editTitle", //delete menunode action
		"Roan-Edit"
		)
	
	static final String imageTitle=Message.textUtils.getText(
		"addons.roan.imageTitle", //delete menunode action
		"Insert inline image in selected node"
		)
	
	static final String indexTitle=Message.textUtils.getText(
		"addons.roan.indexTitle", 
		"Index the directory the mindmap is in"
		)
	
	static final String grey_OnTitle=Message.textUtils.getText(
		"addons.roan.grey_OnTitle", //delete menunode action
		"Remove grey background"
		)
	
	static final String grey_OffTitle=Message.textUtils.getText(
		"addons.roan.grey_OffTitle", //delete menunode action
		"Set grey background"
		)
	
	static final String backTitle=Message.textUtils.getText(
		"addons.roan.backTitle", //delete menunode action
		"Step back in sequence"
		)
	
	static final String tooltip_OnTitle=Message.textUtils.getText(
		"addons.roan.tooltip_OnTitle", //delete menunode action
		"Hide tooltip"
		)
	static final String tooltip_OffTitle=Message.textUtils.getText(
		"addons.roan.tooltip_OffTitle", //delete menunode action
		"Show tooltip"
		)
	static final String fullScreenOnTitle=Message.textUtils.getText(
		"addons.roan.fullScreenOnTitle",
		"Edit screen: Show Freeplane menu bars"
		)
	static final String fullScreenOffTitle=Message.textUtils.getText(
		"addons.roan.fullScreenOffTitle",
		"Play screen: hide Freeplane menu bars"
		)
	static final String plusSizeTitle=Message.textUtils.getText(
		"addons.roan.plusSizeTitle",
		"Minimize window"
		)
	static final String minSizeTitle=Message.textUtils.getText(
		"addons.roan.minSizeTitle",
		"Maximize window"
		)
	
	
	static final String filter_OnTitle=Message.textUtils.getText(
		"addons.roan.filter_On",
		"Filter during presentation"
		)
	static final String filter_OffTitle=Message.textUtils.getText(
		"addons.roan.filter_Off",
		"Stop filtering presentation"
		)
	
	static final String autoZoom_OnTitle=Message.textUtils.getText(
		"addons.roan.autoZoom_On",
		"Zoom in and out"
		)
	static final String autoZoom_OffTitle=Message.textUtils.getText(
		"addons.roan.autoZoom_Off",
		"Do not zoom in and out"
		)
}
