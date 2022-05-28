package com.example.se328project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActsqlActivity extends AppCompatActivity implements View.OnClickListener
{
    Button bAdd;
    Button bDelete;
    Button bUpdate;
    Button bSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actsql);

        bAdd = findViewById(R.id.sqlbadd);
        bDelete = findViewById(R.id.sqlbdelete);
        bUpdate = findViewById(R.id.sqlbupdate);
        bSearch = findViewById(R.id.sqlbsearch);

        bAdd.setOnClickListener(this);
        bDelete.setOnClickListener(this);
        bUpdate.setOnClickListener(this);
        bSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.sqlbadd)
        {
            startActivity(new Intent(this,ActsqlAddActivity.class));
        }
    }
}