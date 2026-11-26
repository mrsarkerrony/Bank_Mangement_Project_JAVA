package views;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class EmployeeUpdatePasswordFrame extends JFrame implements ActionListener {

    private JLabel oldPasswordLabel, newPasswordLabel, confirmPasswordLabel;
    private JPasswordField oldPasswordField, newPasswordField, confirmPasswordField;
    private JButton updatePasswordBtn, cancelBtn;
    private JPanel panel;
	
	private User u;

    public EmployeeUpdatePasswordFrame(User u) {
        super("Employee Update Password Frame");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(null);

        this.oldPasswordLabel = new JLabel("Old Password:");
        this.oldPasswordLabel.setBounds(30, 30, 120, 30);
        this.panel.add(oldPasswordLabel);

        this.oldPasswordField = new JPasswordField();
        this.oldPasswordField.setBounds(160, 30, 150, 30);
        this.panel.add(oldPasswordField);

        this.newPasswordLabel = new JLabel("New Password:");
        this.newPasswordLabel.setBounds(30, 80, 120, 30);
        this.panel.add(newPasswordLabel);

        this.newPasswordField = new JPasswordField();
        this.newPasswordField.setBounds(160, 80, 150, 30);
        this.panel.add(newPasswordField);

        this.confirmPasswordLabel = new JLabel("Confirm Password:");
        this.confirmPasswordLabel.setBounds(30, 130, 120, 30);
        this.panel.add(confirmPasswordLabel);

        this.confirmPasswordField = new JPasswordField();
        this.confirmPasswordField.setBounds(160, 130, 150, 30);
        this.panel.add(confirmPasswordField);

        this.updatePasswordBtn = new JButton("Update Password");
        this.updatePasswordBtn.setBounds(30, 180, 150, 30);
        this.updatePasswordBtn.addActionListener(this);
        this.panel.add(updatePasswordBtn);

        this.cancelBtn = new JButton("Cancel");
        this.cancelBtn.setBounds(190, 180, 120, 30);
        this.cancelBtn.addActionListener(this);
        this.panel.add(cancelBtn);

        this.add(panel);
		this.u=u;
    }


    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

     	if(command.equals(updatePasswordBtn.getText()))
		{
			if((!oldPasswordField.getText().isEmpty()) && (!newPasswordField.getText().isEmpty()) && (!confirmPasswordField.getText().isEmpty()))
			{
				
				if(oldPasswordField.getText().equals(u.getPassword()))
				{
					
					u.setPassword(newPasswordField.getText());
	
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
		
		if(command.equals(cancelBtn.getText()))
		{
		EmployeeHomeFrame adf=new EmployeeHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
    }

   
}
