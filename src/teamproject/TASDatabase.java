package teamproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author qwink
 */
public class TASDatabase {
   public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement stmt = null, pstUpdate = null;
        ResultSet rs = null;
        ResultSetMetaData metadata = null;
        
        String query, key, value;
        boolean hasresults;
    try {
            
            /* Identify the Server */
            
            String server = ("jdbc:mysql://localhost/tas");
            String username = "root";
            String password = "CS488";
            System.out.println("Connecting to " + server + "...");
            
            /* Load the MySQL JDBC Driver */
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            /* Open Connection */

            conn = DriverManager.getConnection(server, username, password);

            /* Test Connection */
            
            if (conn.isValid(0)) {
                
                /* Connection Open! */
                
                System.out.println("Connected Successfully!");
                
                // Prepare Update Query
                
                
                
                // Execute Update Query
                
                updateCount = pstUpdate.executeUpdate();
                
                // Get New Key; Print To Console
                
                if (updateCount > 0) {
            
                    rs = pstUpdate.getGeneratedKeys();

                    if (rs.next()) {

                        System.out.print("Update Successful!  New Key: ");
                        System.out.println(rs.getInt(1));

                    }

                }
                
                
                /* Prepare Select Query */
                
                query = "SELECT * FROM people";
                stmt = conn.prepareStatement(query);
                
                /* Execute Select Query */
                
                System.out.println("Submitting Query ...");
                
                hasresults = stmt.execute();                
                
                /* Get Results */
                
                System.out.println("Getting Results ...");
                
                while ( hasresults || stmt.getUpdateCount() != -1 ) {

                    if ( hasresults ) {
                        
                        /* Get ResultSet Metadata */
                        
                        rs = stmt.getResultSet();
                        metadata = rs.getMetaData();
                        colCount = metadata.getColumnCount();
                        
                        /* Get Column Names; Print as Table Header */
                        
                        for (int i = 1; i <= colCount; i++) {

                            key = metadata.getColumnLabel(i);

                            System.out.format("%20s", key);

                        }
                        
                        /* Get Data; Print as Table Rows */
                        
                        while(rs.next()) {
                            
                            /* Begin Next ResultSet Row */

                            System.out.println();
                            
                            /* Loop Through ResultSet Columns; Print Values */

                            for (int i = 1; i <= colCount; i++) {

                                value = rs.getString(i);

                                if (rs.wasNull()) {
                                    System.out.format("%20s", "NULL");
                                }

                                else {
                                    System.out.format("%20s", value);
                                }

                            }

                        }
                        
                    }

                    else {

                        rsCount = stmt.getUpdateCount();  

                        if ( rsCount == -1 ) {
                            break;
                        }

                    }
                    
                    /* Check for More Data */

                    hasresults = stmt.getMoreResults();

                }
                
            }
            
            System.out.println();
            
            /* Close Database Connection */
            
            conn.close();
            
        }
        
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.err.println(e.toString());
        }
        
        /* Close Other Database Objects */
        
        finally {
            
            if (rs != null) { try { rs.close(); rs = null; } catch (Exception e) {} }
            
            if (stmt != null) { try { stmt.close();stmt = null; } catch (Exception e) {} }
            
            if (pstUpdate != null) { try { pstUpdate.close(); pstUpdate = null; } catch (SQLException e) {} }
            
        }
        
    }
    
    private Badge badge;
    private Punch push;
    private Shift shift;
    
    public Badge getBadge() {
        return badge;
    }

    public Punch getPush() {
        return push;
    }

    public Shift getShift() {
        return shift;
    }
    
    
    
}
