package com.code.i.firebase_crud__;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class crud extends AppCompatActivity {
Button in,del,up,sel;
EditText id,name,adress,mobile;
    FirebaseDatabase db;
    DatabaseReference myRef;
    String sId,sName,sAdress,sMobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);
        in=(Button)findViewById(R.id.btnInsert);
        up=(Button)findViewById(R.id.btnUpdate);
        del=(Button)findViewById(R.id.btnDelete);
        sel=(Button)findViewById(R.id.btnSelect);
        id=(EditText)findViewById(R.id.txtId);
        name=(EditText)findViewById(R.id.txtName);
        adress=(EditText)findViewById(R.id.txtAdress);
        mobile=(EditText)findViewById(R.id.txtMobile);
        db= FirebaseDatabase.getInstance();


        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });
        sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select();
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });


    }


    // Write a message to the database
    public void insert(){

        sId=id.getText().toString().toUpperCase();
        sName=name.getText().toString().toUpperCase();
        sAdress=adress.getText().toString().toUpperCase();
        sMobile=mobile.getText().toString().toUpperCase();
        myRef= db.getReference(sId);
        myRef.child("id").setValue(sId);
        myRef.child("name").setValue(sName);
        myRef.child("adress").setValue(sAdress);
        myRef.child("mobile").setValue(sMobile);
        Toast.makeText(crud.this,"Successfuly Inserted",Toast.LENGTH_SHORT).show();

    }

    public void update(){


        sId=id.getText().toString().toUpperCase();
        sName=name.getText().toString().toUpperCase();
        sAdress=adress.getText().toString().toUpperCase();
        sMobile=mobile.getText().toString().toUpperCase();
        myRef= db.getReference(sId);
        myRef.child("id").setValue(sId);
        myRef.child("name").setValue(sName);
        myRef.child("adress").setValue(sAdress);
        myRef.child("mobile").setValue(sMobile);
        Toast.makeText(crud.this,"Successfuly Updated",Toast.LENGTH_SHORT).show();
    }
    public void delete(){


    }
    public void select(){

        sId=id.getText().toString().toUpperCase();
//        sName=name.getText().toString().toUpperCase();
//        sAdress=adress.getText().toString().toUpperCase();
//        sMobile=mobile.getText().toString().toUpperCase();
        myRef= db.getReference(sId);
        //DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mostafa = myRef.child("id");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Map<String,String> map=(Map<String, String>)dataSnapshot.getValue();
//                String value = dataSnapshot.getValue(String.class);
                String n=map.get("name");


                Toast.makeText(crud.this,n,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(crud.this,"ERROR",Toast.LENGTH_SHORT).show();

            }
        });

    }

}
