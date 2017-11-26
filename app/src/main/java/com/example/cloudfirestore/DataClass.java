package com.example.cloudfirestore;

import android.widget.TextView;

/**
 * Created by Prashant on 25-11-2017.
 */

public class DataClass {

    private String title, organiser, venue, time;
    private static final String TITLE = "title";
    private static final String ORGANISER = "organiser";
    private static final String VENUE = "venue";
    private static final String DATE = "date";
    TextView tv;

    public DataClass() {
    }

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
}

//
//    public static List<DataClass> getObjectList()
//        {
//            final List<DataClass> dataList = new ArrayList<>();
//
//        DocumentReference mDocRef = FirebaseFirestore.getInstance().document("events/society");
//
//            mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                @Override
//                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                    if (documentSnapshot.exists())
//                    {
//                        String title = documentSnapshot.getString(TITLE);
//                        String organiser = documentSnapshot.getString(ORGANISER);
//                        String venue = documentSnapshot.getString(VENUE);
//                        String date = documentSnapshot.getString(DATE);
//                    }
//                }
//            });
//
//            DataClass dataAdapter = new DataClass("Title", "organiser", "venue", "time");
//            dataList.add(dataAdapter);
//            return dataList;
//    }
