/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.src.types.named;

import SmarterDashboard.src.livewindow.elements.SpeedController;
import SmarterDashboard.src.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class SpeedControllerType extends NamedDataType {
    
    public static final String LABEL = "Speed Controller";

    private SpeedControllerType() {
        super(LABEL, SpeedController.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new SpeedControllerType();
        }
    }
    
}
