package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class AdminUpdateProfileFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneLabel, genderLabel, ageLabel, addressLabel,adminTypeLabel;
	private JTextField userTF, nameTF, emailTF, phoneTF, genderTF, ageTF, addressTF, adminTypeTF;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,checkBtn, backBtn;
	private JPanel panel;
	private User u;
	private Admin admin;
	
		
	public AdminUpdateProfileFrame(User u)
	{
		super("Admin Update Profile Frame");
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		AdminController arp=new AdminController();
		this.admin=arp.searchAdmin(u.getUserId());
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(30,50,70,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(130,50,100,30);
		this.userTF.setText(admin.getUserId());
		this.userTF.setEditable(false);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(30,100,70,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(130,100,100,30);
		this.nameTF.setText(admin.getName());
		this.nameTF.setEditable(false);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("email:");
		this.emailLabel.setBounds(30,150,70,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(130,150,70,30);
		this.emailTF.setText(admin.getEmail());
		this.panel.add(emailTF);
		
		this.phoneLabel=new JLabel("Phone:");
		this.phoneLabel.setBounds(30,200,70,30);
		this.panel.add(phoneLabel);
		
		this.phoneTF=new JTextField();
		this.phoneTF.setBounds(130,200,100,30);
		this.phoneTF.setText(admin.getPhoneNo());
		this.panel.add(phoneTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(30,250,70,30);
		this.panel.add(genderLabel);
		
		this.genderTF=new JTextField();
		this.genderTF.setBounds(130,250,100,30);
		this.genderTF.setText(admin.getGender());
		this.genderTF.setEditable(false);
		this.panel.add(genderTF);
		
		
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(30,300,70,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(130,300,100,30);
		this.ageTF.setText(String.valueOf(admin.getAge()));
		this.ageTF.setEditable(false);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(30,350,70,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(130,350,100,30);
		this.addressTF.setText(admin.getAddress());
		this.panel.add(addressTF);
		
		
		this.adminTypeLabel=new JLabel("Admin Type:");
		this.adminTypeLabel.setBounds(30,400,100,30);
		this.panel.add(adminTypeLabel);
		
		this.adminTypeTF=new JTextField();
		this.adminTypeTF.setBounds(180,400,100,30);
		this.adminTypeTF.setText(admin.getAdminType());
		this.adminTypeTF.setEditable(false);
		this.panel.add(adminTypeTF);
		
		
		this.updateBtn=new JButton("Update");
		this.updateBtn.setBounds(30,450,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(210,450,100,30);
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
			if((!emailTF.getText().isEmpty()) && (!phoneTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				admin.setEmail(emailTF.getText());
				admin.setPhoneNo(phoneTF.getText());
				admin.setAddress(addressTF.getText());
				AdminController arp=new AdminController();
				arp.updateAdmin(admin);
				JOptionPane.showMessageDialog(this,"Admin updated successfully.");
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up all the field properly.");
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

	
	
