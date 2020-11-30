package com.example.iot.tableviewtest.data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iot on 2019/8/25.
 */

public class ABAllSleepStatisticsData  {

    private List<ABSleepStatisticsData> mDatas;

    public ABAllSleepStatisticsData(JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.optJSONArray("data");
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        } else {
            mDatas.clear();
        }
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject Object = jsonArray.optJSONObject(i);
                ABSleepStatisticsData datas = new ABSleepStatisticsData(Object);
                mDatas.add(datas);
            }
        }
    }

    public List<ABSleepStatisticsData> getDatas() {
        return mDatas;
    }

    public void setDatas(List<ABSleepStatisticsData> datas) {
        mDatas = datas;
    }
}
