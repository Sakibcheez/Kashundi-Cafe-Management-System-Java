
package Homepage;

//Welcome to KashundiCafe

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class KashundiCafe {
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "shishir125";
    public static final String EMPLOYEE_FILE = "employees.txt";
    
    

    public JFrame frame;
    private Map<String, String> employees;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                KashundiCafe window = new KashundiCafe();
                window.frame.setVisible(true);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public KashundiCafe() {
        employees = new HashMap<>();
        EmployeeUtils.loadEmployees(employees, EMPLOYEE_FILE);
        initialize();
    }
    
    

    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Kashundi Cafe");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BorderLayout());

        LoginPanel loginPanel = new LoginPanel(this);
        frame.getContentPane().add(loginPanel, BorderLayout.CENTER);
    }

    public void showAdminPanel() {
        AdminPanel adminPanel = new AdminPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(adminPanel);
        frame.revalidate();
        frame.repaint();
    }

    public void showEmployeeDashboard() {
        EmployeeDashboard employeeDashboard = new EmployeeDashboard();
        frame.getContentPane().removeAll();
        frame.getContentPane().add(employeeDashboard);
        frame.revalidate();
        frame.repaint();
    }

    public Map<String, String> getEmployees() {
        return employees;
    }

    public void saveEmployees() {
        EmployeeUtils.saveEmployees(employees, EMPLOYEE_FILE);
    }
}
