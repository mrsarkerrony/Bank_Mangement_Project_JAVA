package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class AdminUpdatePasswordFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,presentPassLabel, newPassLabel;
	private JTextField userTF;
	private JPasswordField presentPassPF,newPassPF;
	private JButton updateBtn, backBtn;
	private JPanel panel;
	private User u;
	
	
	
	public AdminUpdatePasswordFrame(User u)
	{
		super("Admin Update Password Frame");
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(30,50,70,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(130,50,100,30);
		this.userTF.setText(u.getUserId());
		this.userTF.setEditable(false);
		this.panel.add(userTF);
		
		this.presentPassLabel=new JLabel("Present Password:");
		this.presentPassLabel.setBounds(30,100,70,30);
		this.panel.add(presentPassLabel);
		
		this.presentPassPF=new JPasswordField();
		this.presentPassPF.setBounds(130,100,100,30);
		this.panel.add(presentPassPF);
		
		this.newPassLabel=new JLabel("New Password:");
		this.newPassLabel.setBounds(30,150,70,30);
		this.panel.add(newPassLabel);
		
		this.newPassPF=new JPasswordField();
		this.newPassPF.setBounds(130,150,100,30);
		this.panel.add(newPassPF);
		
		
		this.updateBtn=new JButton("update");
		this.updateBtn.setBounds(30,200,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(170,200,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		
		this.add(panel);
		
		this.u=u;	
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		
		if(command.equals(updateBtn.getText()))
		{
			if((!presentPassPF.getText().isEmpty()) && (!newPassPF.getText().isEmpty()))
			{
				
				if(presentPassPF.getText().equals(u.getPassword()))
				{
					
					u.setPassword(newPassPF.getText());
	
					UserController urp=new UserController();
					urp.updateUser(u);
					JOptionPane.showMessageDialog(this,"Password Updated Successfully.");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"The password you entired is invalid.");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly.");
			}
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame adf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
	
}