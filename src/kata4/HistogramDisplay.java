package kata4;

import java.awt.Container;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay<T extends Object> extends ApplicationFrame{

    private final Histogram<T> histogram;
    
    public HistogramDisplay(String title, Histogram<T> histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    
    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;
    }
    private JFreeChart createChart (DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("JFreeChartHistogram", 
                "email domains", 
                "nº emails", 
                dataSet, 
                PlotOrientation.VERTICAL,
                false,
                false,
                rootPaneCheckingEnabled);
        return chart;
    }
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        histogram.keySet()
                .stream()
                .forEachOrdered((key)->dataSet.addValue(histogram.get(key), "",key.toString()));
        return dataSet;
    }
    public void execute(){
            this.setVisible(true);
    }

    @Override
    public final void setContentPane(Container contentPane) {
        super.setContentPane(contentPane);
    }

    @Override
    public final void pack() {
        super.pack();
    }
    
}
