/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.types.named;

import SmarterDashboard.livewindow.elements.DigitalOutputController;
import SmarterDashboard.livewindow.elements.RelayController;
import SmarterDashboard.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class DoubleSolenoidType extends NamedDataType {
    
    public static final String LABEL = "Double Solenoid";

    private DoubleSolenoidType() {
        super(LABEL, RelayController.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new DoubleSolenoidType();
        }
    }
    
}
