package kata6;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay<T> extends ApplicationFrame{
    
    private final Histogram<T> histogram;
    private final String nameEjeX;

    public HistogramDisplay(Histogram<T> histogram, String name) {
        super("Histograma");
        this.histogram = histogram;
        nameEjeX = name;
        setContentPane(createPane());
        pack();
    }
    
    private ChartPanel createPane() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataSet()));
        chartPanel.setPreferredSize(new Dimension(500, 450));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                null,
                nameEjeX,
                "Numero",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);
        return chart;
    }
    
    public void execute() {
        setVisible(true);
    }

    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (T key : histogram.keySet()) {
            // Se añadio el cast comparable
            dataset.addValue(histogram.get(key), "", (Comparable) key);
        }
        
        return dataset;
    }
}