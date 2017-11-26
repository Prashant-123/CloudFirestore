package com.example.cloudfirestore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

    public void save(View view)
    {
        EditText et1 = (EditText) findViewById(R.id.newTitle);
        EditText et2 = (EditText) findViewById(R.id.newOrganiser);
        EditText et3 = (EditText) findViewById(R.id.newVenue);
        EditText et4 = (EditText) findViewById(R.id.newTime);

        DataClass data = new DataClass(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString());
        database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference();

        Intent intent = getIntent();
        int count = intent.getIntExtra("COUNT", 0);
        Log.i("tag", "Count-Reciever: " + count);
        String ctr = String.valueOf(count);
        Log.i("tag", "CTR: "+ ctr.toString());


        databaseRef.child("events").child(ctr).setValue(data).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(CreateEvent.this, "Event Created", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Events.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CreateEvent.this, "Internal Error Occurred. \n Try Again", Toast.LENGTH_SHORT).show();
            }
        });

//        DocumentReference mDocRef = FirebaseFirestore.getInstance().document("events/society");
//
//        Map<String, Object> dataToSave = new HashMap<String, Object>();
//        dataToSave.put(TITLE, et1.getText().toString());
//        dataToSave.put(ORGANISER, et2.getText().toString());
//        dataToSave.put(VENUE, et3.getText().toString());
//        dataToSave.put(DATE, et4.getText().toString());
//        mDocRef.set(dataToSave);
    }

}
