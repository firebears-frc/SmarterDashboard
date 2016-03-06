/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.types.named;

import SmarterDashboard.livewindow.elements.GyroDisplay;
import SmarterDashboard.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class LWGyroType extends NamedDataType {
    
    public static final String LABEL = "LWGyro";

    private LWGyroType() {
        super(LABEL, GyroDisplay.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new LWGyroType();
        }
    }
    
}
