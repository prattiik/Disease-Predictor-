import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * Simple Java program to read CSV file in Java. In this program we will read
 * list of books stored in CSV file as comma separated values.
 * 
 * @author WINDOWS 8
 *
 */
public class CSVReaderInJava {
    static DefaultCategoryDataset dataset = new DefaultCategoryDataset( ); 
    DefaultCategoryDataset getDataset(){
        return dataset;
    }
    public static void main(String... args) {
         
        List<Book> books = readBooksFromCSV("D:\\adb project files\\NaiveBayesClassifier-master\\src\\sym_t.txt");
        String d_name = "asthma";
        String year;
       
        double percentage=0;
        // let's print all the person read from CSV file
        for (Book b : books) {
            
            if(b.getDisease().equalsIgnoreCase(d_name)){
                 
                    percentage = (b.getInfected()/b.getTotal())*100;
                    System.out.println(Integer.parseInt(b.getYear())+" "+percentage+" "+b.getInfected()+" "+b.getTotal()+" "+b.getDisease()); 
                    year = b.getYear();
                    dataset.addValue(percentage, b.getDisease(), year);
            }
            
        }
       
        
        
        LineChartAW chart = new LineChartAW(
         "Disease Vs Years" ,
         "Disease Percentage vs years");

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }

    private static List<Book> readBooksFromCSV(String fileName) {
        List<Book> books = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                Book book = createBook(attributes);

                // adding book into ArrayList
                books.add(book);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return books;
    }

    private static Book createBook(String[] metadata) {
        String year = metadata[0];
        String disease = metadata[1];
        String region = metadata[2];
        double disease_infected = Double.parseDouble(metadata[3]);
        double total_infected = Double.parseDouble(metadata[4]);
        // create and return book of this metadata
        
        
        
        
        
        
        return new Book(year,disease, region, disease_infected, total_infected);
    }

}
/*
class Book {
    String year,disease,region;
    double disease_infected,total_infected;

    public Book(String year, String disease, String region, double disease_infected, double total_infected) {
        this.year = year;
        this.disease = disease;
        this.region = region;
        this.disease_infected = disease_infected;
        this.total_infected = total_infected;

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
     public double getTotal() {
        return total_infected;
    }
     public void setTotal(int total_infected) {
        this.total_infected = total_infected;
    } 
     public double getInfected() {
        return disease_infected;
    }
     public void setInfected(int disease_infected) {
        this.disease_infected = disease_infected;
    } 

    @Override
    public String toString() {
        return "Book ["+disease+" "+region+" "+year+" "+disease_infected+" "+total_infected+"]";
    }

}
*/

/*
class LineChartAW extends ApplicationFrame {
    
   public LineChartAW( String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Years","Disease Percentage",
         new CSVReaderInJava().getDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

  
   
}

*/