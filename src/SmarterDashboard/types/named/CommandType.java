package SmarterDashboard.types.named;

import SmarterDashboard.gui.elements.*;
import SmarterDashboard.types.*;

/**
 *
 * @author Joe Grinstead
 */
public class CommandType extends NamedDataType {

    public static final String LABEL = "Command";

    private CommandType() {
        super(LABEL, Command.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new CommandType();
        }
    }
}
