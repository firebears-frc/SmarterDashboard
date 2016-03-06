/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.types.named;

import SmarterDashboard.livewindow.elements.EncoderDisplay;
import SmarterDashboard.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class QuadratureEncoderType extends NamedDataType {
    
    public static final String LABEL = "Quadrature Encoder";

    private QuadratureEncoderType() {
        super(LABEL, EncoderDisplay.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new QuadratureEncoderType();
        }
    }
    
   
}
