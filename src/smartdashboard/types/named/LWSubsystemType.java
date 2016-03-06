/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.src.types.named;

import SmarterDashboard.src.livewindow.elements.LWSubsystem;
import SmarterDashboard.src.types.NamedDataType;

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
