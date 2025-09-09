package sdetinterviewquestions3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.apache.jmeter.visualizers.gui.AbstractVisualizer;
import org.apache.jmeter.samplers.SampleEvent;
import org.apache.jmeter.samplers.SampleResult;

public class LatencyPercentileReporter extends AbstractVisualizer {

    private final List<Long> latencies = new ArrayList<>();
    private final JTextArea outputArea = new JTextArea();

    public LatencyPercentileReporter() {
        super();
        setName("95th Percentile Latency Reporter");
        initGui();
    }

    private void initGui() {
        setLayout(new BorderLayout());
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        setBorder(makeBorder());
        add(makeTitlePanel(), BorderLayout.NORTH);
    }

    @Override
    public void add(SampleResult sample) {
        latencies.add(sample.getTime());
    }

    @Override
    public void add(SampleEvent event) {
        add(event.getResult());
    }

    @Override
    public void clearData() {
        latencies.clear();
        outputArea.setText("");
    }

    @Override
    public void finalize() {
        super.finalize();
        reportPercentiles();
    }

    private void reportPercentiles() {
        if (latencies.isEmpty()) {
            outputArea.append("No data collected.\n");
            return;
        }

        Collections.sort(latencies);
        int index95 = (int) (latencies.size() * 0.95) - 1;
        long p95 = latencies.get(Math.max(index95, 0));

        outputArea.append(String.format("🔹 95th Percentile Latency: %d ms\n", p95));
        outputArea.append(String.format("🔸 Total Samples: %d\n", latencies.size()));
    }
}
