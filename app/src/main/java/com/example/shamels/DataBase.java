package com.example.shamels;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.ArrayList;

//بنعمل وراثه من الكلاس
//بنعمل امبلميتت للمثود
//وبنعمل كونستركتور وبنعرف فيها الاشياء الى تحت وبنحف الى ما بدنا اياه

public class DataBase extends SQLiteOpenHelper {

    public static final String DB_name="Games_db";
    public static final int DB_VERSION=11;//لما نغير قميتة بدخل ع الداله التانية داله التحديث
    public  static  String Game_TB_NAME="Game";
    public  static  String Game_CLM_SCORE="score";
    public  static  String Game_CLM_NAME="name";
    public  static  String Game_CLM_DATE="date";
    public  static  final String Game_CLM_ID="id";




//كونستركتور بنعملها امبليمنت
    public DataBase(@Nullable Context context) {
        super(context, DB_name, null, DB_VERSION);
    }


    @Override
    //اول داله يتم استدعائها عند التشغيل
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ Game_TB_NAME+" " +
                "( " +Game_CLM_ID+" INTEGER primary key autoincrement," +Game_CLM_SCORE+" INTEGER, "
                +Game_CLM_DATE+" TEXT, "+Game_CLM_NAME+" TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //يتم استدعائها عند تحديث الداتابيس
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +Game_TB_NAME);
        onCreate(sqLiteDatabase);


    }

    public  boolean insertGame(Game game){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Game_CLM_NAME,game.getName());
        values.put(Game_CLM_SCORE,game.getScore());
        values.put(Game_CLM_DATE,game.getDate());

        long resuit=db.insert(Game_TB_NAME, null ,values);
        return resuit !=-1;

    }
    public ArrayList<Game> getAllGames(){

        ArrayList<Game> games = new ArrayList<>();
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from "+ Game_TB_NAME,null);
        if (cursor.moveToFirst()){
            do {
                String name=cursor.getString(cursor.getColumnIndexOrThrow(Game_CLM_NAME));
                int scre=cursor.getInt(cursor.getColumnIndexOrThrow(Game_CLM_SCORE));
                String date=cursor.getString(cursor.getColumnIndexOrThrow(Game_CLM_DATE));

                Game games1=new Game(scre,name,date);
                games.add(games1);

            }while (cursor.moveToNext());
            cursor.close();
        }

        return  games;
    }


    ///عرض البيانات
//    RecyclerviewAdapter adapter;
//    Database database;
//    database=new Database(this);
//    ArrayList<Games> games=database.getAllGames();
//    adapter=new RecyclerviewAdapter(games,this);
//        binding.Recyclerview.setAdapter(adapter);
//        binding.Recyclerview.setHasFixedSize(true);
//        binding.Recyclerview.setLayoutManager(new LinearLayoutManager(this));

       //اضافه البايانات
//    RecyclerviewAdapter adapter;
//    Database database;
//    database = new Database(getBaseContext());
//    int Score = Integer.parseInt(binding.tvScores.getText().toString());
//    String date = DateFormat.getDateInstance().format(c.getTime());
//    String Name = binding.tvNameandage.getText().toString();
//    Games games = new Games(Score, Name, date);
//    boolean reselt = database.insertGame(games);
}
