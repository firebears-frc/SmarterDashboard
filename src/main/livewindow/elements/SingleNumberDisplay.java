package SmarterDashboard.src.livewindow.elements;

import SmarterDashboard.src.gui.elements.bindings.AbstractTableWidget;
import SmarterDashboard.src.properties.Property;
import SmarterDashboard.src.types.DataType;
import SmarterDashboard.src.types.named.AccelerometerType;
import SmarterDashboard.src.types.named.AnalogInputType;
import SmarterDashboard.src.types.named.CounterType;
import SmarterDashboard.src.types.named.GearToothSensorType;
import SmarterDashboard.src.types.named.UltrasonicType;
import edu.wpi.first.wpilibj.tables.ITableListener;
import javax.swing.BoxLayout;


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
