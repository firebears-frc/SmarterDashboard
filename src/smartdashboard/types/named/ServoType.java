/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.src.types.named;

import SmarterDashboard.src.livewindow.elements.ServoController;
import SmarterDashboard.src.types.NamedDataType;

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
