package sn.appws.server;

import java.util.List;

import javax.swing.JOptionPane;

import com.grak.javaws.jaxb.Configuration;
import com.grak.javaws.jaxb.ConfigurationLoader;
import com.grak.javaws.monitor.Monitor;
import com.grak.javaws.webservices.IWebService;

public class MonitorLauncher {
	
	public static final String WEB_SERVICES_CONFIG_FILE = "web-services.cfg.xml";

	public static void main(String[] args) {
		
		try {
			// chargement des web services configures 
			List<IWebService> webServices = ConfigurationLoader.build(Configuration.class, WEB_SERVICES_CONFIG_FILE);
			
			if (webServices.isEmpty()) throw new IllegalArgumentException("Aucun web service n'est encore configure, "
					+ "veillez renseigner le fichier '" + WEB_SERVICES_CONFIG_FILE + "' svp!");
			
			//Instanciation puis lancement du moniteur pour piloter les web services charges ...
			Monitor monitor = new Monitor(webServices);
			monitor.run();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage() == null ? e.getStackTrace() : e.getMessage(), 
					"** " + e.getClass() + " **", JOptionPane.CLOSED_OPTION);
		}
	}
}
