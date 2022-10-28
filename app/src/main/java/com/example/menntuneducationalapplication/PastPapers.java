package com.example.menntuneducationalapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PastPapers extends AppCompatActivity {
    ListView listView;
    DatabaseReference databaseReference;
    List<uploadPDF>uploads;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_papers);

        listView = findViewById(R.id.listView);
        uploads = new ArrayList<>();

        //create method
        viewAllFiles();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                uploadPDF uploadPDF = uploads.get(i);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType("application/pdf");
                intent.setData(Uri.parse(uploadPDF.getUrl()));
                startActivity(intent);


            }
        });


    }

    private void viewAllFiles() {

        databaseReference = FirebaseDatabase.getInstance().getReference("PastPaper");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot postsnapshot:snapshot.getChildren()){
                    uploadPDF uploadPDF = postsnapshot.getValue(com.example.menntuneducationalapplication.uploadPDF.class);

                    uploads.add(uploadPDF);
                }
                String[] Uploads = new String[uploads.size()];
                for(int i=0;i<Uploads.length;i++){
                    Uploads[i]=(uploads.get(i).getSubject()+" "+uploads.get(i).getGrade()+" "+uploads.get(i).getYear());
                }
                ArrayAdapter<String>adapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1,Uploads){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


                       View view = super.getView(position,convertView,parent);
                       TextView text =(TextView) view.findViewById(android.R.id.text1);
                       text.setTextColor(Color.WHITE);

                       text.setTextSize(22);
                       return view;

                    }
                };
               listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
