package com.example.se328project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper
{
    //Define the Database
    private Context context;
    private static final String DATABASE_NAME = "SE328Library";
    private static final int DATABASE_VERSION = 1;

    //Define the table name
    private static final String TABLE_NAME = "books";

    //Define the column Names
    private static final String COLUMN_ISBN = "BOOK_isbn";
    private static final String COLUMN_TITLE = "book_title";
    private static final String COLUMN_AUTHOR = "book_author";
    private static final String COLUMN_BORROWE_NAME = "book_borrower_name";
    private static final String COLUMN_CATEGORY = "book_category";
    private static final String COLUMN_TYPE = "book_type";
    private static final String COLUMN_PRICE = "book_price";
    private static final String COLUMN_OPERATION = "book_operation";

    public MyDatabaseHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ISBN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                       COLUMN_TITLE + " TEXT, " + COLUMN_AUTHOR + " TEXT, " + COLUMN_BORROWE_NAME + " TEXT, " +
                       COLUMN_CATEGORY + " TEXT, " + COLUMN_TYPE + " TEXT, " + COLUMN_PRICE + " DECIMAL, " +
                       COLUMN_OPERATION + " TEXT);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public void addBookRecord(String title,String author,String category,String type, double price)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =  new ContentValues();

        values.put(COLUMN_TITLE,title);
        values.put(COLUMN_AUTHOR,author);
        values.put(COLUMN_CATEGORY,category);
        values.put(COLUMN_TYPE,type);
        values.put(COLUMN_PRICE,price);

        long result = db.insert(TABLE_NAME,null, values);

        if (result == -1)
            Toast.makeText(context,"Failed adding",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context,"Successfully added",Toast.LENGTH_LONG).show();
    }
}
