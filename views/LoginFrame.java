package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import models.*;
import controllers.*;

public class LoginFrame extends JFrame implements ActionListener
{
	
	private JLabel user,pass;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginBtn,exitBtn,signBtn,forgetBtn;
	//private Color color2,color3,color4 ;
	private ImageIcon img, backImg;
	private JPanel panel;
	private JLabel background;
	
	public LoginFrame()
	{
		super("Bank Management Login Frame");
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			/*this.backImg= new ImageIcon("image/Bank.jpg");
		this.panel= new JPanel()
		{
			protected  void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(backImg.getImage(),0,0,null);
			}
		};*/
	
		this.panel= new JPanel();
		//this.panel.setBackground(Color.GRAY);
		this.panel.setLayout(null);
	

	this.user=new JLabel("User Id:");
	this.user.setBounds(200,200,100,30);
	this.panel.add(user);
	
	this.userTF=new JTextField();
	this.userTF.setBounds(330,200,100,30);
	this.panel.add(userTF);
	
	this.pass=new JLabel("Password:");
	this.pass.setBounds(200,250,100,30);
	this.panel.add(pass);
	
	this.passPF=new JPasswordField();
	this.passPF.setBounds(330,250,100,30);
	this.panel.add(passPF);
	
	this.loginBtn=new JButton("Log In");
	this.loginBtn.setBounds(280,300,100,30);
	this.loginBtn.addActionListener(this);
	this.panel.add(loginBtn);
	
	this.signBtn=new JButton("Sign In");
	this.signBtn.setBounds(215,350,100,30);
	this.signBtn.addActionListener(this);
	this.panel.add(signBtn);
	
	
	this.forgetBtn=new JButton("Forget Password");
	this.forgetBtn.setBounds(370,350,150,30);
	this.forgetBtn.addActionListener(this);
	this.panel.add(forgetBtn);
	
	this.exitBtn=new JButton("Exit");
	this.exitBtn.setBounds(280,400,100,30);
	//this.exitBtn.setBackground(color2);
	this.exitBtn.addActionListener(this);
	this.panel.add(exitBtn);
	

	
	
	this.add(panel);
		
	
}

public void actionPerformed(ActionEvent ae)
{
	String command= ae.getActionCommand();
	
	if(command.equals(loginBtn.getText()))
	{
		if(!userTF.getText().isEmpty() && !passPF.getText().isEmpty())
		{
			String userId=userTF.getText();
			String passValue=passPF.getText();
			
			UserController uc=new UserController();
			User u=uc.searchUser(userId);
			if(u!=null)
			{
				if(u.getPassword().equals(passValue))
				{
					if(u.getRole()==1)
					{
						AdminHomeFrame ahf=new AdminHomeFrame(u);
						this.setVisible(false);
						ahf.setVisible(true);
					}
					else if(u.getRole()==2)
					{
					     EmployeeHomeFrame ehf=new EmployeeHomeFrame(u);
						 this.setVisible(false);
						 ehf.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Welcome to Client"); 
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"Wrong Password"); 
				}
			}
			else{
			JOptionPane.showMessageDialog(this,"Wrong UserId"); 
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(this,"Please fill all the poperty"); 
		}
	}
	if(command.equals(signBtn.getText()))
		{
			SignFrame suf=new SignFrame();
			this.setVisible(false);
			suf.setVisible(true);
		}
		
		if(command.equals(forgetBtn.getText()))
		{
			ForgetPassFrame fpf=new ForgetPassFrame();
			this.setVisible(false);
			fpf.setVisible(true);
		}
	if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
	
}

}
	
	
	
	
	