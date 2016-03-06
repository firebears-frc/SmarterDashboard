/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.src.types.named;

import SmarterDashboard.src.livewindow.elements.DigitalOutputController;
import SmarterDashboard.src.types.NamedDataType;

/**
 *
 * @author Sam
 */
public class CompressorType extends NamedDataType {
    
    public static final String LABEL = "Compressor";

    private CompressorType() {
        super(LABEL, DigitalOutputController.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new CompressorType();
        }
    }
    
}
