/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author AUSTIN
 */
public class upperlinkQ5 {
        
    String url = "jdbc:mysql://localhost:3306/sampledb";
    Connection conn = null; 
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver" ).newInstance();
            conn = DriverManager.getConnection( url, "root", "austin" );

        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(upperlinkQ5.class.getName()).log(Level.SEVERE, null, ex);
        }

        catch ( SQLException | ClassNotFoundException sqlex ) {
                  JOptionPane.showMessageDialog(null, "Unable to Connect to Database \n" + sqlex.toString());
              }
    
        return conn;
    }
    public void update(String StudentID, String fname, String lname, String supervisorID){
         
        try{
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Student (Student ID, fname, lname, supervisorID) values(?,?,?,?)");
                        stmt.setString(1, StudentID);
                        stmt.setString(2, fname);
                        stmt.setString(3, lname);
                        stmt.setString(4, supervisorID);

                        int execute = stmt.executeUpdate();
                        if (execute == 1){
                        JOptionPane.showMessageDialog(null, StudentID+" "+fname+" "+lname+" has been added to the database");
                        stmt.close();
                        }//end if (execute...........
                        else{
                        JOptionPane.showMessageDialog(null, "Update Failed");
                        }//end else
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Update Failed due to " + e.toString());
        }
    }                
                    
}
