package com.practice.android.rxndroid.utils;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.practice.android.rxndroid.model.DataItem;

import java.util.List;

public class JSONHelper {
    private static final String FILE_NAME = "menu_items.json";
    private static final String TAG = "JSONHelper";

    public static boolean exportToJSON(Context context, List<DataItem> dataItemList) {
        DataItems menuData = new DataItems();
        menuData.setDataItems( dataItemList );

        Gson gson = new Gson();
        String jsonString = gson.toJson( menuData );
        Log.i( TAG, "exportToJSON: " + jsonString );




        return false;
    }

    public static List<DataItem> importFromJSON(Context context) {
        return null;
    }

    static class DataItems {
        List<DataItem> dataItems;

        public List<DataItem> getDataItems() {
            return dataItems;
        }

        public void setDataItems(List<DataItem> dataItems) {
            this.dataItems = dataItems;
        }
    }
}
