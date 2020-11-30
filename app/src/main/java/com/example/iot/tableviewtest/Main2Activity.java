package com.example.iot.tableviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.iot.tableviewtest.data.ABAllSleepStatisticsData;
import com.example.iot.tableviewtest.data.ABSleepStatisticsData;
import com.example.iot.tableviewtest.utils.DateUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        Log.d(TAG, "" + getAfterMinute("2019-09-15 23:59"));

//        getData();

//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.getDefault());
//            Log.d(TAG, sdf.parse("2019-09-17 22:00:00+0800").getTime() + "");
//            Log.d(TAG, sdf.parse("2019-09-17 22:00:00+0000").getTime() + "");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        String ip = "47.105.81.173";
        String port = "6111";
        String period = "60";
        String ip1 = "";
        String[] ip2 =  ip.split("\\.");
        for (int i = 0; i < ip2.length; i++) {
            ip1 = ip1 + Integer.toHexString((Integer.parseInt(ip2[i])));
        }
        String port1 = Integer.toHexString((Integer.parseInt(port)));
        String period1 = Integer.toHexString((Integer.parseInt(period)));
        Log.d(TAG, "ip1：" + ip1);
        Log.d(TAG, "port1：" + port1);
        Log.d(TAG, "period1：" + period1);
    }

    /**
     * 字符串转换成十六进制字符串
     *
     * @param str str 待转换的ASCII字符串
     * @return 每个Byte之间空格分隔，如: [61 6C 6B]
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    private void getData() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject("{\"code\":\"0000000\",\"data\":[{\"terminal_property_id\":\"5\",\"value\":\"63\",\"update_datetime\":\"2019-08-23 21:07:00\"},{\"terminal_property_id\":\"6\",\"value\":\"24\",\"update_datetime\":\"2019-08-23 21:07:00\"},{\"terminal_property_id\":\"7\",\"value\":\"0\",\"update_datetime\":\"2019-08-23 21:07:00\"},{\"terminal_property_id\":\"8\",\"value\":\"0\",\"update_datetime\":\"2019-08-23 21:07:00\"},{\"terminal_property_id\":\"9\",\"value\":\"2\",\"update_datetime\":\"2019-08-23 21:07:00\"},{\"terminal_property_id\":\"5\",\"value\":\"68\",\"update_datetime\":\"2019-08-23 21:17:00\"},{\"terminal_property_id\":\"6\",\"value\":\"22\",\"update_datetime\":\"2019-08-23 21:17:00\"},{\"terminal_property_id\":\"5\",\"value\":\"60\",\"update_datetime\":\"2019-08-23 21:27:00\"},{\"terminal_property_id\":\"6\",\"value\":\"21\",\"update_datetime\":\"2019-08-23 21:27:00\"},{\"terminal_property_id\":\"9\",\"value\":\"3\",\"update_datetime\":\"2019-08-23 21:27:00\"},{\"terminal_property_id\":\"5\",\"value\":\"58\",\"update_datetime\":\"2019-08-23 21:37:00\"},{\"terminal_property_id\":\"6\",\"value\":\"20\",\"update_datetime\":\"2019-08-23 21:37:00\"},{\"terminal_property_id\":\"5\",\"value\":\"55\",\"update_datetime\":\"2019-08-23 21:47:00\"},{\"terminal_property_id\":\"6\",\"value\":\"22\",\"update_datetime\":\"2019-08-23 21:47:00\"},{\"terminal_property_id\":\"7\",\"value\":\"1\",\"update_datetime\":\"2019-08-23 21:47:00\"},{\"terminal_property_id\":\"9\",\"value\":\"4\",\"update_datetime\":\"2019-08-23 21:47:00\"},{\"terminal_property_id\":\"5\",\"value\":\"53\",\"update_datetime\":\"2019-08-23 21:57:00\"},{\"terminal_property_id\":\"6\",\"value\":\"19\",\"update_datetime\":\"2019-08-23 21:57:00\"},{\"terminal_property_id\":\"7\",\"value\":\"0\",\"update_datetime\":\"2019-08-23 21:57:00\"},{\"terminal_property_id\":\"8\",\"value\":\"1\",\"update_datetime\":\"2019-08-23 21:57:00\"},{\"terminal_property_id\":\"5\",\"value\":\"50\",\"update_datetime\":\"2019-08-23 22:07:00\"},{\"terminal_property_id\":\"6\",\"value\":\"18\",\"update_datetime\":\"2019-08-23 22:07:00\"},{\"terminal_property_id\":\"7\",\"value\":\"1\",\"update_datetime\":\"2019-08-23 22:07:00\"},{\"terminal_property_id\":\"5\",\"value\":\"52\",\"update_datetime\":\"2019-08-23 22:17:00\"},{\"terminal_property_id\":\"6\",\"value\":\"19\",\"update_datetime\":\"2019-08-23 22:17:00\"},{\"terminal_property_id\":\"7\",\"value\":\"0\",\"update_datetime\":\"2019-08-23 22:17:00\"},{\"terminal_property_id\":\"8\",\"value\":\"0\",\"update_datetime\":\"2019-08-23 22:17:00\"},{\"terminal_property_id\":\"9\",\"value\":\"3\",\"update_datetime\":\"2019-08-23 22:17:00\"},{\"terminal_property_id\":\"5\",\"value\":\"58\",\"update_datetime\":\"2019-08-23 22:27:00\"},{\"terminal_property_id\":\"6\",\"value\":\"22\",\"update_datetime\":\"2019-08-23 22:27:00\"},{\"terminal_property_id\":\"9\",\"value\":\"2\",\"update_datetime\":\"2019-08-23 22:27:00\"},{\"terminal_property_id\":\"5\",\"value\":\"59\",\"update_datetime\":\"2019-08-23 22:30:00\"},{\"terminal_property_id\":\"6\",\"value\":\"26\",\"update_datetime\":\"2019-08-23 22:30:00\"},{\"terminal_property_id\":\"9\",\"value\":\"0\",\"update_datetime\":\"2019-08-23 22:30:00\"},{\"terminal_property_id\":\"5\",\"value\":\"64\",\"update_datetime\":\"2019-08-23 22:35:00\"},{\"terminal_property_id\":\"6\",\"value\":\"23\",\"update_datetime\":\"2019-08-23 22:35:00\"},{\"terminal_property_id\":\"9\",\"value\":\"2\",\"update_datetime\":\"2019-08-23 22:35:00\"},{\"terminal_property_id\":\"5\",\"value\":\"62\",\"update_datetime\":\"2019-08-23 22:45:00\"},{\"terminal_property_id\":\"6\",\"value\":\"20\",\"update_datetime\":\"2019-08-23 22:45:00\"},{\"terminal_property_id\":\"7\",\"value\":\"1\",\"update_datetime\":\"2019-08-23 22:45:00\"},{\"terminal_property_id\":\"8\",\"value\":\"1\",\"update_datetime\":\"2019-08-23 22:45:00\"},{\"terminal_property_id\":\"9\",\"value\":\"3\",\"update_datetime\":\"2019-08-23 22:45:00\"},{\"terminal_property_id\":\"5\",\"value\":\"48\",\"update_datetime\":\"2019-08-23 22:55:00\"},{\"terminal_property_id\":\"6\",\"value\":\"17\",\"update_datetime\":\"2019-08-23 22:55:00\"},{\"terminal_property_id\":\"7\",\"value\":\"0\",\"update_datetime\":\"2019-08-23 22:55:00\"},{\"terminal_property_id\":\"9\",\"value\":\"4\",\"update_datetime\":\"2019-08-23 22:55:00\"},{\"terminal_property_id\":\"5\",\"value\":\"49\",\"update_datetime\":\"2019-08-23 23:05:00\"},{\"terminal_property_id\":\"6\",\"value\":\"18\",\"update_datetime\":\"2019-08-23 23:05:00\"},{\"terminal_property_id\":\"8\",\"value\":\"0\",\"update_datetime\":\"2019-08-23 23:05:00\"},{\"terminal_property_id\":\"5\",\"value\":\"52\",\"update_datetime\":\"2019-08-23 23:15:00\"},{\"terminal_property_id\":\"6\",\"value\":\"16\",\"update_datetime\":\"2019-08-23 23:15:00\"},{\"terminal_property_id\":\"7\",\"value\":\"1\",\"update_datetime\":\"2019-08-23 23:15:00\"},{\"terminal_property_id\":\"5\",\"value\":\"55\",\"update_datetime\":\"2019-08-23 23:25:00\"},{\"terminal_property_id\":\"6\",\"value\":\"18\",\"update_datetime\":\"2019-08-23 23:25:00\"},{\"terminal_property_id\":\"7\",\"value\":\"0\",\"update_datetime\":\"2019-08-23 23:25:00\"},{\"terminal_property_id\":\"9\",\"value\":\"3\",\"update_datetime\":\"2019-08-23 23:25:00\"},{\"terminal_property_id\":\"5\",\"value\":\"58\",\"update_datetime\":\"2019-08-23 23:35:00\"},{\"terminal_property_id\":\"6\",\"value\":\"20\",\"update_datetime\":\"2019-08-23 23:35:00\"},{\"terminal_property_id\":\"9\",\"value\":\"2\",\"update_datetime\":\"2019-08-23 23:35:00\"},{\"terminal_property_id\":\"5\",\"value\":\"61\",\"update_datetime\":\"2019-08-23 23:45:00\"},{\"terminal_property_id\":\"6\",\"value\":\"26\",\"update_datetime\":\"2019-08-23 23:45:00\"},{\"terminal_property_id\":\"8\",\"value\":\"1\",\"update_datetime\":\"2019-08-23 23:55:00\"},{\"terminal_property_id\":\"9\",\"value\":\"3\",\"update_datetime\":\"2019-08-23 23:55:00\"},{\"terminal_property_id\":\"5\",\"value\":\"60\",\"update_datetime\":\"2019-08-24 00:05:00\"},{\"terminal_property_id\":\"6\",\"value\":\"22\",\"update_datetime\":\"2019-08-24 00:05:00\"},{\"terminal_property_id\":\"8\",\"value\":\"0\",\"update_datetime\":\"2019-08-24 00:05:00\"},{\"terminal_property_id\":\"5\",\"value\":\"62\",\"update_datetime\":\"2019-08-24 00:15:00\"},{\"terminal_property_id\":\"6\",\"value\":\"23\",\"update_datetime\":\"2019-08-24 00:15:00\"},{\"terminal_property_id\":\"9\",\"value\":\"2\",\"update_datetime\":\"2019-08-24 00:15:00\"},{\"terminal_property_id\":\"5\",\"value\":\"71\",\"update_datetime\":\"2019-08-24 00:25:00\"},{\"terminal_property_id\":\"6\",\"value\":\"24\",\"update_datetime\":\"2019-08-24 00:25:00\"},{\"terminal_property_id\":\"9\",\"value\":\"0\",\"update_datetime\":\"2019-08-24 00:25:00\"},{\"terminal_property_id\":\"5\",\"value\":\"76\",\"update_datetime\":\"2019-08-24 06:25:00\"},{\"terminal_property_id\":\"6\",\"value\":\"26\",\"update_datetime\":\"2019-08-24 06:25:00\"},{\"terminal_property_id\":\"7\",\"value\":\"1\",\"update_datetime\":\"2019-08-24 06:25:00\"},{\"terminal_property_id\":\"9\",\"value\":\"2\",\"update_datetime\":\"2019-08-24 06:25:00\"},{\"terminal_property_id\":\"5\",\"value\":\"72\",\"update_datetime\":\"2019-08-24 06:35:00\"},{\"terminal_property_id\":\"6\",\"value\":\"24\",\"update_datetime\":\"2019-08-24 06:35:00\"},{\"terminal_property_id\":\"7\",\"value\":\"0\",\"update_datetime\":\"2019-08-24 06:35:00\"},{\"terminal_property_id\":\"9\",\"value\":\"3\",\"update_datetime\":\"2019-08-24 06:35:00\"},{\"terminal_property_id\":\"5\",\"value\":\"70\",\"update_datetime\":\"2019-08-24 06:45:00\"},{\"terminal_property_id\":\"6\",\"value\":\"22\",\"update_datetime\":\"2019-08-24 06:45:00\"},{\"terminal_property_id\":\"7\",\"value\":\"1\",\"update_datetime\":\"2019-08-24 06:45:00\"},{\"terminal_property_id\":\"5\",\"value\":\"72\",\"update_datetime\":\"2019-08-24 06:55:00\"},{\"terminal_property_id\":\"6\",\"value\":\"23\",\"update_datetime\":\"2019-08-24 06:55:00\"},{\"terminal_property_id\":\"7\",\"value\":\"0\",\"update_datetime\":\"2019-08-24 06:55:00\"},{\"terminal_property_id\":\"9\",\"value\":\"2\",\"update_datetime\":\"2019-08-24 06:55:00\"},{\"terminal_property_id\":\"5\",\"value\":\"70\",\"update_datetime\":\"2019-08-24 07:05:00\"},{\"terminal_property_id\":\"6\",\"value\":\"24\",\"update_datetime\":\"2019-08-24 07:05:00\"},{\"terminal_property_id\":\"9\",\"value\":\"0\",\"update_datetime\":\"2019-08-24 07:05:00\"}]}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ABAllSleepStatisticsData data = new ABAllSleepStatisticsData(jsonObject);
        List<ABSleepStatisticsData> statisticsDatas = new ArrayList<>();
        statisticsDatas.addAll(data.getDatas());

        List<ABSleepStatisticsData> sleepDatas = new ArrayList<>();
        List<ABSleepStatisticsData> sleepDatas1 = new ArrayList<>();

        for (int i = 0; i < statisticsDatas.size(); i++) {
            if ("9".equals(statisticsDatas.get(i).getTerminal_property_id())) {
                sleepDatas.add(statisticsDatas.get(i));
            }
        }

//        ABSleepStatisticsData data100 = new ABSleepStatisticsData();
//        data100.setTerminal_property_id("100");
//        data100.setUpdate_datetime("2019-09-17 07:00:00");
//        data100.setValue("100");
//        sleepDatas.add(data100);

        for (int i = 0; i < sleepDatas.size() - 1; i++) {
            if (!sleepDatas.get(i).getValue().equals(sleepDatas.get(i + 1).getValue())) {
                String start = sleepDatas.get(i).getUpdate_datetime().substring(0, sleepDatas.get(i).getUpdate_datetime().length() - 3);
                String end = sleepDatas.get(i + 1).getUpdate_datetime().substring(0, sleepDatas.get(i + 1).getUpdate_datetime().length() - 3);
                long ms = DateUtils.getTimeExpend(start, end);
                long min = ms / 60000;
                Log.d(TAG, "start time -->  " + start + "    end time -->  " + end);
                // 加数据
                String terminal_property_id = sleepDatas.get(i).getTerminal_property_id();
                String value = sleepDatas.get(i).getValue();
                String update_datetime = sleepDatas.get(i).getUpdate_datetime();
                sleepDatas1.add(new ABSleepStatisticsData(terminal_property_id, value, update_datetime));
                sleepDatas1.add(new ABSleepStatisticsData(terminal_property_id, value, getAfterMinute(update_datetime)));
                Log.d(TAG, "sleepDatas1 -->  " + terminal_property_id + "," + value + "," + sleepDatas.get(i).getUpdate_datetime());
                Log.d(TAG, "sleepDatas1 -->  " + terminal_property_id + "," + value + "," + getAfterMinute(sleepDatas.get(i).getUpdate_datetime()));
                String datetime = update_datetime;
                for (int j = 0; j < min - 2; j++) {
                    datetime = getAfterMinute(datetime);
                    ABSleepStatisticsData data1 = new ABSleepStatisticsData();
                    data1.setTerminal_property_id(sleepDatas.get(i).getTerminal_property_id());
                    data1.setUpdate_datetime(getAfterMinute(datetime));
                    data1.setValue(sleepDatas.get(i).getValue());
                    sleepDatas1.add(data1);
                    Log.d(TAG, "sleepDatas1 -->  " + terminal_property_id + "," + value + "," + getAfterMinute(datetime));
                }
            }
        }
    }

    /*
     * 将时间转换为时间戳后加一分钟
     */
    public String getAfterMinute(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        long ts = date.getTime() + 60000;
        String result = simpleDateFormat.format(ts);
        return result;
    }
}
