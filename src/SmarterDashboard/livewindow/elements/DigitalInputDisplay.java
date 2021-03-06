package SmarterDashboard.livewindow.elements;

import edu.wpi.first.wpilibj.tables.ITableListener;
import javax.swing.BoxLayout;

import SmarterDashboard.gui.elements.bindings.AbstractTableWidget;
import SmarterDashboard.properties.Property;
import SmarterDashboard.types.DataType;
import SmarterDashboard.types.named.DigitalInputType;

/**
 * Displays a digital value (on/off). Useful for limit switches.
 * @author Sam
 */
public class DigitalInputDisplay extends AbstractTableWidget implements ITableListener {
    
    public static final DataType[] TYPES = {DigitalInputType.get()};
    
    protected final String defaultText = " ---- ";
    private final UneditableBooleanField display = new UneditableBooleanField();

    public void init() {
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        nameTag = new NameTag(getFieldName());
        add(nameTag);
        
        display.setText(defaultText);
        setBooleanBinding("Value", display);
        add(display);

		revalidate();
		repaint();
        
    }

    public void propertyChanged(Property property) {
        
    }
    
}
