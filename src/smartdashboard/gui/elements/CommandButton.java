package SmarterDashboard.src.gui.elements;

import SmarterDashboard.src.gui.elements.bindings.AbstractTableWidget;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import SmarterDashboard.src.properties.*;
import SmarterDashboard.src.types.*;
import SmarterDashboard.src.types.named.*;
import edu.wpi.first.wpilibj.tables.*;

/**
 *
 * @author Joe Grinstead
 */
public class CommandButton extends AbstractTableWidget {

	public static final DataType[] TYPES = {CommandType.get()};

	@Override
	public void init() {
		JButton start = new JButton(getFieldName());
		start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				table.putBoolean("running", true);
			}
		});

		start.setFocusable(false);

		setLayout(new BorderLayout());

		add(start, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}

	@Override
	public void propertyChanged(Property property) {
		//no properties
	}
}
