package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;


public class SignFrame extends JFrame implements ActionListener
{
	private JLabel tittle,userId,name,email,phone,gender,age,address,securityQues,securityAns,pass,membership;
	private JTextField userIdTF,nameTF,emailTF,phoneTF,ageTF,addressTF,securityAnsTF,membershipTF;
	private JPasswordField passPF;
	private JRadioButton maleRB,femaleRB;
	private ButtonGroup bg;
	private JButton confirmBtn,backBtn;
	
	private JPanel panel;
	
	public SignFrame()
	{
		super("Sign In Frame For Client");
		this.setSize(800,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.tittle=new JLabel("Fill the form properly");
		this.tittle.setBounds(350,50,170,50);
		this.panel.add(tittle);
		
		
		this.userId=new JLabel("User ID:");
		this.userId.setBounds(50,100,50,30);
		this.panel.add(userId);
		
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(120,100,100,30);
		this.panel.add(userIdTF);
		
		
		
		this.age=new JLabel("Age:");
		this.age.setBounds(500,100,50,30);
		this.panel.add(age);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(620,100,100,30);
		this.panel.add(ageTF);
		
		this.address=new JLabel("Address:");
		this.address.setBounds(500,150,70,30);
		this.panel.add(address);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(620,150,100,30);
		this.panel.add(addressTF);
		
		this.securityQues=new JLabel("Security Ques:What is your nick name:");
		this.securityQues.setBounds(400,200,250,30);
		this.panel.add(securityQues);
		
		this.securityAns=new JLabel("Security Ans:");
		this.securityAns.setBounds(500,250,100,30);
		this.panel.add(securityAns);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(620,250,100,30);
		this.panel.add(securityAnsTF);
		
		
		this.pass=new JLabel("Password:");
		this.pass.setBounds(500,300,70,30);
		this.panel.add(pass);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(620,300,100,30);
		this.panel.add(passPF);
		
		
		this.membership=new JLabel("Membership Type:");
		this.membership.setBounds(500,350,100,30);
		this.panel.add(membership);
		
		
		this.membershipTF=new JTextField();
		this.membershipTF.setBounds(620,350,100,30);
		this.panel.add(membershipTF);
		
		
		
		this.name=new JLabel("Name:");
		this.name.setBounds(50,150,50,30);
		this.panel.add(name);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,150,100,30);
		this.panel.add(nameTF);
		
		
		this.email=new JLabel("Email:");
		this.email.setBounds(50,200,50,30);
		this.panel.add(email);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,200,100,30);
		this.panel.add(emailTF);
		
		this.phone=new JLabel("Phone:");
		this.phone.setBounds(50,250,50,30);
		this.panel.add(phone);
		
		this.phoneTF=new JTextField();
		this.phoneTF.setBounds(120,250,100,30);
		this.panel.add(phoneTF);
		
		this.gender=new JLabel("Gender:");
		this.gender.setBounds(50,300,50,30);
		this.panel.add(gender);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(120,300,60,30);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(190,300,90,30);
		this.panel.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.confirmBtn=new JButton("Confirm");
		this.confirmBtn.setBounds(320,450,100,30);
		this.confirmBtn.addActionListener(this);
		this.panel.add(confirmBtn);
		
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(450,450,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		this.add(panel);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(confirmBtn.getText()))
		{
		if(((maleRB.isSelected()) || (femaleRB.isSelected())) && !nameTF.getText().isEmpty() &&!userIdTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneTF.getText().isEmpty() && !ageTF.getText().isEmpty() && !addressTF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && !passPF.getText().isEmpty() && !membershipTF.getText().isEmpty())
		{
			String userIdValue=userIdTF.getText();
				String nameValue=nameTF.getText();
			String emailValue=emailTF.getText();
				String phoneValue=phoneTF.getText();
				String addressValue=addressTF.getText();
				String securityAnsValue=securityAnsTF.getText();
				String passwordValue=passPF.getText();
				int role=3;
				String membershipValue=membershipTF.getText();
				
				String genderValue="";
				if(maleRB.isSelected())
				{
					genderValue="male";
				}
				else
				{
					genderValue="female";
				}
				
				int ageValue=0;
				try
				{
					String inputAge=ageTF.getText();
					ageValue=Integer.parseInt(inputAge);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(this,"Age value should be int.");
				}
				
				
				
				Client c=new Client(userIdValue,nameValue,genderValue,ageValue,emailValue,phoneValue,addressValue,role,securityAnsValue,passwordValue,membershipValue);
				
				UserController uc=new UserController();
				uc.insertUser(c);
				
				ClientController cc=new ClientController();
				cc.insertClient(c);
				
				JOptionPane.showMessageDialog(this, "Registration Done..");
				
				LoginFrame lf=new LoginFrame();
				this.setVisible(false);
				lf.setVisible(true);
		}
		else
			{
				JOptionPane.showMessageDialog(this,"Please fill up all the field properly");
			}
		
		}
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
	}
	
	
	
}