package SmarterDashboard.src.gui.elements;

import SmarterDashboard.src.gui.elements.bindings.AbstractValueWidget;
import javax.swing.*;

import SmarterDashboard.src.properties.*;
import SmarterDashboard.src.types.*;

/**
 * Implements a simple text box UI element with a name label.
 * @author pmalmsten
 */
public class CheckBox extends AbstractValueWidget {

    public static final DataType[] TYPES = {DataType.BOOLEAN};

    public final BooleanProperty editable = new BooleanProperty(this, "Editable", true);
    
    private EditableBooleanValueCheckBox valueField;

    public void init() {
        setResizable(false);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JLabel nameLabel = new JLabel(getFieldName());
        valueField = new EditableBooleanValueCheckBox(getFieldName());

        add(nameLabel);
        add(valueField);
    }

    @Override
    public void propertyChanged(Property property) {
        if (property == editable) {
            valueField.setEnabled(editable.getValue());
        }
    }
}
