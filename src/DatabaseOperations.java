/*
 * Copyright (C) 2018 user
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

/**
 *
 * @author user
 */
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datumbox.opensource.classifiers.NaiveBayes;
import com.datumbox.opensource.dataobjects.NaiveBayesKnowledgeBase;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DatabaseOperations {
      
    public static void main(String args[]){
        try {
         /*   FileWriter out = null;
            FileReader in = null;
            CharBuffer ch = CharBuffer.allocate(12);
            File f;
             f = new File("D:\\Adb project\\NaiveBayesClassifier-master\\resources\\datasets\\sampleEng.txt");
            if (f.exists())
            {
                //delete if exists
                f.delete();
            }
           
            out = new FileWriter(f);
            out.write("this is english");
            
             in = new FileReader(f);
            in.read(ch);
        
            System.out.println(" After English "+ch.charAt(3));
            out.flush();
           in.close();
           f = new File("D:\\Adb project\\NaiveBayesClassifier-master\\resources\\datasets\\sampleEng.txt");
             if (f.exists())
            {
                //delete if exists
                f.delete();
            }
            out = new FileWriter(f);
            out.write("this is French"); 
            ch.clear();
            in.read(ch);
            System.out.println(" After English "+ch.charAt(3));
           
            
            out.close();
           String s1="1";
            String s2="2";
            String s3="3";
            String s4="4";
            String s5=" ";
            
            s5+=" "+s1;
            s5+=" "+s2;
            s5+=" "+s3;
            s5+=" "+s4;
            System.out.println(s5);
            
            
            
            
            /*    Cluster cluster;
            Session loginSession;
            cluster=Cluster.builder().addContactPoint("localhost").build();
            loginSession=cluster.connect("project");
            
            
            
            NaiveBayes nb2 = new NaiveBayes();    
            Map<String, String[]> trainingEx = new HashMap<>();//loading examples
            String[] strArray = new String[3];
            strArray[0]="i";
            strArray[1]="love";
            strArray[2]="english";
            String disease_id="Eng";
            trainingEx.put(disease_id, strArray);
            nb2.setChisquareCriticalValue(0.01); //0.01 pvalue
            nb2.train(trainingEx);
            strArray[0]="i";
            strArray[1]="Je";
            strArray[2]="suis";
            disease_id="French";
            trainingEx.put(disease_id, strArray);
            
            nb2.setChisquareCriticalValue(0.01); //0.01 pvalue
            nb2.train(trainingEx);
            NaiveBayesKnowledgeBase knowledgeBase2 = nb2.getKnowledgeBase();
            nb2 = null;
            nb2 = new NaiveBayes(knowledgeBase2);
            String exampleEn = "i english love";
            String outputEn = nb2.predict(exampleEn);
            System.out.format("The sentense \"%s\" was classified as \"%s\".%n", exampleEn, outputEn);
            //loginSession.execute("use project");
            /*  String selectQuery = "SELECT * from Symptom";
            ResultSet rs = loginSession.execute(selectQuery);
            String s_name;
            for(Row row : rs){
            s_name = row.getString("s_name");
            System.out.println(s_name);
            }
            
            
            String selectQuery2 = "SELECT * from Disease";
            ResultSet rs2 = loginSession.execute(selectQuery2);
            String d_name;
            for(Row row : rs2){
            d_name = row.getString("d_name");
            System.out.println(d_name);
            }
            */
            
            //    cluster.close();
            Runtime.getRuntime().exec("cmd /c start \"\" import");
            
        } catch (IOException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}

