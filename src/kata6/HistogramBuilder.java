package kata6;

import java.util.ArrayList;

public class HistogramBuilder<T> {
    private final ArrayList<T> list;

    public HistogramBuilder(ArrayList<T> list) {
        this.list = list;
    }
    
    public<A> Histogram<A> build (Attribute<T,A> attribute){
        Histogram<A> histo = new Histogram<>();
        for (T list1 : list) {
            A value = attribute.get(list1);
            histo.increment(value);
        }
        return histo;
    }
}
