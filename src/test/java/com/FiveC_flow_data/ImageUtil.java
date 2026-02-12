package com.FiveC_flow_data;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageUtil {

    public static void copyImageToClipboard(String filePath) throws Exception {
        File imageFile = new File(filePath);
        
        // Check if file exists
        if (!imageFile.exists()) {
            throw new Exception("Image file not found at path: " + filePath + 
                ". Please verify the file path is correct.");
        }
        
        // Check if it's a file (not a directory)
        if (!imageFile.isFile()) {
            throw new Exception("Path exists but is not a file: " + filePath);
        }
        
        // Read the image
        BufferedImage image = ImageIO.read(imageFile);
        
        // Check if image was read successfully
        if (image == null) {
            throw new Exception("Failed to read image file. The file may be corrupted or in an unsupported format: " + filePath);
        }

        TransferableImage transferableImage = new TransferableImage(image);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(transferableImage, null);
    }

    private static class TransferableImage implements Transferable {
        private BufferedImage image;

        public TransferableImage(BufferedImage image) {
            this.image = image;
        }

        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[] { DataFlavor.imageFlavor };
        }

        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return DataFlavor.imageFlavor.equals(flavor);
        }

        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
            if (!isDataFlavorSupported(flavor)) {
                throw new UnsupportedFlavorException(flavor);
            }
            return image;
        }
    }
}
