package SmarterDashboard.src.livewindow.elements;

import SmarterDashboard.src.gui.elements.bindings.AbstractTableWidget;
import SmarterDashboard.src.properties.Property;
import SmarterDashboard.src.types.DataType;
import SmarterDashboard.src.types.named.DigitalInputType;
import edu.wpi.first.wpilibj.tables.ITableListener;
import javax.swing.BoxLayout;

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
