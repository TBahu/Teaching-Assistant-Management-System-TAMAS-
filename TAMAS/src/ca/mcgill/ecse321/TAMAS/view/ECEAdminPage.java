package ca.mcgill.ecse321.TAMAS.view;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.scene.control.TextArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;


public class ECEAdminPage extends JFrame {
	
	JLabel welcomeLabel; 
	JTextArea courseTextArea; 
	JFileChooser courseFileChooser; 
	int resultFileChooser;
	JTextArea filePathDisplay;
	JButton openFileChooserButton;
	JButton loadCourseButoon; 

	
	public ECEAdminPage() {
		initComponents();	
	}
	
	public void initComponents(){
		getContentPane().setBackground(Color.decode("#C63D0F"));
		
		welcomeLabel=new JLabel("Welcome! ECEadmin!"); 
		welcomeLabel.setFont(new Font("Gotham",Font.BOLD, 50));
		welcomeLabel.setForeground(Color.white);
		
		openFileChooserButton=new JButton();
		openFileChooserButton.setText("Choose a file!");
		
		loadCourseButoon=new JButton();
		loadCourseButoon.setText("Load the course from file");
		loadCourseButoon.setEnabled(false);
		
		courseTextArea=new JTextArea();
		courseTextArea.setColumns(30);
		courseTextArea.setRows(25);
		
		filePathDisplay=new JTextArea();
		filePathDisplay.setRows(50);
		filePathDisplay.setColumns(30);
		filePathDisplay.setText("Please choose a file to load the course allocation!");
		filePathDisplay.setFont(new Font("Gotham",Font.BOLD, 12));
		
		
	
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);
	    
	    layout.setHorizontalGroup(layout.createSequentialGroup()
	    		 
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(welcomeLabel)
	    				.addComponent(filePathDisplay))
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(openFileChooserButton))
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(loadCourseButoon))
	    		);
	    
	    layout.setVerticalGroup(layout.createSequentialGroup()
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    				.addComponent(welcomeLabel))
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(filePathDisplay)
	    				.addComponent(openFileChooserButton)
	    				.addComponent(loadCourseButoon))
	    		);
		pack();
		
		// add action listeners
		openFileChooserButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// file chooser
				courseFileChooser=new JFileChooser();
				courseFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter=new FileNameExtensionFilter("JavaScript Object Notation files", "json");
				courseFileChooser.setFileFilter(filter);
				resultFileChooser=courseFileChooser.showOpenDialog(rootPane);
				
				
				if (resultFileChooser == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = courseFileChooser.getSelectedFile();
				    loadCourseButoon.setEnabled(true);
				    filePathDisplay.setFont(new Font("Gotham",Font.BOLD, 14));
				    filePathDisplay.setText("Selected file: \n"+selectedFile.getAbsolutePath()+"\n"+" Click load course to continue or click on open file again to choose another file!");
				    
				    System.out.println("Selected file: " + selectedFile.getPath());
				}
				
				if(resultFileChooser == JFileChooser.CANCEL_OPTION){
					 filePathDisplay.setFont(new Font("Gotham",Font.BOLD, 14));
					    filePathDisplay.setText("Selection cancelled, please choose a file");
				}
				
				
			}
		});
	}
}
