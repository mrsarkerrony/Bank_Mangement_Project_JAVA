package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class AdminHomeFrame extends JFrame implements 
ActionListener
{
	
	private JButton adminBtn,clientBtn,employeeBtn,bankAccBtn,profileBtn,passBtn,logOutBtn;
	   
	   private JPanel panel;
	   private User u;
	   
	   public AdminHomeFrame(User u)
	   {
		   
		   super("Admin Home Frame");
		   this.setSize(700,700);
	   
	       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   
	   this.panel=new JPanel();
	   this.panel.setLayout(null);
	   
	   this.adminBtn=new JButton("Admin List");
	   this.adminBtn.setBounds(30,50,180,30);
	   this.adminBtn.addActionListener(this);
	   this.panel.add(adminBtn);
	   
	   this.clientBtn=new JButton("Client List");
	   
	   this.clientBtn.setBounds(30,100,180,30);
	   this.clientBtn.addActionListener(this);
	   this.panel.add(clientBtn);
	   
	   this.employeeBtn=new JButton("Employee List");
		this.employeeBtn.setBounds(30,150,180,30);
		this.employeeBtn.addActionListener(this);
		this.panel.add(employeeBtn);
		
		this.bankAccBtn=new JButton("View All Bank Account");
		this.bankAccBtn.setBounds(30,200,180,30);
		this.bankAccBtn.addActionListener(this);
		this.panel.add(bankAccBtn);
		
		this.profileBtn=new JButton("Update Profile");
		this.profileBtn.setBounds(30,250,180,30);
		this.profileBtn.addActionListener(this);
		this.panel.add(profileBtn);

        this.passBtn=new JButton("Update Password");
		this.passBtn.setBounds(30,300,180,30);
		this.passBtn.addActionListener(this);
		this.panel.add(passBtn);
		
		this.logOutBtn=new JButton("Log Out");
		this.logOutBtn.setBounds(30,350,180,30);
		this.logOutBtn.addActionListener(this);
		this.panel.add(logOutBtn);
		
		
		
		this.add(panel);
		this.u=u;
		


}
public void actionPerformed(ActionEvent ae)
{
	String command =ae.getActionCommand();
	if(adminBtn.getText().equals(command))
	{
		AdminOperationFrame aof=new AdminOperationFrame(u);
		this.setVisible(false);
		aof.setVisible(true);
	}
	if(employeeBtn.getText().equals(command))
	{
		EmployeeHomeFrame ehf=new EmployeeHomeFrame(u);
		this.setVisible(false);
		ehf.setVisible(true);
	}
	if(profileBtn.getText().equals(command))
	{
		AdminUpdateProfileFrame aof=new AdminUpdateProfileFrame(u);
		this.setVisible(false);
		aof.setVisible(true);
	}
	if(passBtn.getText().equals(command))
	{
		AdminUpdatePasswordFrame aof=new AdminUpdatePasswordFrame(u);
		this.setVisible(false);
		aof.setVisible(true);
	}
	if(command.equals(logOutBtn.getText()))
	
	{
		LoginFrame lf=new LoginFrame();
		this.setVisible(false);
		lf.setVisible(true);
	}
}
}