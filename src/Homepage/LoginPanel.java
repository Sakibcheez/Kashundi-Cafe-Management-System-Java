
package Homepage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private KashundiCafe mainApp;
    private JComboBox<String> userTypeComboBox;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPanel(KashundiCafe mainApp) {
        this.mainApp = mainApp;
        setLayout(null);

        JLabel lblWelcome = new JLabel("Welcome to Kashundi Cafe");
        lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblWelcome.setBounds(120, 11, 300, 22);
        add(lblWelcome);

        JLabel lblUserType = new JLabel("User Type:");
        lblUserType.setBounds(78, 60, 100, 14);
        add(lblUserType);

        userTypeComboBox = new JComboBox<>();
        userTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Admin", "Employee"}));
        userTypeComboBox.setBounds(188, 57, 150, 20);
        add(userTypeComboBox);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(78, 95, 100, 14);
        add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(188, 92, 150, 20);
        add(usernameField);
        usernameField.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(78, 130, 100, 14);
        add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(188, 127, 150, 20);
        add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(188, 162, 89, 23);
        add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void login() {
        String userType = (String) userTypeComboBox.getSelectedItem();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (userType == null || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ("Admin".equals(userType)) {
            if (KashundiCafe.ADMIN_USERNAME.equals(username) && KashundiCafe.ADMIN_PASSWORD.equals(password)) {
                JOptionPane.showMessageDialog(LoginPanel.this, "Login Successfully", "Login", JOptionPane.DEFAULT_OPTION);
                mainApp.showAdminPanel();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid admin credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if ("Employee".equals(userType)) {
            if (mainApp.getEmployees().containsKey(username) && mainApp.getEmployees().get(username).equals(password)) {
                mainApp.showEmployeeDashboard();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid employee credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void getlogin(){
    this.login(); 
    }
}
