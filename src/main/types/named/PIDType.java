package SmarterDashboard.src.types.named;

import SmarterDashboard.src.gui.elements.PIDEditor;
import SmarterDashboard.src.types.NamedDataType;

/**
 *
 * @author Joe Grinstead
 */
public class PIDType extends NamedDataType {

    public static final String LABEL = "PIDController";

    private PIDType() {
        super(LABEL, PIDEditor.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new PIDType();
        }
    }
}
