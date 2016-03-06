/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.src.types.named;

import SmarterDashboard.src.livewindow.elements.DigitalOutputController;
import SmarterDashboard.src.livewindow.elements.RelayController;
import SmarterDashboard.src.types.NamedDataType;

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
