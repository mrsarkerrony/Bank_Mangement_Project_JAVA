package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class EmployeeHomeFrame extends JFrame implements ActionListener {

    private JButton manageClientsBtn, viewTransactionsBtn, viewReportsBtn, manageLoansBtn, manageAccountsBtn, updateProfileBtn, updatePasswordBtn, logOutBtn;
    private JPanel panel;
   private User u;

    public EmployeeHomeFrame(User u) {
        super("Employee Home Frame");
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(null);

        this.manageClientsBtn = new JButton("Manage Clients");
        this.manageClientsBtn.setBounds(30, 50, 180, 30);
        this.manageClientsBtn.addActionListener(this);
        this.panel.add(manageClientsBtn);

        this.viewTransactionsBtn = new JButton("View Transactions");
        this.viewTransactionsBtn.setBounds(30, 100, 180, 30);
        this.viewTransactionsBtn.addActionListener(this);
        this.panel.add(viewTransactionsBtn);

        this.viewReportsBtn = new JButton("View Reports");
        this.viewReportsBtn.setBounds(30, 150, 180, 30);
        this.viewReportsBtn.addActionListener(this);
        this.panel.add(viewReportsBtn);

        this.manageLoansBtn = new JButton("Manage Loans");
        this.manageLoansBtn.setBounds(30, 200, 180, 30);
        this.manageLoansBtn.addActionListener(this);
        this.panel.add(manageLoansBtn);

        this.manageAccountsBtn = new JButton("Manage Accounts");
        this.manageAccountsBtn.setBounds(30, 250, 180, 30);
        this.manageAccountsBtn.addActionListener(this);
        this.panel.add(manageAccountsBtn);

        this.updateProfileBtn = new JButton("Update Profile");
        this.updateProfileBtn.setBounds(30, 300, 180, 30);
        this.updateProfileBtn.addActionListener(this);
        this.panel.add(updateProfileBtn);

        this.updatePasswordBtn = new JButton("Update Password");
        this.updatePasswordBtn.setBounds(30, 350, 180, 30);
        this.updatePasswordBtn.addActionListener(this);
        this.panel.add(updatePasswordBtn);

        this.logOutBtn = new JButton("Log Out");
        this.logOutBtn.setBounds(30, 400, 180, 30);
        this.logOutBtn.addActionListener(this);
        this.panel.add(logOutBtn);

        this.add(panel);
        this.u=u;
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

       if(manageClientsBtn.getText().equals(command))
	{
		EmployeeOperationFrame ehf=new EmployeeOperationFrame(u);
		this.setVisible(false);
		ehf.setVisible(true);
	}
	
	if (updatePasswordBtn.getText().equals(command))
	{
		EmployeeUpdatePasswordFrame ehf=new EmployeeUpdatePasswordFrame(u);
		this.setVisible(false);
		ehf.setVisible(true);
	}
	/*if (updateProfileBtn.getText().equals(command))
	{
		EmployeeUpdateProfileFrame euf=new EmployeeUpdateProfileFrame(u);
		this.setVisible(false);
		euf.setVisible(true);
	}*/
	
	if(command.equals(logOutBtn.getText()))
	{
		LoginFrame lf=new LoginFrame();
		this.setVisible(false);
		lf.setVisible(true);
	}
    }
}
