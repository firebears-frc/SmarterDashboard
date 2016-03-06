/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.types.named;

import SmarterDashboard.livewindow.elements.ServoController;
import SmarterDashboard.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class ServoType extends NamedDataType {
    
    public static final String LABEL = "Servo";

    private ServoType() {
        super(LABEL, ServoController.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new ServoType();
        }
    }
    
}
