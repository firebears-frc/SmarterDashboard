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
