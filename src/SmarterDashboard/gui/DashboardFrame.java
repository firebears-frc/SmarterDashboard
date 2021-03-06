package SmarterDashboard.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import SmarterDashboard.*;
import SmarterDashboard.robot.Robot;

/**
 * This class defines the main window for the FRC program. It contains almost no
 * logic except for the {@link DashboardFrame#load(java.lang.String) load(...)}
 * and {@link DashboardFrame#save(java.lang.String) save(...)} method.
 * 
 * @author Joe Grinstead
 */
public class DashboardFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The size the frame should be when displayed on the netbook */
	private static final Dimension NETBOOK_SIZE = new Dimension(1024, 400);
	/** The minimum size of the frame */
	private static final Dimension MINIMUM_SIZE = new Dimension(300, 200);
	
	public enum DisplayMode {
		SMARTER_DASHBOARD,
		LIVE_WINDOW;
	}

	public static final String PANEL_SMARTER_DASHBOARD = "SmarterDashboard";
	public static final String PANEL_LIVE_WINDOW = "LiveWindow";
	
	private final DashboardPrefs prefs = new DashboardPrefs(this);
	/** The content of the frame */
	private final DashboardPanel smarterDashboardPanel;
	private final DashboardPanel liveWindowPanel;
	private final MainPanel mainPanel;
	/** The menu bar */
	private final JMenuBar menuBar;
	/** Notify bar */
	private final JTextField notifyBar;
	/** The property table (there is only this one ever) */
	private final PropertyEditor propEditor;
	
	private final LogToCSV logger = new LogToCSV(this);
		 
		private static DashboardFrame INSTANCE = null;
		public static DashboardFrame getInstance(){
			return INSTANCE;
		}

	/**
	 * Initializes the frame.
	 * 
	 * @param competition
	 *			whether or not to display as though it were on the netbook
	 */
	public DashboardFrame(boolean competition) {
		super(PANEL_SMARTER_DASHBOARD + " - ");

		setLayout(new BorderLayout());

		// The content of the frame is really contained in the panel and menu
		smarterDashboardPanel = new DashboardPanel(this, Robot.getTable());
		smarterDashboardPanel.setName(PANEL_SMARTER_DASHBOARD);
		liveWindowPanel = new DashboardPanel(this, Robot.getLiveWindow());
		liveWindowPanel.setName(PANEL_LIVE_WINDOW);
		mainPanel = new MainPanel(new CardLayout(), smarterDashboardPanel, liveWindowPanel, smarterDashboardPanel);
		mainPanel.add(smarterDashboardPanel, DisplayMode.SMARTER_DASHBOARD.toString());
		mainPanel.add(liveWindowPanel, DisplayMode.LIVE_WINDOW.toString());
		setDisplayMode(DisplayMode.SMARTER_DASHBOARD);
		menuBar = new DashboardMenu(this, mainPanel);
		propEditor = new PropertyEditor(this);
		//
		notifyBar = new JTextField("Initialized Smarter Dashboard!");
		notifyBar.setEditable(false);

		add(menuBar, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		add(notifyBar, BorderLayout.SOUTH);

		// Set the size / look
		if (competition) {
			setPreferredSize(NETBOOK_SIZE);
			setUndecorated(true);
			setLocation(0, 0);
			setResizable(false);
		} else {
			setMinimumSize(MINIMUM_SIZE);

			// Closing operation is handled manually
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			setPreferredSize(new Dimension(prefs.width.getValue(), prefs.height.getValue()));
			setLocation(prefs.x.getValue(), prefs.y.getValue());
		}

		// Call our own exit function when the frame is closed
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});

		// Make resizing affect the preference variables for window size
		addComponentListener(new ComponentListener() {

			public void componentResized(ComponentEvent e) {
				prefs.width.setValue(getWidth());
				prefs.height.setValue(getHeight());
			}

			public void componentMoved(ComponentEvent e) {
				prefs.x.setValue(getX());
				prefs.y.setValue(getY());
			}

			public void componentShown(ComponentEvent e) {
			}

			public void componentHidden(ComponentEvent e) {
			}
		});

		// will only be instanciated once so make this a singleton so
		// plugins can get it for compatability
		INSTANCE = this;
	}
	
	/**
	 * Sets the current DisplayMode to the given mode.
	 * @param mode The mode to put the frame into.
	 */
	public final void setDisplayMode(DisplayMode mode) {
		CardLayout cl = (CardLayout)(mainPanel.getLayout());
		cl.show(mainPanel, mode.toString());
	}

	/**
	 * Returns the property editor
	 * 
	 * @return the property editor
	 */
	public PropertyEditor getPropertyEditor() {
		return propEditor;
	}

	/**
	 * Exits the program, prompting the user to quit.
	 */
	public void exit() {
		int result = JOptionPane.showConfirmDialog(this,
			"Do you want to quit?", "Quit?",
			JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		switch (result) {
			case JOptionPane.YES_OPTION:
				System.exit(0);
			default: // Do Nothing (they pressed no)
		}
	}

	public DashboardPrefs getPrefs() {
		return prefs;
	}

	public LogToCSV getLogger() {
		return logger;
	}
	
	public void notify(String toprint) {
		notifyBar.setText(toprint);
	}
}
