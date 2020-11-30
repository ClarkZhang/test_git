package com.example.iot.tableviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.iot.tableviewtest.weight.CustomMarkerView;
import com.example.iot.tableviewtest.weight.XYMarkerView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LineChart mLineChart;
    private LineChart mLineChart1;
    private BarChart mBarChart;

    private List<String> mXStrings = new ArrayList<>();
    private List<String> mYStrings = new ArrayList<>();

    private List<String> mXStrings1 = new ArrayList<>();
    private List<String> mYStrings1 = new ArrayList<>();

    private List<String> mXStrings2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLineChart = (LineChart) findViewById(R.id.line_chart);
        mLineChart1 = (LineChart) findViewById(R.id.line_chart1);
        mBarChart = (BarChart) findViewById(R.id.bar_chart);

        mXStrings.add("00:35");
        mXStrings.add("00:35");
        mXStrings.add("00:35");
        mXStrings.add("00:35");
        mXStrings.add("00:35");
        mXStrings.add("00:35");
        mXStrings.add("00:35");
        mXStrings.add("00:35");
        mXStrings.add("00:35");
        mXStrings.add("00:35");
        mXStrings.add("00:35");
        mXStrings.add("00:35");
        mXStrings.add("00:35");
        mXStrings.add("00:35");

        mXStrings1.add("00:31");
        mXStrings1.add("00:32");
        mXStrings1.add("00:33");
        mXStrings1.add("00:34");
        mXStrings1.add("00:35");

        mXStrings1.add("00:36");
        mXStrings1.add("00:37");
        mXStrings1.add("00:38");
        mXStrings1.add("00:39");
        mXStrings1.add("00:40");

        mXStrings1.add("00:41");
        mXStrings1.add("00:42");
        mXStrings1.add("00:43");
        mXStrings1.add("00:44");
        mXStrings1.add("00:45");

        mXStrings1.add("00:46");
        mXStrings1.add("00:47");
        mXStrings1.add("00:48");
        mXStrings1.add("00:49");
        mXStrings1.add("00:50");

        mXStrings1.add("00:51");
        mXStrings1.add("00:52");
        mXStrings1.add("00:53");
        mXStrings1.add("00:54");
        mXStrings1.add("00:55");

        mXStrings1.add("00:56");
        mXStrings1.add("00:57");

        mYStrings.add("清醒");
        mYStrings.add("浅睡");
        mYStrings.add("深睡");

        mYStrings1.add("0");
        mYStrings1.add("50");
        mYStrings1.add("100");
        mYStrings1.add("150");

        mXStrings2.add("00:41");
        mXStrings2.add("00:42");
        mXStrings2.add("00:43");
        mXStrings2.add("00:44");

        initLineChart();

        initLineChart1();

        initBarChart();

        // LineChart 设置手势滑动事件
//        mLineChart.setOnChartGestureListener(this);
        // LineChart 设置数值选择监听
