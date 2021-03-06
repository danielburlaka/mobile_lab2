package ua.kpi.comsys.io8303.ui.linegraph;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lab1.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class LineGraph extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_linegraph, container, false);

        LineChart lineChart = (LineChart) root.findViewById(R.id.idLineChart);
        showLineChart(lineChart);
        return root;
    }

    private void showLineChart(LineChart lineChart){

        ArrayList<Entry> lineEntries= new ArrayList<Entry>();
        for (float x = -(float)Math.PI; x < (float)Math.PI; x += 0.001) {
            lineEntries.add( new Entry(x, (float)Math.sin(x)));
        }

        LineDataSet lineDataSet  = new LineDataSet(lineEntries, "");
        lineDataSet.setDrawIcons(false);
        lineDataSet.enableDashedLine(10f, 0f, 0f);

        lineDataSet.setColor(Color.GREEN);
        lineDataSet.setCircleColor(Color.GREEN);
        lineDataSet.setLineWidth(1f);
        lineDataSet.setCircleRadius(0f);
        lineDataSet.setFormLineWidth(1f);
        LineData lineData = new LineData(lineDataSet);

        lineChart.setDrawMarkers(false);
        lineChart.getXAxis().setGranularityEnabled(false);
        lineChart.getDescription().setEnabled(false); //remove description
        lineChart.getLegend().setEnabled(false); //remove legend

        lineChart.setData(lineData);
        lineChart.invalidate();
    }
}
