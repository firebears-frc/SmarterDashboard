package SmarterDashboard.gui.elements;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import SmarterDashboard.gui.elements.bindings.AbstractTableWidget;
import SmarterDashboard.properties.*;
import SmarterDashboard.types.*;
import SmarterDashboard.types.named.*;
import edu.wpi.first.wpilibj.tables.*;

/**
 *
 * @author Joe Grinstead
 */
public class Button extends AbstractTableWidget {

	public static final DataType[] TYPES = {ButtonType.get()};

	@Override
	public void init() {
		JButton start = new JButton(getFieldName());

		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table.putBoolean("pressed", true);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				table.putBoolean("pressed", false);
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
	}
}
