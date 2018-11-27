/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author user
 */
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
public class DiseaseDetection {

    /**
     * @param args the command line arguments
     */
    static Cluster cluster;
      public static void main(String[] args) {
        
        cluster=Cluster.builder().addContactPoint("127.0.0.1").build();
            
        new login().setVisible(true);
    }
    
    public Session CassandraHelper()
        {
        //creating cluster object
        Session session=cluster.connect("project");
        return session;
        
    }
    
}
