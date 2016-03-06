/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.types.named;

import SmarterDashboard.livewindow.elements.SingleNumberDisplay;
import SmarterDashboard.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class CounterType extends NamedDataType {
    
    public static final String LABEL = "Counter";

    private CounterType() {
        super(LABEL, SingleNumberDisplay.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new CounterType();
        }
    }
    
}
