package gui.menubar;

import java.awt.event.ActionEvent;

import i18n.GUIStr;
import main.MainWindow;
import transform2.MirrorHorizontal;
import transform2.Transpose;
import transform2.MirrorVertical;


@SuppressWarnings("serial")
public class GeometryMenu extends AbstractMenu {
    
    final static GUIStr[] ACTION_NAMES =
        {
        GUIStr.GEOMETRY_MENU_VERTICAL_MIRROR,
        GUIStr.GEOMETRY_MENU_HORIZONTAL_MIRROR,
        GUIStr.GEOMETRY_MENU_TRANSPOSE,
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
}