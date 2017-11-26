package com.example.cloudfirestore;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prashant on 25-11-2017.
 */

public class DataClass {

    private String title, organiser, venue, time;
    private static final String TITLE = "title";
    private static final String ORGANISER = "organiser";
    private static final String VENUE = "venue";
    private static final String DATE = "date";

    public DataClass(){}
    public DataClass(String title, String organiser, String venue, String time) {
        this.title = title;
        this.organiser = organiser;
        this.venue = venue;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



        public static List<DataClass> getObjectList()
    {
         FirebaseDatabase database;
         DatabaseReference databaseRef;
        List<DataClass> dataList = new ArrayList<>();

        DocumentReference mDocRef = FirebaseFirestore.getInstance().document("events/society");
        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists())
                {
                    String title = documentSnapshot.getString(TITLE);
                    String organiser = documentSnapshot.getString(ORGANISER);
                    String venue = documentSnapshot.getString(VENUE);
                    String date = documentSnapshot.getString(DATE);

                }
            }
        });

        for (int i = 0; i<10; i++)
        {
            database = FirebaseDatabase.getInstance();
            databaseRef = database.getReference("events");
            databaseRef.getDatabase();
            DataClass dataAdapter = new DataClass("title", "organiser", "venue", "time");
            dataList.add(dataAdapter);
        }
        return dataList;
    }

}
