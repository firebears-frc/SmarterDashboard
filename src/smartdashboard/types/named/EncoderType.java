/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.src.types.named;

import SmarterDashboard.src.livewindow.elements.EncoderDisplay;
import SmarterDashboard.src.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class EncoderType extends NamedDataType {
    
    public static final String LABEL = "Encoder";

    private EncoderType() {
        super(LABEL, EncoderDisplay.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new EncoderType();
        }
    }
    
}
