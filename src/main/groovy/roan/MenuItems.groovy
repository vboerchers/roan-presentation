package roan
 // Residue to move elsewhere
import org.freeplane.core.resources.ResourceController
import org.freeplane.features.attribute.AttributeController
import org.freeplane.features.attribute.ModelessAttributeController
import org.freeplane.features.map.MapModel
import org.freeplane.features.mode.Controller
import org.freeplane.features.mode.ModeController
import org.freeplane.features.styles.MapStyle
import org.freeplane.features.ui.UIComponentVisibilityDispatcher
import org.freeplane.view.swing.map.NodeTooltipManager

import scriptlib.NodeLib
 
class MenuItems{// extends MapProxy{
	
	//static final String key_greyBackground="greyBackground"
	//static final String key_on="T"
	//static final String key_off="F"
	
	private static final String PRESENTATION_MODE_ENABLED = "presentation_mode"
	
	//String toString(){"MenuItems[fullScreen=$isFullScreen;tooltips=$isTooltips;attributes=$isAttributes;attributesIcon=$isAttributesIcon;presentationMode=$isGreyBackground]"}

	static Boolean getIsStatusBar(){
		return UIComponentVisibilityDispatcher.dispatcher(Controller.getCurrentController().getViewController().getStatusBar()).isVisible()
	}

	static Boolean getIsTooltips(){
		ResourceController.getResourceController().getBooleanProperty(NodeTooltipManager.RESOURCES_SHOW_NODE_TOOLTIPS)
	}
	
	static Boolean getIsAttributesIcon(){
	   def node=NodeLib.root.delegate
		ModeController modeController = Controller.getCurrentController().getModeController();
		final String showAttributeIcon = MapStyle.getController(modeController).getPropertySetDefault(node.getMap(), AttributeController.SHOW_ICON_FOR_ATTRIBUTES);
		final boolean showIcon = Boolean.parseBoolean(showAttributeIcon);
		return showIcon
	}
	
	static Boolean getIsAttributes() {
		final MapModel map = Controller.getCurrentController().getMap();
		def state= ModelessAttributeController.getController().getAttributeViewType(map);
		return state!="hide"
	}
}
	
	
