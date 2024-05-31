
package Homepage;

import Data_File.Sales_History;
import Data_File.Total_income;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;
import Homepage.KashundiCafe;
import Homepage.LoginPanel;
import Homepage.EmployeeUtils;



public class AdminPanel extends JPanel {
    private KashundiCafe mainApp;
    private JTextField addUsernameField;
    private JTextField addPasswordField;
     
 

    public AdminPanel(KashundiCafe mainApp) {
        this.mainApp = mainApp;
        setLayout(null);

        JLabel lblAdminPanel = new JLabel("Admin Panel");
        lblAdminPanel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAdminPanel.setBounds(165, 11, 120, 22);
        add(lblAdminPanel);

        JLabel lblAddUsername = new JLabel("Username:");
        lblAddUsername.setBounds(78, 60, 100, 14);
        add(lblAddUsername);

        addUsernameField = new JTextField();
        addUsernameField.setBounds(188, 57, 150, 20);
        add(addUsernameField);

        JLabel lblAddPassword = new JLabel("Password:");
        lblAddPassword.setBounds(78, 95, 100, 14);
        add(lblAddPassword);

        addPasswordField = new JTextField();
        addPasswordField.setBounds(188, 92, 150, 20);
        add(addPasswordField);

        JButton btnAddEmployee = new JButton("Add Employee");
        btnAddEmployee.setBounds(78, 130, 150, 23);
        add(btnAddEmployee);
        btnAddEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = addUsernameField.getText();
                String newPassword = addPasswordField.getText();
                if (!newUsername.isEmpty() && !newPassword.isEmpty()) {
                    mainApp.getEmployees().put(newUsername, newPassword);
                    mainApp.saveEmployees();
                    JOptionPane.showMessageDialog(AdminPanel.this, "Employee added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(AdminPanel.this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnShowEmployees = new JButton("Show Employees");
        btnShowEmployees.setBounds(78, 160, 150, 23);
        add(btnShowEmployees);
        btnShowEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEmployees();
            }
        });
        
         JButton btnback = new JButton("Logout");
        btnback.setBounds(78, 190, 150, 23);
        add(btnback);
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
      JOptionPane.showMessageDialog(AdminPanel.this, "Logout Successfully", "Logout", JOptionPane.DEFAULT_OPTION);
            //  System.exit(0); 
            try {
                KashundiCafe window1 = new KashundiCafe();
                window1.frame.setVisible(true);
            } catch (Exception em) {
                em.printStackTrace();
            }
            }
        });
        
        JButton btnmenu = new JButton("Menu");
        btnmenu.setBounds(78, 220, 150, 23);
        add(btnmenu);
        btnmenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                mainApp.showEmployeeDashboard();
            }
        });
        
        JButton btnsell = new JButton("Sell Info");
        btnsell.setBounds(78, 250, 150, 23);
        add(btnsell);
        btnsell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            Sales_History fileReader = new Sales_History();
        fileReader.setVisible(true);     
 
        SwingUtilities.getWindowAncestor(btnsell).dispose();
       

            }
        });
        
        JButton btnincome = new JButton("Total Income");
        btnincome.setBounds(78, 280, 150, 23);
        add(btnincome);
        btnincome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
         Total_income fileReader = new Total_income();
        fileReader.setVisible(true);
 
            }
        });
    }

    private void showEmployees() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        for (Map.Entry<String, String> entry : mainApp.getEmployees().entrySet()) {
            String username = entry.getKey();
            String password = entry.getValue();
            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int confirm = JOptionPane.showConfirmDialog(AdminPanel.this,
                            "Are you sure you want to remove this employee?",
                            "Confirmation",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        mainApp.getEmployees().remove(username);
                        mainApp.saveEmployees();
                        JOptionPane.showMessageDialog(AdminPanel.this,
                                "Employee removed successfully",
                                "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        
                        showEmployees();
                    }
                }
            });
            panel.add(new JLabel("Username: " + username + ", Password: " + password));
            panel.add(removeButton);
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        JOptionPane.showMessageDialog(this, scrollPane, "Employee List", JOptionPane.PLAIN_MESSAGE);
    }
}
