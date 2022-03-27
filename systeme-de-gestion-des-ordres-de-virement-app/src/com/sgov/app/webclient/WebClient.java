package com.sgov.app.webclient;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sgov.app.services.IService;
import com.sgov.app.services.Service;

public class WebClient extends JFrame {

	private IService service;
	
	public WebClient() {
		service = new Service ();
		
		setSize(new Dimension(450, 150));
		setPreferredSize(new Dimension(450, 150));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Syst\u00E8me de gestion des ordres de virement ...");
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton virementButton = new JButton("virement");
		getContentPane().add(virementButton);
		virementButton.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						service.virement("001", "002");
					}
				});
		
		JButton fichierRetourButton = new JButton("fichier retour");
		getContentPane().add(fichierRetourButton);
		fichierRetourButton.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						String retour = service.getFichierRetour();
						System.out.println(retour);
					}
				});
		
		JButton importerButton = new JButton("importer");
		getContentPane().add(importerButton);
		
		importerButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				service.importer("C:\\quelquepart\\");
			}
		});
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
