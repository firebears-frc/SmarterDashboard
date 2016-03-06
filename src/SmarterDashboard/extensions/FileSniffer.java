package SmarterDashboard.extensions;

import java.io.*;
import java.lang.String;
import java.lang.System;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.Enumeration;
import java.net.*;

import javax.swing.*;

import SmarterDashboard.gui.*;
import SmarterDashboard.gui.elements.*;
import SmarterDashboard.types.*;

/**
 * This class searches for library and extension jars and adds them
 * to the system class loader. It then searches within extension jars for
 * {@link StaticWidget StaticWidget}s or {@link Widget Widget}s, and registers
 * them in the dashboard.
 *
 * @author Joe Grinstead
 */
public class FileSniffer {
	private static final File[] LIBRARY_DIRS = {
			new File("./lib"),
	};
	private static final String LIB_LOAD_MSGE =
		"Searching for library jars in: ";

	public static void findExtensions(ProgressMonitor monitor, int min,
		int max)
	{
		monitor.setNote("Loading Libraries");

		URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		Class<?> sysclass = URLClassLoader.class;

		Method method = null;
		try {
			method = sysclass.getDeclaredMethod("addURL", new Class[]{URL.class});
			method.setAccessible(true);
		} catch (Exception e) {
			e.printStackTrace();
			monitor.setProgress(max);
			return;
		}

		for (File libDir : LIBRARY_DIRS) {
			if (!libDir.exists()) {
				monitor.setProgress(min + (max - min) / 5);
				continue;
			}
			System.out.println(LIB_LOAD_MSGE + libDir);
			monitor.setNote(LIB_LOAD_MSGE + libDir);

			File[] files = libDir.listFiles(new FilenameFilter() {

				public boolean accept(File dir, String name) {
					return name.endsWith(".jar");
				}
			});
			if (files == null) {
				monitor.setProgress(min + (max - min) / 5);
				continue;
			}

			for (File file : files) {
				System.out.println("Adding Jar: " + file);

				try {
					method.invoke(sysloader,
						new Object[] {
							file.toURI().toURL()
						}
					);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			monitor.setProgress(min + (max - min) / 5);
		}

		monitor.setProgress(max);
	}
}
