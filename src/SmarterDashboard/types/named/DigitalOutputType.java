/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.types.named;

import SmarterDashboard.livewindow.elements.DigitalOutputController;
import SmarterDashboard.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class DigitalOutputType extends NamedDataType {
    
    public static final String LABEL = "Digital Output";

    private DigitalOutputType() {
        super(LABEL, DigitalOutputController.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new DigitalOutputType();
        }
    }
    
}
