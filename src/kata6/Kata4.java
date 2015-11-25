package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Kata4 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        String name = "E:\\Java\\Proyectos\\Kata6Fix\\Data\\emails.txt";
        ArrayList<Person> mailList = MailListReader.read(name);
        ArrayList<Person1> list = PersonLoader.read();
        
        HistogramBuilder<Person> builder = new HistogramBuilder(mailList);
        HistogramBuilder<Person1> builder1 = new HistogramBuilder(list);
        
        Histogram<String> domains = builder.build(new Attribute<Person, String>() {

            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
               return item.getMail().charAt(0);
            }
        });
        
        Histogram<String> domains1 = builder1.build(new Attribute<Person1, String>() {

            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Float> weigths = builder1.build(new Attribute<Person1, Float>() {

            @Override
            public Float get(Person1 item) {
                return item.getWeight();
            }
        });
        
        //new HistogramDisplay(domains, "Dominios").execute();
        //new HistogramDisplay(letters, "Caracter").execute();
        new HistogramDisplay(domains1, "Dominios").execute();
        new HistogramDisplay(weigths, "Pesos").execute();
        //Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        //new HistogramDisplay(histogram).execute();
    }
}
