package com.example.sidehustle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private GraphView lineGraph;
    private Integer imageInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        initToolbar();

        graph();

    }


    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Graph");

//        for back button in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void graph() {
        imageInt = R.drawable.img_sun_rise;

        lineGraph = findViewById(R.id.lineGraph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(
                new DataPoint[] {
                        new DataPoint(0, 1),
                        new DataPoint(1, 3),
                        new DataPoint(2, 4),
                        new DataPoint(3, 9),
                        new DataPoint(4, 6),
                        new DataPoint(5, 3),
                        new DataPoint(6, 6),
                        new DataPoint(7, 1),
                        new DataPoint(8, 2),
                        new DataPoint(9, 6),
                        new DataPoint(10, 20),
                        new DataPoint(12, 30),
                        new DataPoint(20, 36)
                }
        );

        lineGraph.setTitle("graph");
        lineGraph.setBackground(ContextCompat.getDrawable(getApplicationContext(), imageInt));
        lineGraph.addSeries(series);
    }
}