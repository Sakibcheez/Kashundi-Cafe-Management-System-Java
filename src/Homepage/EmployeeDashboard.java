
package Homepage;

import javax.swing.*;
import java.awt.*;
import cafeguii.gui.Dashboard;

public class EmployeeDashboard extends JPanel {
    public EmployeeDashboard() {
        
        setLayout(null);
/*
        JLabel lblEmployeeDashboard = new JLabel("Employee Dashboard");
        lblEmployeeDashboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmployeeDashboard.setBounds(125, 11, 200, 22);
        add(lblEmployeeDashboard);
        */
        
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        dashboard.pack();
        this.dispose(); 
        

        
    }
    
    private void dispose() {
      //  throw new UnsupportedOperationException("Not supported yet."); 
    }
}
