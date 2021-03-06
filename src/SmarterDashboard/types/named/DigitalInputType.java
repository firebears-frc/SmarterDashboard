/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.types.named;

import SmarterDashboard.livewindow.elements.DigitalInputDisplay;
import SmarterDashboard.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class DigitalInputType extends NamedDataType {
    
    public static final String LABEL = "Digital Input";

    private DigitalInputType() {
        super(LABEL, DigitalInputDisplay.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new DigitalInputType();
        }
    }
    
}
