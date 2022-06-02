/**
 * 
 */
package sn.boom.javaws.server;

import java.util.List;

import javax.swing.JOptionPane;

import com.grak.javaws.jaxb.Configuration;
import com.grak.javaws.jaxb.ConfigurationLoader;
import com.grak.javaws.monitor.Monitor;
import com.grak.javaws.webservices.IWebService;

/**
 * @author nabyFall
 *
 */
public class MonitorLauncher {
	
	// le fichier de configuration de web services
	public static final String WEB_SERVICES_CONFIG_FILE = "web-services.cfg.xml";
	
	public static void main(String[] args) {
		
		
		try {
			// chargement les web services configures
			List<IWebService> webservices = ConfigurationLoader.build(Configuration.class, WEB_SERVICES_CONFIG_FILE);
		
			if (webservices.isEmpty()) throw new IllegalArgumentException("Au web services n'est encore configures, "+
					"veillez renseigner le fichier '" + WEB_SERVICES_CONFIG_FILE + "' svp!");
			
			// Instanciation puis lancement du monitor pour piloter les web web services charges ....
			Monitor monitor = new Monitor(webservices);
			monitor.run();
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage() == null? e.getStackTrace() : e.getMessage(), 
					"** "+ e.getClass() +" **", JOptionPane.CLOSED_OPTION);
		}
	}

}
