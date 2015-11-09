package gui.menubar;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import gui.dialogs.BrightnessContrastDialog;
import gui.utils.RegionSelector;
import gui.utils.image.NamedImage;
import i18n.GUIStr;
import main.MainWindow;

@SuppressWarnings("serial")
public class ImageMenu extends AbstractMenu{
    
    final static GUIStr[] ACTION_NAMES =
        {
        GUIStr.IMAGE_MENU_CROP_SELECTION,
        GUIStr.IMAGE_MENU_BRIGHTNESS_CONTRAST
        };
    
    public ImageMenu(MainWindow parentFrame) {
        super(parentFrame, GUIStr.IMAGE_MENU, ACTION_NAMES);
    }
    
    
    @SuppressWarnings("incomplete-switch")
    @Override
    protected void actionPerformedHandler(GUIStr actionName, ActionEvent e) {

        switch(actionName){
        case IMAGE_MENU_CROP_SELECTION:
            cropSelectionActionPerformed(e);
            break;
        case IMAGE_MENU_BRIGHTNESS_CONTRAST:
            brightnessAndContrastActionPerformed(e);
            break;
        }
    }
    
    private void cropSelectionActionPerformed(ActionEvent e) {
    
        NamedImage image = null;
        RegionSelector selection = parentFrame.getFocusedSelector();
        Point origin = selection.getOrigin();
        Point end = selection.getEnd();
        
            
        if (origin != null && end != null) {
            
            int x = (int)Math.min(origin.getX(),end.getX());
            int y = (int)Math.min(origin.getY(),end.getY());
            int width = (int)Math.max(origin.getX(),end.getX()) - x;
            int height = (int)Math.max(origin.getY(),end.getY()) - y;
            
            image = parentFrame.getFocusedImage();
            BufferedImage bi = image.getSubimage(x, y, width, height);
            NamedImage image2 = new NamedImage(bi,image.getFile());
            
            parentFrame.createImageFrame(image2);
        }
    }
    
    private void  brightnessAndContrastActionPerformed(ActionEvent e) {
    
        BrightnessContrastDialog dialog = new BrightnessContrastDialog(parentFrame);
    
    }
        
}
