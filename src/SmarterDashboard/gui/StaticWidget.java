package SmarterDashboard.gui;

import java.awt.Dimension;

/**
 *
 * @author Joe Grinstead
 */
public abstract class StaticWidget extends DisplayElement {
	
	@Override
	public void init() {
		setPreferredSize(new Dimension(DashboardFrame.getInstance().getWidth() - 10, DashboardFrame.getInstance().getWidth() / 2));
	}

}
