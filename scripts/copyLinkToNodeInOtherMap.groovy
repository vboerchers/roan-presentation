//Adapted for Freeplane 1.2

// @ExecutionModes({ON_SINGLE_NODE})
import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection
import java.awt.datatransfer.Transferable

import javax.swing.JOptionPane

import org.freeplane.core.resources.ResourceController
import org.freeplane.features.link.LinkController

URI getNodeUriFromClipboardIfAvailable() {
    Transferable selection = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(this)
    if (selection == null || ! selection.isDataFlavorSupported(DataFlavor.stringFlavor))
        return null
    String selectionAsString = selection.getTransferData(DataFlavor.stringFlavor)
    try {
        def uri = new URI(selectionAsString)
        // only URIs with something after the '#' are proper links to nodes
        return uri.fragment && uri.path ? uri : null
    }
    catch (Exception e) {
        return null
    }
}

void copyLink() {
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard()
    File file = node.map.file
    if (file == null) {
        JOptionPane.showMessageDialog(ui.frame,
            'The map must be saved to be usable as a link target', "Freeplane", JOptionPane.WARNING_MESSAGE);
        return
    }
    URI mapUri = node.map.file.absoluteFile.toURI();
    clipboard.setContents(new StringSelection('' + mapUri + '#' + node.id), null)
    c.statusInfo = 'copied link'
}

URI uri = getNodeUriFromClipboardIfAvailable()
if (uri != null && ! uri.path.contains(node.map.name)) {
    def title = 'Insert link to node in other map?'
    def result = ui.showConfirmDialog(c.selected?.delegate, title, title, JOptionPane.YES_NO_CANCEL_OPTION)
    if (result == JOptionPane.YES_OPTION) {
        boolean useRelativeUri = ResourceController.getResourceController().getProperty("links").equals("relative");
        if (useRelativeUri && node.map.file == null) {
            JOptionPane.showMessageDialog(ui.frame,
                'The map must be saved to be usable as a link source', "Freeplane", JOptionPane.WARNING_MESSAGE);
        }
        if (useRelativeUri)
            uri = new URI('' + createRelativeURI(node.map.file, new File(uri.path), (int) 1) + '#' + uri.fragment)
        node.link.text = uri
        c.statusInfo = 'link inserted'
    }
    else if (result == JOptionPane.NO_OPTION) {
        copyLink()
    }
}
else {
    copyLink()
}



URI createRelativeURI(final File map, final File input, final int linkType) {
int LINK_ABSOLUTE = 0;
		if (linkType == LINK_ABSOLUTE) {
			return null;
		}
		try {
			URI mapUri = null;
			if (map != null) {
				mapUri = map.getAbsoluteFile().toURI();
			}

			final URI fileUri = input.getAbsoluteFile().toURI();
			boolean isUNCinput = fileUri.getPath().startsWith("//");
			boolean isUNCmap = mapUri.getPath().startsWith("//");
			if((isUNCinput != isUNCmap)) {
				return fileUri;
			}
			final String filePathAsString = fileUri.getRawPath();
			final String mapPathAsString = mapUri.getRawPath();
			int differencePos;
			final int lastIndexOfSeparatorInMapPath = mapPathAsString.lastIndexOf("/");
			final int lastIndexOfSeparatorInFilePath = filePathAsString.lastIndexOf("/");
			int lastCommonSeparatorPos = -1;
			for (differencePos = 0; differencePos <= lastIndexOfSeparatorInMapPath
			        && differencePos <= lastIndexOfSeparatorInFilePath
			        && filePathAsString.charAt(differencePos) == mapPathAsString.charAt(differencePos); differencePos++) {
				if (filePathAsString.charAt(differencePos) == '/') {
					lastCommonSeparatorPos = differencePos;
				}
			}
			if (lastCommonSeparatorPos < 0) {
				return fileUri;
			}
			final StringBuilder relativePath = new StringBuilder();
			for (int i = lastCommonSeparatorPos + 1; i <= lastIndexOfSeparatorInMapPath; i++) {
				if (mapPathAsString.charAt(i) == '/') {
					relativePath.append("../");
				}
			}
			relativePath.append(filePathAsString.substring(lastCommonSeparatorPos + 1));

			return new URI(relativePath.toString());
		}
		catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}