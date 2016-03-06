package SmarterDashboard.types.named;

import SmarterDashboard.types.NamedDataType;

/**
 *
 * @author Joe Grinstead
 */
public class StringChooserType extends NamedDataType {

    public static final String LABEL = "String Chooser";

    private StringChooserType() {
        super(LABEL);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new StringChooserType();
        }
    }
}
