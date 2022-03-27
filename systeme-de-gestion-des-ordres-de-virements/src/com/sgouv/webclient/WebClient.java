package com.sgouv.webclient;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sgouv.service.Iservice;
import com.sgouv.service.Service;

public class WebClient {

	private Iservice service;
	
	private JFrame frame;
	
	private static final long serialVersionUID = 1L;
	
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
					public void actionPerformed1(ActionEvent e) {
						service.virement("001", "002");
					}

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
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

	private JFrame getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}

	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}

	private void setResizable(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void setDefaultCloseOperation(int disposeOnClose) {
		// TODO Auto-generated method stub
		
	}

	private void setPreferredSize(Dimension dimension) {
		// TODO Auto-generated method stub
		
	}

	private void setSize(Dimension dimension) {
		// TODO Auto-generated method stub
		
	}
	
}
