package scriptlib
//Author Jodi D.Krol 2014-03
import org.freeplane.features.cloud.CloudController;
import org.freeplane.features.cloud.mindmapmode.MCloudController;
import org.freeplane.features.map.FoldingController
import org.freeplane.features.map.NodeModel;
import org.freeplane.features.nodestyle.NodeStyleModel
import org.freeplane.features.nodestyle.mindmapmode.MNodeStyleController;
import org.freeplane.features.mode.Controller;
import org.freeplane.features.mode.ModeController
import org.freeplane.features.nodestyle.NodeStyleController;
import org.freeplane.plugin.script.proxy.Proxy
import org.freeplane.view.swing.map.NodeView;
import org.freeplane.view.swing.map.attribute.AttributeTable;
import org.freeplane.view.swing.map.attribute.AttributeTableModelDecoratorAdapter;
import org.freeplane.view.swing.map.attribute.AttributeView;
import org.freeplane.plugin.script.proxy.EdgeProxy //??
import javax.swing.SwingUtilities

import java.awt.Color

import javax.swing.table.JTableHeader;

import org.freeplane.features.cloud.CloudModel
import org.freeplane.features.edge.EdgeStyle;
/*
public enum EdgeStyle {
	EDGESTYLE_BEZIER("bezier", 1f), EDGESTYLE_HIDDEN("hide_edge", 1f), EDGESTYLE_HORIZONTAL("horizontal", 1f),
	EDGESTYLE_LINEAR("linear", 1f), EDGESTYLE_SHARP_BEZIER("sharp_bezier", 0.25f), EDGESTYLE_SHARP_LINEAR("sharp_linear", 0f),
	EDGESTYLE_SUMMARY("summary", 1f);
	private String name;
	private float nodeLineWeight;
	*/
import org.freeplane.features.nodestyle.NodeStyleModel;

// Zie package org.freeplane.plugin.script.proxy.Proxy !!!

class StyleLib {

	static void setButtonStyle(Proxy.Node node){
		setBubble(node)
		setGray(node)
		node.style.font.setSize(8)
		node.style.font.setItalic(true)
	}
	
	static void setBubble (Proxy.Node node){
		setStyle(node,NodeStyleModel.STYLE_BUBBLE)
	}
	static void setFork(Proxy.Node node){
		setStyle(node,NodeStyleModel.STYLE_FORK)
	}
	
	static void setStyle(Proxy.Node node, String style){
		final MNodeStyleController styleController = (MNodeStyleController) Controller
		.getCurrentModeController().getExtension(
				NodeStyleController.class);
			styleController.setShape(node.delegate,style)
	}
	
	static String getShape(Proxy.Node node){
		final MNodeStyleController styleController = (MNodeStyleController) Controller
		.getCurrentModeController().getExtension(
				NodeStyleController.class);
			styleController.getShape(node.delegate)
	}
	static void setCloud(Proxy.Node node){
	def controller = Controller.getCurrentModeController();
	final NodeModel selected = controller.getMapController().getSelectedNode();
	final MCloudController cloudController = (MCloudController) CloudController
		.getController();
	cloudController.setCloud(node.delegate, true);
	cloudController.setShape(node.delegate, CloudModel.Shape.RECT)
	}
	
	static void setGray(Proxy.Node node){
		node.style.setBackgroundColorCode("#e6e6e6")
	}
	
	//
	static void setAttributes_OptimalWidth(Proxy.Node node){
		NodeLib.selectNode(node)
		//final NodeView nodeView = (NodeView) Controller.getCurrentController().getViewController().getSelectedComponent();
		final NodeView nodeView= Controller.currentController.mapViewManager.mapView.getNodeView(node.delegate)
		AttributeView attributeView = new AttributeView(nodeView, false);
		attributeView.provideAttributeTable()
		attributeView.setOptimalColumnWidths();
	}
	 
	static void setAttributes_ColumnWidth(Proxy.Node node,Integer col, Integer width){
		NodeLib.selectNode(node)
		//final NodeView nodeView = (NodeView) Controller.getCurrentController().getViewController().getSelectedComponent();
		final NodeView nodeView= Controller.currentController.mapViewManager.mapView.getNodeView(node.delegate)
		AttributeView attributeView = new AttributeView(nodeView, false);
		attributeView.provideAttributeTable()
		def table=attributeView.getAttributeTable()
		final float zoom = table.attributeView.getMapView().getZoom();
		final AttributeTableModelDecoratorAdapter model = (AttributeTableModelDecoratorAdapter) table.getModel();
		model.setColumnWidth(col, width)
	}
	
	static void setHiddenEdge(Proxy.Node n){
		n.style.edge.setType(EdgeStyle.EDGESTYLE_HIDDEN)
	}
	
	static void invoke_setHiddenEdge(Proxy.Node n){
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				n.style.edge.setType(EdgeStyle.EDGESTYLE_HIDDEN)
				}})
	}
	
	static void setSmoothEdge(Proxy.Node n){
		n.style.edge.setType(EdgeStyle.EDGESTYLE_BEZIER)
	}
	
	static void invoke_setSmoothEdge(Proxy.Node n){
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				n.style.edge.setType(EdgeStyle.EDGESTYLE_BEZIER)
				}})
	}

	void centerAndUnfold(String node_id){
		AThread.invoke({
			Proxy.Node node=nodeForId(node_id)
			if (node!=null){
				Controller.currentController.selection.selectAsTheOnlyOneSelected(node.delegate)
				Controller.getCurrentController().getSelection().centerNode(node.delegate);
				ModeController mc = Controller.getCurrentController().getModeController();
				FoldingController foldingController = mc.getExtension(FoldingController.class);
				foldingController.unfoldOneStage(node.delegate)
			}
		})
	}
}
