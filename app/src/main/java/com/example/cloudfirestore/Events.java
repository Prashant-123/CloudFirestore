package com.example.cloudfirestore;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Events extends AppCompatActivity {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    private static final String TITLE = "title";
    private static final String ORGANISER = "organiser";
    private static final String VENUE = "venue";
    private static final String DATE = "date";

    private FirebaseDatabase database;
    private DatabaseReference databaseRef;

    TextView tv1, tv2, tv3, tv4;
    int count;
    int i=1;
    public ArrayList<DataClass> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        final MyAdapter adapter = new MyAdapter(this, data);
        recyclerView.setAdapter(adapter);
//        DataClass newData = new DataClass(null, null, null, null);
//        data.add(newData);

        database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference();

        databaseRef.child("events").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                i++;
                count = (int) dataSnapshot.getChildrenCount();
                DataClass newData = dataSnapshot.getValue(DataClass.class);
                data.add(newData);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void login(View view)
    {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.fragment_login, null);
        final EditText username = alertLayout.findViewById(R.id.User);
        final EditText password = alertLayout.findViewById(R.id.Pass);
        final CheckBox cbToggle = alertLayout.findViewById(R.id.cb_show_pass);

        cbToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                 else
                    password.setInputType(129);
            }
        });

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Sign-In");
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Log-In Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Log In", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                    DocumentReference mDocRef = FirebaseFirestore.getInstance().document("username/society");
                    mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                //Data myData = documentSnapshot.toObject(Data.class);
                                String u = documentSnapshot.getString(USERNAME);
                                String p = documentSnapshot.getString(PASSWORD);
                                if (username.getText().toString().equals(u)&& password.getText().toString().equals(p))
                                {
                                    //fetch();
                                }

                            }
                        }
                    });
                }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void change(View view)
    {
        Intent intent = new Intent(this, CreateEvent.class);
        intent.putExtra("COUNT", i);
        Log.i("tag", "Count-Sender: "  + i);
        startActivity(intent);
    }


}
