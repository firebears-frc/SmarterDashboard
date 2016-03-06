package SmarterDashboard.types.named;

import SmarterDashboard.gui.elements.*;
import SmarterDashboard.types.*;

/**
 *
 * @author Joe Grinstead
 */
public class ButtonType extends NamedDataType {

    public static final String LABEL = "Button";

    private ButtonType() {
        super(LABEL, Button.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new ButtonType();
        }
    }
}
