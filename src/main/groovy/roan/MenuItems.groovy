package roan
 // Residue to move elsewhere
import javax.swing.JComponent;
import javax.swing.SwingUtilities

import org.freeplane.core.resources.ResourceController;
import org.freeplane.features.styles.MapStyle;
import org.freeplane.features.ui.ViewController;
import org.freeplane.features.map.MapModel;
import org.freeplane.features.mode.Controller;
import org.freeplane.features.attribute.AttributeController;
import org.freeplane.features.attribute.ModelessAttributeController;
import org.freeplane.features.mode.ModeController
import org.freeplane.view.swing.map.NodeTooltipManager
import org.freeplane.features.filter.FilterController
import scriptlib.NodeLib
import scriptlib.MenuFreeplane
import scriptlib.FilterLib
import scriptlib.WindowLib
 
class MenuItems{// extends MapProxy{
	
	//static final String key_greyBackground="greyBackground"
	//static final String key_on="T"
	//static final String key_off="F"
	
	private static final String PRESENTATION_MODE_ENABLED = "presentation_mode"
	MenuItems(){}
	
	//String toString(){"MenuItems[fullScreen=$isFullScreen;tooltips=$isTooltips;attributes=$isAttributes;attributesIcon=$isAttributesIcon;presentationMode=$isGreyBackground]"}
	
	static Boolean getIsStatusBar(){
		String toolbarName="/status"
		final JComponent toolBar = Controller.getCurrentModeController().getUserInputListenerFactory().getToolBar(toolbarName);
		final boolean isVisible = Controller.getCurrentController().getViewController().isToolbarVisible(toolBar);
		return isVisible
		//final String propertyName = Controller.getCurrentController().getViewController().completeVisiblePropertyKey(toolBar);
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
	
	
