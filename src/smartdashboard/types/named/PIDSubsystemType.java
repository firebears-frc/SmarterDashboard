package SmarterDashboard.src.types.named;

import SmarterDashboard.src.livewindow.elements.PIDSubsystem;
import SmarterDashboard.src.types.NamedDataType;

/**
 *
 * @author Joe Grinstead
 */
public class PIDSubsystemType extends NamedDataType {

    public static final String LABEL = "PIDSubsystem";

    private PIDSubsystemType() {
        super(LABEL, PIDSubsystem.class, SubsystemType.get(), PIDType.get());
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new PIDSubsystemType();
        }
    }
}
