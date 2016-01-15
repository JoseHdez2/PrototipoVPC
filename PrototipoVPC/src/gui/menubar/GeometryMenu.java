package gui.menubar;

import java.awt.event.ActionEvent;

import gui.dialog.RotationDialog;
import gui.dialog.RotationPaintDialog;
import gui.dialog.ScaleDialog;
import i18n.GUIStr;
import main.MainWindow;
import transform2.MirrorHorizontal;
import transform2.MirrorVertical;
import transform2.Transpose;


@SuppressWarnings("serial")
public class GeometryMenu extends AbstractMenu {
    
    final static GUIStr[] ACTION_NAMES =
        {
        GUIStr.GEOMETRY_MENU_VERTICAL_MIRROR,
        GUIStr.GEOMETRY_MENU_HORIZONTAL_MIRROR,
        GUIStr.GEOMETRY_MENU_TRANSPOSE,
        GUIStr.SEPARATOR,
        GUIStr.GEOMETRY_MENU_SCALE,
        GUIStr.GEOMETRY_MENU_ROTATION_PAINT,
        GUIStr.GEOMETRY_MENU_ROTATION
        };
    
    public GeometryMenu(MainWindow parentFrame){
        super(parentFrame, GUIStr.GEOMETRY_MENU, ACTION_NAMES);
    }

    @Override
    protected void actionPerformedHandler(GUIStr actionName, ActionEvent e) {
        
        switch(actionName){
        case GEOMETRY_MENU_VERTICAL_MIRROR:
            verticalMirrorActionPerformed(e);
            break;
        case GEOMETRY_MENU_HORIZONTAL_MIRROR:
            horizontalMirrorActionPerformed(e);
            break;
        case GEOMETRY_MENU_TRANSPOSE:
            transposeActionPerformed(e);
            break;  
        case GEOMETRY_MENU_SCALE:
            scaleActionPerformed(e);
            break;    
        case GEOMETRY_MENU_ROTATION_PAINT:
            rotationAndPaintActionPerformed(e);
            break;                            
        case GEOMETRY_MENU_ROTATION:
            rotationActionPerformed(e);
            break;                
        }
    }
    
    /*
     * Menu actions
     */
    
    private void verticalMirrorActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        transform(new MirrorVertical(parentFrame.getFocusedImage()));
    }
    
    private void horizontalMirrorActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        transform(new MirrorHorizontal(parentFrame.getFocusedImage()));   
    }
    
    private void transposeActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        transform(new Transpose(parentFrame.getFocusedImage()));   
    }    
    
    private void scaleActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        ScaleDialog d = new ScaleDialog(parentFrame,parentFrame.getFocusedImage());
    }
    
    private void rotationAndPaintActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        RotationPaintDialog d = new RotationPaintDialog(parentFrame,parentFrame.getFocusedImage());
    }        
    
    private void rotationActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        RotationDialog d = new RotationDialog(parentFrame,parentFrame.getFocusedImage());
    }        
}
