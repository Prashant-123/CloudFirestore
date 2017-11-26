package com.example.cloudfirestore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CreateEvent extends AppCompatActivity {

    private static final String TITLE = "title";
    private static final String ORGANISER = "organiser";
    private static final String VENUE = "venue";
    private static final String DATE = "date";
    private FirebaseDatabase database;
    private DatabaseReference databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
    }

//    public void save(View view)
//    {
//        EditText et1 = (EditText) findViewById(R.id.newTitle);
//        EditText et2 = (EditText) findViewById(R.id.newOrganiser);
//        EditText et3 = (EditText) findViewById(R.id.newVenue);
//        EditText et4 = (EditText) findViewById(R.id.newTime);
//
//        database = FirebaseDatabase.getInstance();
//        databaseRef = database.getReference();
//        DataClass dataInput = new DataClass(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString());
//        String key = databaseRef.child("events").push().getKey();
//        databaseRef.child("events").child(key).setValue(dataInput);
//    }

    public void save(View view)
    {
        EditText et1 = (EditText) findViewById(R.id.newTitle);
        EditText et2 = (EditText) findViewById(R.id.newOrganiser);
        EditText et3 = (EditText) findViewById(R.id.newVenue);
        EditText et4 = (EditText) findViewById(R.id.newTime);

        DocumentReference mDocRef = FirebaseFirestore.getInstance().document("events/society");

        Map<String, Object> dataToSave = new HashMap<String, Object>();
        dataToSave.put(TITLE, et1.getText().toString());
        dataToSave.put(ORGANISER, et1.getText().toString());
        dataToSave.put(VENUE, et1.getText().toString());
        dataToSave.put(DATE, et1.getText().toString());
        mDocRef.set(dataToSave);
    }

}
