package com.example.iot.tableviewtest.weight;

import android.content.Context;
import android.widget.TextView;

import com.example.iot.tableviewtest.R;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

import java.text.DecimalFormat;

/**
 * Created by iot on 2019/9/26.
 */

public class XYMarkerView extends MarkerView {

    private TextView tvContent;

    private DecimalFormat format;

    public XYMarkerView(Context context) {
        super(context, R.layout.custom_marker_view);

        tvContent = (TextView) findViewById(R.id.content_tv);
        format = new DecimalFormat("###.0");
    }

    //回调函数每次MarkerView重绘,可以用来更新内容(用户界面)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        tvContent.setText(format.format(e.getY()));
        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
