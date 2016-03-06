package SmarterDashboard.livewindow.elements;

import edu.wpi.first.wpilibj.tables.ITableListener;
import javax.swing.BoxLayout;

import SmarterDashboard.gui.elements.bindings.AbstractTableWidget;
import SmarterDashboard.properties.Property;
import SmarterDashboard.types.DataType;
import SmarterDashboard.types.named.AccelerometerType;
import SmarterDashboard.types.named.AnalogInputType;
import SmarterDashboard.types.named.CounterType;
import SmarterDashboard.types.named.GearToothSensorType;
import SmarterDashboard.types.named.UltrasonicType;


/**
 * Displays a single number (e.g. 10.43). This should be used
 * by potentiometers, accelerometers, and other sensors that send
 * a single number to the robot.
 * @author Sam
 */
public class SingleNumberDisplay extends AbstractTableWidget implements ITableListener {
    
	public static final DataType[] TYPES = {AnalogInputType.get(), 
                                            UltrasonicType.get(), 
                                            AccelerometerType.get(), 
                                            GearToothSensorType.get(),
											CounterType.get()};
    
    protected final String defaultText = " ---- ";
    private final UneditableNumberField display = new UneditableNumberField();
    
    /**
     * @inheritdoc
     */
    public void init() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        nameTag = new NameTag(getFieldName());
        add(nameTag);
        
        display.setFocusable(false);
        display.setText(defaultText);
        setNumberBinding("Value", display);
        add(display);
		revalidate();
		repaint();
    }

	@Override
	public void propertyChanged(Property property) {
	}
    
}
