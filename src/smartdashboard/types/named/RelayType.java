/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.src.types.named;

import SmarterDashboard.src.livewindow.elements.RelayController;
import SmarterDashboard.src.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class RelayType  extends NamedDataType {
    
    public static final String LABEL = "Relay";

    private RelayType() {
        super(LABEL, RelayController.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new RelayType();
        }
    }
    
}
