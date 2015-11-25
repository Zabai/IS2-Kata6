package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Kata4 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String name = "E:\\Java\\Proyectos\\Kata6Fix\\Data\\emails.txt";
        ArrayList<Person> mailList = MailListReader.read(name);
        
        HistogramBuilder<Person> builder = new HistogramBuilder(mailList);
        
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
        
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Caracter").execute();
        //Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        //new HistogramDisplay(histogram).execute();
    }
}
