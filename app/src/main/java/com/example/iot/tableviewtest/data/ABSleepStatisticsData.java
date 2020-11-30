package com.example.iot.tableviewtest.data;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by iot on 2019/8/25.
 */

public class ABSleepStatisticsData implements Serializable {

    private String terminal_property_id;
    private String value;
    private String update_datetime;

    public ABSleepStatisticsData() {

    }

    public ABSleepStatisticsData(String terminal_property_id, String value, String update_datetime) {
        this.terminal_property_id = terminal_property_id;
        this.value = value;
        this.update_datetime = update_datetime;
    }

    public ABSleepStatisticsData(JSONObject jsonObject) {
        if (jsonObject != null) {
            if (!jsonObject.isNull("terminal_property_id")) {
                terminal_property_id = jsonObject.optString("terminal_property_id", "");
            }
            if (!jsonObject.isNull("value")) {
                value = jsonObject.optString("value", "");
            }
            if (!jsonObject.isNull("update_datetime")) {
                update_datetime = jsonObject.optString("update_datetime", "");
            }
        }
    }

    public String getTerminal_property_id() {
        return terminal_property_id;
    }

    public void setTerminal_property_id(String terminal_property_id) {
        this.terminal_property_id = terminal_property_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUpdate_datetime() {
        return update_datetime;
    }

    public void setUpdate_datetime(String update_datetime) {
        this.update_datetime = update_datetime;
    }
}
