/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.types.named;

import SmarterDashboard.livewindow.elements.LWSubsystem;
import SmarterDashboard.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class LWSubsystemType extends NamedDataType {
    
    public static final String LABEL = "LW Subsystem";

    private LWSubsystemType() {
        super(LABEL, LWSubsystem.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new LWSubsystemType();
        }
    }
    
}
