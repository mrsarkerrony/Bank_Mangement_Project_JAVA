package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import models.*;
import controllers.*;

public class EmployeeOperationFrame extends JFrame implements ActionListener {

    private JButton manageClientAccountsBtn, depositMoneyBtn, withdrawMoneyBtn, transferMoneyBtn, manageLoansBtn, viewClientProfilesBtn, viewTransactionsBtn, updateProfileBtn, updatePasswordBtn, backBtn;
    private JPanel panel;
    private User u;
    private DefaultTableModel model;
    private JTable clientTable;
    private JScrollPane scrollPane;

    public EmployeeOperationFrame(User u) {
        super("Employee Operation Frame");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(null);

        this.manageClientAccountsBtn = new JButton("Manage Client Accounts");
        this.manageClientAccountsBtn.setBounds(30, 50, 250, 30);
        this.manageClientAccountsBtn.addActionListener(this);
        this.panel.add(manageClientAccountsBtn);

        this.depositMoneyBtn = new JButton("Deposit Money");
        this.depositMoneyBtn.setBounds(30, 100, 250, 30);
        this.depositMoneyBtn.addActionListener(this);
        this.panel.add(depositMoneyBtn);

        this.withdrawMoneyBtn = new JButton("Withdraw Money");
        this.withdrawMoneyBtn.setBounds(30, 150, 250, 30);
        this.withdrawMoneyBtn.addActionListener(this);
        this.panel.add(withdrawMoneyBtn);

        this.transferMoneyBtn = new JButton("Transfer Money");
        this.transferMoneyBtn.setBounds(30, 200, 250, 30);
        this.transferMoneyBtn.addActionListener(this);
        this.panel.add(transferMoneyBtn);

        this.manageLoansBtn = new JButton("Manage Loans");
        this.manageLoansBtn.setBounds(30, 250, 250, 30);
        this.manageLoansBtn.addActionListener(this);
        this.panel.add(manageLoansBtn);

        this.viewClientProfilesBtn = new JButton("View Client Profiles");
        this.viewClientProfilesBtn.setBounds(30, 300, 250, 30);
        this.viewClientProfilesBtn.addActionListener(this);
        this.panel.add(viewClientProfilesBtn);

        this.viewTransactionsBtn = new JButton("View Transactions");
        this.viewTransactionsBtn.setBounds(30, 350, 250, 30);
        this.viewTransactionsBtn.addActionListener(this);
        this.panel.add(viewTransactionsBtn);

        this.updateProfileBtn = new JButton("Update Profile");
        this.updateProfileBtn.setBounds(30, 400, 250, 30);
        this.updateProfileBtn.addActionListener(this);
        this.panel.add(updateProfileBtn);

        this.updatePasswordBtn = new JButton("Update Password");
        this.updatePasswordBtn.setBounds(30, 450, 250, 30);
        this.updatePasswordBtn.addActionListener(this);
        this.panel.add(updatePasswordBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(30, 500, 250, 30);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);

        this.add(panel);
        this.u = u;

        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Phone");
        model.addColumn("NID");
        model.addColumn("Occupation");
        model.addColumn("Income");
        model.addColumn("Marital Status");
        model.addColumn("Gender");

        clientTable = new JTable(model);
        scrollPane = new JScrollPane(clientTable);
        scrollPane.setBounds(300, 50, 450, 400); 
        panel.add(scrollPane); 
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (manageClientAccountsBtn.getText().equals(command)) {
            JPanel clientFormPanel = new JPanel();
            clientFormPanel.setLayout(new GridLayout(11, 2, 5, 5));

            JTextField nameField = new JTextField(20);
            JTextField emailField = new JTextField(20);
            JTextField phoneField = new JTextField(20);
            JTextField nidField = new JTextField(20);
            JTextField occupationField = new JTextField(20);
            JTextField incomeField = new JTextField(20);
            String[] maritalStatuses = {"Single", "Married", "Divorced", "Widowed"};
            JComboBox<String> maritalStatusCombo = new JComboBox<>(maritalStatuses);
            String[] genders = {"Male", "Female", "Other"};
            JComboBox<String> genderCombo = new JComboBox<>(genders);

            clientFormPanel.add(new JLabel("Client Name:"));
            clientFormPanel.add(nameField);
            clientFormPanel.add(new JLabel("Client Email:"));
            clientFormPanel.add(emailField);
            clientFormPanel.add(new JLabel("Client Phone Number:"));
            clientFormPanel.add(phoneField);
            clientFormPanel.add(new JLabel("Client NID:"));
            clientFormPanel.add(nidField);
            clientFormPanel.add(new JLabel("Client Occupation:"));
            clientFormPanel.add(occupationField);
            clientFormPanel.add(new JLabel("Client Income:"));
            clientFormPanel.add(incomeField);
            clientFormPanel.add(new JLabel("Marital Status:"));
            clientFormPanel.add(maritalStatusCombo);
            clientFormPanel.add(new JLabel("Gender:"));
            clientFormPanel.add(genderCombo);

            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(e -> {
                if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty() ||
                        nidField.getText().isEmpty() || occupationField.getText().isEmpty() || incomeField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required!");
                } else {
                    String gender = genderCombo.getSelectedItem().toString();
                    String[] clientData = {
                        nameField.getText(),
                        emailField.getText(),
                        phoneField.getText(),
                        nidField.getText(),
                        occupationField.getText(),
                        incomeField.getText(),
                        maritalStatusCombo.getSelectedItem().toString(),
                        gender
                    };

                    model.addRow(clientData); 
                    JOptionPane.showMessageDialog(null, "New Client Added: " + nameField.getText());
                }
            });

            clientFormPanel.add(submitButton);
            JOptionPane.showOptionDialog(this, clientFormPanel, "Add New Client", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);

        } else if (command.equals(backBtn.getText())) {
            EmployeeHomeFrame ehf = new EmployeeHomeFrame(this.u);
            this.setVisible(false);
            ehf.setVisible(true);
        }
    }
}
