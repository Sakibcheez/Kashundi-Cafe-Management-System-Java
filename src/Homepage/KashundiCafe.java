
package Homepage;

//Welcome to KashundiCafe

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class KashundiCafe {
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "shishir125";
    public static final String EMPLOYEE_FILE = "employees.txt";
     private ImageIcon icon;
    private JLabel mylabel; 
    
    

    public JFrame frame;
    private Map<String, String> employees;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    KashundiCafe window = new KashundiCafe();
                    window.frame.setVisible(true);
                    
                } catch (Exception e) {
                }
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
        frame.setBounds(100, 100, 780, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BorderLayout());
        
        icon = new ImageIcon(this.getClass().getResource("/cafeguii/images2/kashundi1.jpg"));
        mylabel = new JLabel(icon);
        mylabel.setBounds(1, 1, 450, 300);
        frame.add(mylabel);
       
        
        LoginPanel loginPanel = new LoginPanel(this);
        frame.getContentPane().add(loginPanel, BorderLayout.CENTER);
    }

    public void showAdminPanel() {
        AdminPanel adminPanel = new AdminPanel(this);
        frame.setBounds(100, 100, 450, 400);
        frame.getContentPane().removeAll();
        frame.setLocationRelativeTo(null);
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


