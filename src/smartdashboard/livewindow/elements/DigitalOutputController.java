/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SmarterDashboard.src.livewindow.elements;

import SmarterDashboard.src.gui.elements.bindings.AbstractTableWidget;
import SmarterDashboard.src.properties.Property;
import SmarterDashboard.src.types.DataType;
import SmarterDashboard.src.types.named.CompressorType;
import SmarterDashboard.src.types.named.DigitalOutputType;
import SmarterDashboard.src.types.named.SolenoidType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JToggleButton;

/**
 * Controls a controller that is either on or off. Useful for solenoids.
 * @author Sam
 */
public class DigitalOutputController extends AbstractTableWidget implements Controller {
    
    public static final DataType[] TYPES = {DigitalOutputType.get(), 
                                            CompressorType.get(), 
                                            SolenoidType.get()};
    
    private final JToggleButton controller = new JToggleButton("Off");
    
    @Override
    public void init() {
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        nameTag = new NameTag(getFieldName());
        add(nameTag);
        
        controller.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                controller.setText(controller.isSelected() ? "On" : "Off");
                table.putBoolean("Value", controller.getText().equals("On"));
            }
        });
        add(controller);
        
        revalidate();
        repaint();
        
    }

    /**
     * @inheritdoc
     */
    public void propertyChanged(Property property) {
        
    }

    /**
     * @inheritdoc
     */
    public void reset() {
        if(controller.isSelected()) controller.doClick();
    }
    
    
}
