/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.src.types.named;

import SmarterDashboard.src.livewindow.elements.PowerDistributionPanel;
import SmarterDashboard.src.livewindow.elements.SingleNumberDisplay;
import SmarterDashboard.src.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class PowerDistributionPanelType extends NamedDataType {
    
    public static final String LABEL = "PowerDistributionPanel";

    private PowerDistributionPanelType() {
        super(LABEL, PowerDistributionPanel.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new PowerDistributionPanelType();
        }
    }
    
}
