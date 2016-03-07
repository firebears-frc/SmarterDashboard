package SmarterDashboard.gui;

import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import org.jfree.ui.ExtensionFileFilter;

import SmarterDashboard.livewindow.elements.Controller;
import SmarterDashboard.livewindow.elements.LWSubsystem;
import SmarterDashboard.robot.Robot;
import SmarterDashboard.types.DisplayElementRegistry;

/**
 * This is the menu bar on top of the window. It can be set to hide
 * automatically in the preferences.
 *
 * @author Joe Grinstead
 */
public class DashboardMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9127806794220049636L;

	/**
	 * Creates a menu for the given panel.
	 *
	 */
	DashboardMenu(final DashboardFrame frame, final MainPanel mainPanel) {
		JMenu fileMenu = new JMenu("File");

		JMenuItem newMenu = new JMenuItem("Clear");
		newMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		newMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.getPanel(
					DashboardFrame.PANEL_SMARTER_DASHBOARD)
						.clear();
			}
		});
		fileMenu.add(newMenu);

		JMenuItem prefMenu = new JMenuItem("Preferences");
		prefMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PropertyEditor editor = frame.getPropertyEditor();
				editor.setPropertyHolder(frame.getPrefs());
				editor.setTitle("Edit Preferences");
				editor.setVisible(true);
			}
		});
		fileMenu.add(prefMenu);

		JMenuItem exitMenu = new JMenuItem("Exit");
		exitMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.exit();
			}
		});
		fileMenu.add(exitMenu);

		JMenu viewMenu = new JMenu("View");

		JCheckBoxMenuItem editSystems = new JCheckBoxMenuItem("Edit Subsystems");
		editSystems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LWSubsystem.setEditable(!LWSubsystem.isEditable());
			}
		});
		editSystems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
		editSystems.doClick();
		viewMenu.add(editSystems);

		final JMenuItem resetLW = new JMenuItem("Reset LiveWindow");
		resetLW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (LWSubsystem subsystem : MainPanel.getPanel("LiveWindow").getSubsystems()) {
					for (Widget component : subsystem.getWidgets()) {
						if (component instanceof Controller) {
							System.out.println("\tResetting " + component.getFieldName());
							((Controller) component).reset();
						}
					}
				}
			}
		});
		resetLW.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
		Robot.getLiveWindow().getSubTable("~STATUS~").addTableListenerEx("LW Enabled", new ITableListener() {
			public void valueChanged(ITable itable, String string, Object o, boolean bln) {
				final boolean isInLW = Robot.getLiveWindow().getSubTable("~STATUS~").getBoolean("LW Enabled", false);

				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						frame.setDisplayMode(isInLW
								? DashboardFrame.DisplayMode.LIVE_WINDOW
								: DashboardFrame.DisplayMode.SMARTER_DASHBOARD);

						mainPanel.setCurrentPanel(isInLW
								? MainPanel.getPanel("LiveWindow")
								: MainPanel.getPanel(DashboardFrame.PANEL_SMARTER_DASHBOARD));
						if (!isInLW) {
							resetLW.doClick();
						}

					}
				});
			}
		}, ITable.NOTIFY_IMMEDIATE | ITable.NOTIFY_LOCAL | ITable.NOTIFY_NEW | ITable.NOTIFY_UPDATE);
		viewMenu.add(resetLW);

		JMenu addMenu = new JMenu("Add...");
		Set<Class<? extends StaticWidget>> panels = DisplayElementRegistry.getStaticWidgets();
		for (final Class<? extends StaticWidget> option : panels) {
			JMenuItem item = new JMenuItem(DisplayElement.getName(option));
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						StaticWidget element = option.newInstance();
						mainPanel.getPanel(DashboardFrame.PANEL_SMARTER_DASHBOARD).addElement(element, null);
					} catch (InstantiationException ex) {
					} catch (IllegalAccessException ex) {
					}
				}
			});

			addMenu.add(item);
		}

		viewMenu.add(addMenu);

		final JMenu revealMenu = new JMenu("Reveal...");

		viewMenu.addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent e) {
				revealMenu.removeAll();

				int count = 0;
				for (final String field : mainPanel.getPanel(DashboardFrame.PANEL_SMARTER_DASHBOARD).getHiddenFields()) {
					if (mainPanel.getPanel(DashboardFrame.PANEL_SMARTER_DASHBOARD).getTable().containsKey(field)) {
						count++;
						revealMenu.add(new JMenuItem(new AbstractAction(field) {
							/**
							 * 
							 */
							private static final long serialVersionUID = 4297567226439305055L;

							public void actionPerformed(ActionEvent e) {
								mainPanel.getPanel(DashboardFrame.PANEL_SMARTER_DASHBOARD).addField(field);
							}
						}));
					}
				}

				revealMenu.setEnabled(count != 0);
			}

			public void menuDeselected(MenuEvent e) {
			}

			public void menuCanceled(MenuEvent e) {
			}
		});

		viewMenu.add(revealMenu);

		JMenuItem removeUnusedMenu = new JMenuItem("Remove Unused");
		removeUnusedMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPanel.getCurrentPanel().removeUnusedFields();
			}
		});

		viewMenu.add(removeUnusedMenu);

		add(fileMenu);
		add(viewMenu);
	}
}