//        mLineChart.setOnChartValueSelectedListener(this);
    }

    /**
     * 初始化 LineChart
     */
    private void initLineChart() {
//        mLineChart.setBackgroundColor(R.color.grey_dark);
        mLineChart.setGridBackgroundColor(getResources().getColor(R.color.grey_dark));
        // 隐藏左边坐标轴横网格线
//        mLineChart.getAxisLeft().setDrawGridLines(false);
        // 隐藏右边坐标轴横网格线
//        mLineChart.getAxisRight().setDrawGridLines(false);
        // 隐藏X轴竖网格线
        mLineChart.getXAxis().setDrawGridLines(false);
        mLineChart.setDescription(null);
        // 隐藏图例
        Legend legend = mLineChart.getLegend(); // 设置比例图标示，就是那个一组y的value的
        legend.setForm(Legend.LegendForm.NONE);// 样式
//        mLegend.setFormSize(6f);// 字体
//        mLegend.setTextColor(Color.WHITE);// 颜色
        mLineChart.getAxisRight().setEnabled(false);
        // 设置是否可以触摸
        mLineChart.setTouchEnabled(true);
        mLineChart.setDragDecelerationFrictionCoef(0.9f);
        // 设置是否可以拖拽
        mLineChart.setDragEnabled(true);
        // 设置是否可以缩放
        mLineChart.setScaleEnabled(false);
        mLineChart.setDrawGridBackground(false);
        mLineChart.setHighlightPerDragEnabled(true);
        mLineChart.setPinchZoom(true);
        // 设置一页最大显示个数为6，超出部分就滑动
        float ratio = (float) mXStrings.size() / (float) 6;
        // 显示的时候是按照多大的比率缩放显示,1f表示不放大缩小
        mLineChart.zoom(ratio, 1f, 0, 0);
        CustomMarkerView mv = new CustomMarkerView(this);
        mLineChart.setMarkerView(mv);

        // 自定义适配器，适配于X轴
        IAxisValueFormatter xAxisFormatter = new XAxisValueFormatter();
        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(xAxisFormatter);

        // 自定义适配器，适配于Y轴
        IAxisValueFormatter yAxisFormatter = new YAxisValueFormatter();
        YAxis yAxis = mLineChart.getAxisLeft();
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setStartAtZero(false);
        yAxis.setAxisMinValue(0);
        yAxis.setAxisMaxValue(4);
        yAxis.setGranularity(1);// 间隔 1
        yAxis.setLabelCount(4);// 强制6个标签
        yAxis.setValueFormatter(yAxisFormatter);

        setLineChartData();
    }

    /**
     * 传递曲线图数据集
     */
    private void setLineChartData() {
        // 填充数据，在这里换成自己的数据源
        List<Entry> entryComp = new ArrayList<>();
        entryComp.add(new Entry(1, 1));
        entryComp.add(new Entry(2, 3));
        entryComp.add(new Entry(3, 2));
        entryComp.add(new Entry(4, 1));
        entryComp.add(new Entry(5, 3));
        entryComp.add(new Entry(6, 2));
        entryComp.add(new Entry(7, 3));
        entryComp.add(new Entry(8, 3));
        entryComp.add(new Entry(9, 1));
        entryComp.add(new Entry(10, 3));
        entryComp.add(new Entry(11, 3));
        entryComp.add(new Entry(12, 2));
        entryComp.add(new Entry(13, 3));
        entryComp.add(new Entry(14, 2));

        // 这里，每重新new一个LineDataSet，相当于重新画一组折线
        // 每一个LineDataSet相当于一组折线。比如:这里有两个LineDataSet：setComp1，setComp2。
        // 则在图像上会有两条折线图，分别表示公司1 和 公司2 的情况.还可以设置更多
        LineDataSet setComp1 = new LineDataSet(entryComp, " ");
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp1.setDrawFilled(true);
        setComp1.setColor(getResources().getColor(R.color.green_light));
        setComp1.setFillColor(getResources().getColor(R.color.green_light));
        setComp1.setDrawCircles(false);
        setComp1.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        setComp1.setDrawValues(false);// 就不会显示折现上的value了

        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(setComp1);

        LineData lineData = new LineData(dataSets);

        mLineChart.setData(lineData);
        mLineChart.invalidate();
    }

    /**
     * 初始化 LineChart
     */
    private void initLineChart1() {
        mLineChart1.setBackgroundColor(getResources().getColor(R.color.grey_light));
        mLineChart1.setGridBackgroundColor(getResources().getColor(R.color.grey_dark));
        mLineChart1.setDescription(null);
        // 隐藏图例
        Legend legend = mLineChart1.getLegend(); // 设置比例图标示，就是那个一组y的value的
        legend.setForm(Legend.LegendForm.NONE);// 样式
        mLineChart1.getAxisRight().setEnabled(false);
        // 设置是否可以触摸
        mLineChart1.setTouchEnabled(true);
        mLineChart1.setDragDecelerationFrictionCoef(0.9f);
        // 设置是否可以拖拽
        mLineChart1.setDragEnabled(false);
        // 设置是否可以缩放
        mLineChart1.setScaleEnabled(false);
        mLineChart1.setDrawGridBackground(false);
        mLineChart1.setHighlightPerDragEnabled(true);
        mLineChart1.setPinchZoom(false);
        // 设置悬浮
        XYMarkerView mv = new XYMarkerView(this);
        mv.setChartView(mLineChart1);
        mLineChart1.setMarker(mv);

        // 自定义适配器，适配于X轴
        IAxisValueFormatter xAxisFormatter1 = new XAxisValueFormatter1();
        XAxis xAxis = mLineChart1.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setValueFormatter(xAxisFormatter1);

        // 自定义适配器，适配于Y轴
        IAxisValueFormatter yAxisFormatter1 = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf(value);
            }
        };
        YAxis yAxis = mLineChart1.getAxisLeft();
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setStartAtZero(false);
        yAxis.setAxisMinValue(0);
        yAxis.setAxisMaxValue(150);
        yAxis.setGranularity(50);// 间隔 50
        yAxis.setLabelCount(4);// 强制4个标签
        yAxis.setValueFormatter(yAxisFormatter1);

        setLineChartData1();
    }

    /**
     * 传递曲线图数据集
     */
    private void setLineChartData1() {
        // 填充数据，在这里换成自己的数据源
        List<Entry> entryComp = new ArrayList<>();
        entryComp.add(new Entry(0, 90));
        entryComp.add(new Entry(1, 60));
        entryComp.add(new Entry(2, 80));
        entryComp.add(new Entry(3, 60));
        entryComp.add(new Entry(4, 70));
        entryComp.add(new Entry(5, 60));

        entryComp.add(new Entry(6, 80));
        entryComp.add(new Entry(7, 70));
        entryComp.add(new Entry(8, 80));
        entryComp.add(new Entry(9, 50));
        entryComp.add(new Entry(10, 60));

        entryComp.add(new Entry(11, 70));
        entryComp.add(new Entry(12, 50));
        entryComp.add(new Entry(13, 70));
        entryComp.add(new Entry(14, 60));
        entryComp.add(new Entry(15, 80));

        entryComp.add(new Entry(16, 80));
        entryComp.add(new Entry(17, 50));
        entryComp.add(new Entry(18, 90));
        entryComp.add(new Entry(19, 70));
        entryComp.add(new Entry(20, 60));

        entryComp.add(new Entry(21, 80));
        entryComp.add(new Entry(22, 90));
        entryComp.add(new Entry(23, 80));
        entryComp.add(new Entry(24, 50));
        entryComp.add(new Entry(25, 70));

        entryComp.add(new Entry(26, 60));
        entryComp.add(new Entry(27, 80));

        // 这里，每重新new一个LineDataSet，相当于重新画一组折线
        // 每一个LineDataSet相当于一组折线。比如:这里有两个LineDataSet：setComp1，setComp2。
        // 则在图像上会有两条折线图，分别表示公司1 和 公司2 的情况.还可以设置更多
        LineDataSet setComp1 = new LineDataSet(entryComp, " ");
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp1.setColor(getResources().getColor(R.color.colorGreen));
        setComp1.setDrawCircles(false);
        setComp1.setMode(LineDataSet.Mode.LINEAR);
        setComp1.setDrawValues(false);// 就不会显示折现上的value了

        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(setComp1);

        LineData lineData = new LineData(dataSets);

        mLineChart1.setData(lineData);
        mLineChart1.invalidate();
    }

    private void initBarChart() {
        mBarChart.setGridBackgroundColor(getResources().getColor(R.color.grey_dark));
        mBarChart.setDescription(null);
        // 隐藏图例
        Legend legend = mBarChart.getLegend(); // 设置比例图标示，就是那个一组y的value的
        legend.setForm(Legend.LegendForm.NONE);// 样式
        mBarChart.getAxisRight().setEnabled(false);
        // 设置是否可以触摸
        mBarChart.setTouchEnabled(true);
        mBarChart.setDragDecelerationFrictionCoef(0.9f);
        // 设置是否可以拖拽
        mBarChart.setDragEnabled(true);
        // 设置是否可以缩放
        mBarChart.setScaleEnabled(false);
        mBarChart.setDrawGridBackground(false);
        mBarChart.setHighlightPerDragEnabled(true);
        mBarChart.setPinchZoom(true);
        // 设置一页最大显示个数为6，超出部分就滑动
        float ratio = (float) mXStrings2.size() / (float) 6;
        // 显示的时候是按照多大的比率缩放显示,1f表示不放大缩小
        mBarChart.zoom(ratio, 1f, 0, 0);
        // 设置悬浮
        XYMarkerView mv = new XYMarkerView(this);
        mv.setChartView(mBarChart);
        mBarChart.setMarker(mv);

        // 自定义适配器，适配于X轴
        IAxisValueFormatter xTrendFormatter = new XBarFormatter();
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.isCenterAxisLabelsEnabled();
        xAxis.setValueFormatter(xTrendFormatter);

        // 自定义适配器，适配于Y轴
        IAxisValueFormatter yTrendFormatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf(value);
            }
        };
        YAxis yAxis = mBarChart.getAxisLeft();
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setStartAtZero(false);
        yAxis.setAxisMinValue(0);
        yAxis.setAxisMaxValue(100);
        yAxis.setGranularity(20);// 间隔 10
        yAxis.setLabelCount(5);// 强制4个标签
        yAxis.setValueFormatter(yTrendFormatter);

        setBarChartData();
    }

    private void setBarChartData() {
        // 这里，每重新new一个LineDataSet，相当于重新画一组折线
        // 每一个LineDataSet相当于一组折线。比如:这里有两个LineDataSet：setComp1，setComp2。
        // 则在图像上会有两条折线图，分别表示公司1 和 公司2 的情况.还可以设置更多
        List<BarEntry> entryComp = new ArrayList<>();
        entryComp.add(new BarEntry(0, 35));
        entryComp.add(new BarEntry(0, 45));
        entryComp.add(new BarEntry(0, 55));
        entryComp.add(new BarEntry(0, 65));
        BarDataSet setComp = new BarDataSet(entryComp, " ");
        setComp.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp.setColor(getResources().getColor(R.color.colorGreen));
        setComp.setDrawValues(false);// 就不会显示折现上的value了

        List<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(setComp);

        BarData barData = new BarData(dataSets);
        barData.setBarWidth(0.2f);

        mBarChart.setData(barData);
        mBarChart.invalidate();
    }

    private class XAxisValueFormatter implements IAxisValueFormatter {

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            int position = (int) value;
            if (position >= mXStrings.size()) {
                position = 0;
            }
            return mXStrings.get(position);
        }
    }

    private class XAxisValueFormatter1 implements IAxisValueFormatter {

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            int position = (int) value;
            if (position >= mXStrings1.size()) {
                position = 0;
            }
            return mXStrings1.get(position);
        }
    }

    private class YAxisValueFormatter implements IAxisValueFormatter {

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            if (value == 1.0) {
                return mYStrings.get(0);
            } else if (value == 2.0) {
                return mYStrings.get(1);
            } else if (value == 3.0) {
                return mYStrings.get(2);
            } else {
                return "";
            }
        }
    }

    private class XBarFormatter implements IAxisValueFormatter {

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            int position = (int) value;
            if (position >= mXStrings2.size()) {
                return "";
            } else {
                return mXStrings2.get(position);
            }
        }
    }
}
