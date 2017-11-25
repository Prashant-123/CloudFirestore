package com.example.cloudfirestore;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prashant on 25-11-2017.
 */

public class DataClass {

    private String title, time, organiser;

    public void setTitle(String title){this.title = title;}
    public String getTitle(){return title;}

    public void setTime(String time){this.time = time;}
    public String getTime(){return time;}

    public void setOrganiser(String organiser){this.organiser = organiser;}
    public String getOrganiser(){return organiser;}

    public static List<DataClass> getObjectList()
    {
        List<DataClass> dataList = new ArrayList<>();
        String[] text = {"11", "22", "33"};

        Log.i("tag", "Size: " + text.length);
        for (int i = 0; i<text.length; i++)
        {
            DataClass data = new DataClass();
            data.setTitle("List-Item" + i);
            data.setTime("Time: " + i);
            data.setOrganiser("Organiser- " + i);
            dataList.add(data);
        }
        return dataList;
    }

}
