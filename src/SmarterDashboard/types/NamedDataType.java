package SmarterDashboard.types;

import java.util.HashMap;
import java.util.Map;

import SmarterDashboard.gui.*;
import SmarterDashboard.gui.elements.*;

/**
 *
 * @author Joe Grinstead
 */
public class NamedDataType extends DataType {

    private static final Map<String, NamedDataType> map = new HashMap<String, NamedDataType>();

    public static NamedDataType get(String name) {
        return map.get(name);
    }

    protected NamedDataType(String name, DataType... parents) {
        super(name, parents);
        if (name == null) {
            throw new IllegalArgumentException("Name can not be null");
        }
        if (map.containsKey(name)) {
            throw new IllegalArgumentException("Given name \"" + name + "\" has already been claimed");
        } else {
            map.put(name, this);
        }
    }

    protected NamedDataType(String name, Class<? extends Widget> defaultWidget, DataType... parents) {
        super(name, defaultWidget, parents);
        if (name == null) {
            throw new IllegalArgumentException("Name can not be null");
        }
        if (map.containsKey(name)) {
            throw new IllegalArgumentException("Given name \"" + name + "\" has already been claimed");
        } else {
            map.put(name, this);
        }
    }

    @Override
    public final boolean isNamed() {
        return true;
    }
}
