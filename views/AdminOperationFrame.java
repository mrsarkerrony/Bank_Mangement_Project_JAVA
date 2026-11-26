package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class AdminOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel,emailLabel,phoneLabel,genderLabel,ageLabel,addressLabel,securityLabel,security1Label,passLabel,adminTypeLabel;
	
	  private JTextField userTF,nameTF,emailTF,phoneTF,ageTF,addressTF,security1TF;
	 
    private JPasswordField passPF;  
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JComboBox adminTypeCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,checkBtn, backBtn;
	private JTable adminTable;
	private JScrollPane adminTableSP;
	private JPanel panel;
	private User u;
	
	
	public AdminOperationFrame(User u)
	{
		super("Admin Operation Frame");
		this.setSize(900,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(30,50,70,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(130,50,100,30);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(30,100,70,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(130,100,100,30);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("Email:");
		this.emailLabel.setBounds(30,150,70,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(130,150,100,30);
		this.panel.add(emailTF);
		
		this.phoneLabel=new JLabel("Phone No:");
		this.phoneLabel.setBounds(30,200,70,30);
		this.panel.add(phoneLabel);
		
		this.phoneTF=new JTextField();
		this.phoneTF.setBounds(130,200,100,30);
		this.panel.add(phoneTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(30,250,70,30);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(100,250,70,30);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(200,250,70,30);
		this.panel.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(30,300,50,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(130,300,100,30);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(300,300,70,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(420,300,100,30);
		this.panel.add(addressTF);
		
		this.securityLabel=new JLabel("Security Ques: What is your eyes colour?:");
		this.securityLabel.setBounds(300,50,300,30);
		this.panel.add(securityLabel);
		
		this.security1Label=new JLabel("Security Ans:");
		this.security1Label.setBounds(300,150,100,30);
		this.panel.add(security1Label);
		
		this.security1TF=new JTextField();
		this.security1TF.setBounds(420,150,100,30);
		this.panel.add(security1TF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(300,200,100,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(420,200,100,30);
		this.panel.add(passPF);
		
		this.adminTypeLabel=new JLabel("Admin Type:");
		this.adminTypeLabel.setBounds(300,250,100,30);
		this.panel.add(adminTypeLabel);
		
		String[] item={"Admin", "Second Admin"};
		this.adminTypeCMB=new JComboBox(item);
		this.adminTypeCMB.setBounds(420,250,200,30);
		this.panel.add(adminTypeCMB);
		
		this.addBtn=new JButton("Add Admin");
		this.addBtn.setBounds(50,380,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("Update Admin");
		this.updateBtn.setBounds(160,380,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove Admin");
		this.removeBtn.setBounds(290,380,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.checkBtn=new JButton("Check Admin");
		this.checkBtn.setBounds(420,380,120,30);
		this.checkBtn.addActionListener(this);
		this.panel.add(checkBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(550,380,100,30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(660,380,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		AdminController adc=new AdminController();
		Admin[] adminList=adc.getAllAdmin();
		
		String adminData1[][]=new String[adminList.length][8];
		for(int i=0;i<adminList.length;i++)
		{
		
			if(adminList[i]!=null)
			{
				System.out.println(adminList[i].toStringAdmin());
				adminData1[i][0]=adminList[i].getUserId();
				adminData1[i][1]=adminList[i].getName();
				adminData1[i][2]=adminList[i].getGender();
				adminData1[i][3]=String.valueOf(adminList[i].getAge());
				adminData1[i][4]=adminList[i].getEmail();
				adminData1[i][5]=adminList[i].getPhoneNo();
				adminData1[i][6]=adminList[i].getAddress();
				adminData1[i][7]=adminList[i].getAdminType();
			}		
			
		}
		
		String head1[]={"Id","Name","Gender","Age","Email","Phone","Address","AdminType"};
		this.adminTable=new JTable(adminData1,head1);
		this.adminTableSP=new JScrollPane(adminTable);
		this.adminTableSP.setBounds(50,420,700,200);
		this.adminTable.setEnabled(false);
		this.panel.add(adminTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.u=u;		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			if(!userTF.getText().isEmpty() &&!nameTF.getText().isEmpty() &&((maleRB.isSelected()) || (femaleRB.isSelected())) && !ageTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneTF.getText().isEmpty() && !addressTF.getText().isEmpty() && !security1TF.getText().isEmpty() && !passPF.getText().isEmpty())
			{
				UserController uc=new UserController();
				AdminController adc=new AdminController();
				User u=uc.searchUser(userTF.getText());
				if(u!=null)
				{
					JOptionPane.showMessageDialog(this,"The specified user ID is already in use.");
				}
				
				else
				{
					String userId=userTF.getText();
					String name=nameTF.getText();
					String gender="";
					if(maleRB.isSelected())
					{
						gender=maleRB.getText();
					}
					
					else
					{
						gender=femaleRB.getText();
					}
					
					int age=0;
					
					try
					{
						age=Integer.parseInt(ageTF.getText());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					String email=emailTF.getText();
					String phone=phoneTF.getText();
					String address=addressTF.getText();
					int role=1;
					String security1=security1TF.getText();
					String password=passPF.getText();
					String adminType=adminTypeCMB.getSelectedItem().toString();
					
					User newUser = new User(userId,1,security1,password);
					uc.insertUser(newUser);
					Admin a=new Admin(userId,name,gender,age,email,phone,address,role,security1,password,adminType);
					adc.insertAdmin(a);
					JOptionPane.showMessageDialog(this,"Success attained.");
					
					this.setVisible(false);
					AdminOperationFrame ahf=new AdminOperationFrame(u);
					ahf.setVisible(true);
				}				
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up the field properly.");
			}
				
		}
		
		if(command.equals(updateBtn.getText()))
		{
			if(!userTF.getText().isEmpty() &&!nameTF.getText().isEmpty() &&((maleRB.isSelected()) || (femaleRB.isSelected())) && !ageTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneTF.getText().isEmpty() && !addressTF.getText().isEmpty() && !security1TF.getText().isEmpty() && !passPF.getText().isEmpty())
			{
				UserController uc=new UserController();
				AdminController adc=new AdminController();
				User u=uc.searchUser(userTF.getText());
				if(u!=null)
				{
					
					String userId=userTF.getText();
					String name=nameTF.getText();
					String gender="";
					if(maleRB.isSelected())
					{
						gender=maleRB.getText();
					}
					
					else
					{
						gender=femaleRB.getText();
					}
					
					int age=0;
					
					try
					{
						age=Integer.parseInt(ageTF.getText());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					String email=emailTF.getText();
					String phone=phoneTF.getText();
					String address=addressTF.getText();
					int role=1;
					String security1=security1TF.getText();
					String password=passPF.getText();
					String adminType=adminTypeCMB.getSelectedItem().toString();
					
					User updateUser = new User(userId,1,security1,password);
					uc.updateUser(updateUser);
					Admin a=new Admin(userId,name,gender,age,email,phone,address,role,security1,password,adminType);
					adc.updateAdmin(a);
					JOptionPane.showMessageDialog(this,"Update Successfully");
					
					User uu=uc.searchUser(userId);
					this.setVisible(false);
					AdminOperationFrame ahf=new AdminOperationFrame(uu);
					ahf.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"User Id not found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up the field properly.");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			if(!userTF.getText().isEmpty())
			{
				UserController uc = new UserController();
				AdminController adc = new AdminController();
				User u = uc.searchUser(userTF.getText());
				if(u!=null)
				{
					String userId=userTF.getText();
					uc.deleteUser(userId);
					adc.deleteAdmin(userId);
					JOptionPane.showMessageDialog(this,"Delete Successfully");

					User uu=uc.searchUser(userId);
					this.setVisible(false);
					AdminOperationFrame ahf=new AdminOperationFrame(uu);
					ahf.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"User Id not found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up the userId properly.");
			}
		}
		
		if(command.equals(checkBtn.getText()))
		{
			if(!userTF.getText().isEmpty())
			{
				AdminController adc=new AdminController();
				String userId=userTF.getText();
				Admin a=adc.searchAdmin(userId);
				
				if(a!=null)
				{
					userTF.setEnabled(false);
					nameTF.setText(a.getName());
					if(a.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					else
					{
						femaleRB.setSelected(true);
					}
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"User not authorized.");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide the userId.");
			}
		}
		
		if(command.equals(resetBtn.getText()))
		{
			userTF.setText("");
			nameTF.setText("");
			ageTF.setText("");
			emailTF.setText("");
			phoneTF.setText("");
			addressTF.setText("");
			passPF.setText("");
			security1TF.setText("");
		}
		
		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame ahf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			ahf.setVisible(true);
			
		}
	}
	
}