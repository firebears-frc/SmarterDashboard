package SmarterDashboard.src.types.named;

import SmarterDashboard.src.types.NamedDataType;

/**
 *
 * @author Joe Grinstead
 */
public class SchedulerType extends NamedDataType {

    public static final String LABEL = "Scheduler";

    private SchedulerType() {
        super(LABEL);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new SchedulerType();
        }
    }
}
