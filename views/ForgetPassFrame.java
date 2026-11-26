package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class ForgetPassFrame extends JFrame implements ActionListener
{
	private JLabel  userF,securityQues,securityAns,pass;
	private JTextField userTF,securityAnsTF;
	private JPasswordField passPF;
	private JButton submitBtn,exitBtn,backBtn;
	private JPanel panel;
	
	
	public ForgetPassFrame()
	{
		super("Forget Password Frame");
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.userF=new JLabel("User Id:");
		this.userF.setBounds(100,100,80,30);
		this.panel.add(userF);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(200,100,80,30);
		this.panel.add(userTF);
		
		this.securityQues=new JLabel("What is your nick name:");
		this.securityQues.setBounds(100,150,150,30);
		this.panel.add(securityQues);
		
		this.securityAns=new JLabel("Answer:");
		this.securityAns.setBounds(270,150,50,30);
		this.panel.add(securityAns);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(370,150,100,30);
		this.panel.add(securityAnsTF);
		
		
		this.pass=new JLabel("Enter your new Password:");
		this.pass.setBounds(100,200,220,30);
		this.panel.add(pass);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(350,200,100,30);
		this.panel.add(passPF);
		
		
		this.submitBtn=new JButton("Submit");
		this.submitBtn.setBounds(200,300,100,30);
		this.submitBtn.addActionListener(this);
		this.panel.add(submitBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(330,300,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(280,340,100,30);
		this.exitBtn.addActionListener(this);
		this.panel.add(exitBtn);
		
		
		
		
		
		
		this.add(panel);
	
	
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			if(!userTF.getText().isEmpty() && !securityAnsTF.getText().isEmpty()  &&  !passPF.getText().isEmpty())
			{
				String userValue=userTF.getText();
				String securityAnsValue=securityAnsTF.getText();
				String passValue=passPF.getText();
				
				
				UserController uc=new UserController();
				User u=uc.searchUser(userValue);
				if(u!=null)
				{
					if(u.getSecurityAns().equals(securityAnsValue))
					{
						u.setPassword(passValue);
						uc.updateUser(u);
						JOptionPane.showMessageDialog(this,"Password Update Successfully");
						LoginFrame lf=new LoginFrame();
						this.setVisible(false);
						lf.setVisible(true);
					}
					
					else
					{
						JOptionPane.showMessageDialog(this,"Wrong Security Answer");

					}
				}
					else 
					{
						JOptionPane.showMessageDialog(this,"Wrong UserId");
					}
			}
			
			else
			{
				
		       JOptionPane.showMessageDialog(this,"Fill the Property properly");

				
			}
		}
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
		
		
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		
	}
}
