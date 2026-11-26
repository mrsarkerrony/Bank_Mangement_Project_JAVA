package views;

import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class EmployeeUpdateProfileFrame extends JFrame implements ActionListener {
    private JLabel userIdLabel, nameLabel, emailLabel, phoneLabel, genderLabel, ageLabel, addressLabel;
    private JTextField userTF, nameTF, emailTF, phoneTF, genderTF, ageTF, addressTF;
    private JButton updateBtn, backBtn;
    private JPanel panel;
    private User u;
    private Employee employee;

    public EmployeeUpdateProfileFrame(User u) {
        super("Employee Update Profile Frame");
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(null);

        EmployeeController arp = new EmployeeController();
        this.employee = arp.searchEmployee(u.getUserId());

        if (this.employee == null) {
            JOptionPane.showMessageDialog(this, "Employee not found.");
            return;
        }

        this.userIdLabel = new JLabel("User Id:");
        this.userIdLabel.setBounds(30, 50, 70, 30);
        this.panel.add(userIdLabel);

        this.userTF = new JTextField();
        this.userTF.setBounds(130, 50, 100, 30);
        this.userTF.setText(employee.getUserId());
        this.userTF.setEditable(false);
        this.panel.add(userTF);

        this.nameLabel = new JLabel("Name:");
        this.nameLabel.setBounds(30, 100, 70, 30);
        this.panel.add(nameLabel);

        this.nameTF = new JTextField();
        this.nameTF.setBounds(130, 100, 100, 30);
        this.nameTF.setText(employee.getName());
        this.nameTF.setEditable(false);
        this.panel.add(nameTF);

        this.emailLabel = new JLabel("Email:");
        this.emailLabel.setBounds(30, 150, 70, 30);
        this.panel.add(emailLabel);

        this.emailTF = new JTextField();
        this.emailTF.setBounds(130, 150, 150, 30);
        this.emailTF.setText(employee.getEmail());
        this.panel.add(emailTF);

        this.phoneLabel = new JLabel("Phone:");
        this.phoneLabel.setBounds(30, 200, 70, 30);
        this.panel.add(phoneLabel);

        this.phoneTF = new JTextField();
        this.phoneTF.setBounds(130, 200, 150, 30);
        this.phoneTF.setText(employee.getPhoneNo());
        this.panel.add(phoneTF);

        this.genderLabel = new JLabel("Gender:");
        this.genderLabel.setBounds(30, 250, 70, 30);
        this.panel.add(genderLabel);

        this.genderTF = new JTextField();
        this.genderTF.setBounds(130, 250, 100, 30);
        this.genderTF.setText(employee.getGender());
        this.genderTF.setEditable(false);
        this.panel.add(genderTF);

        this.ageLabel = new JLabel("Age:");
        this.ageLabel.setBounds(30, 300, 70, 30);
        this.panel.add(ageLabel);

        this.ageTF = new JTextField();
        this.ageTF.setBounds(130, 300, 100, 30);
        this.ageTF.setText(String.valueOf(employee.getAge()));
        this.ageTF.setEditable(false);
        this.panel.add(ageTF);

        this.addressLabel = new JLabel("Address:");
        this.addressLabel.setBounds(30, 350, 70, 30);
        this.panel.add(addressLabel);

        this.addressTF = new JTextField();
        this.addressTF.setBounds(130, 350, 150, 30);
        this.addressTF.setText(employee.getAddress());
        this.panel.add(addressTF);

        this.updateBtn = new JButton("Update");
        this.updateBtn.setBounds(30, 450, 120, 30);
        this.updateBtn.addActionListener(this);
        this.panel.add(updateBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(210, 450, 100, 30);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);

        this.add(panel);

        this.u = u;
    }

    
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals(updateBtn.getText())) {
            if (!emailTF.getText().isEmpty() && !phoneTF.getText().isEmpty() && !addressTF.getText().isEmpty()) {
                employee.setEmail(emailTF.getText());
                employee.setPhoneNo(phoneTF.getText());
                employee.setAddress(addressTF.getText());

                EmployeeController ec = new EmployeeController();
                boolean updated = ec.updateEmployee(employee);

                if (updated) {
                    JOptionPane.showMessageDialog(this, "Employee updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error updating employee.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please fill up all the fields properly.");
            }
        }

        if (command.equals(backBtn.getText())) {
            EmployeeHomeFrame homeFrame = new EmployeeHomeFrame(this.u);
            this.setVisible(false);
            homeFrame.setVisible(true);
        }
    }
}
