package app.com.proyectorestaurant.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Magallanes on 07/07/2016.
 */
public class ManageOpenHelper extends SQLiteOpenHelper {

    public ManageOpenHelper(Context context) {
        super(context, "restaurant.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_usuario(" +
                "uid integer auto_increment primary key," +
                "unombre text," +
                "ucorreo text," +
                "ucontrasenia text," +
                "plato text," +
                "cantidad text )");
        db.execSQL("insert into tb_usuario(unombre,ucorreo,ucontrasenia,plato,cantidad)values('jose','m','q','arroz','1')");
        db.execSQL("insert into tb_usuario(unombre,ucorreo,ucontrasenia,plato,cantidad)values('jose','m','111','arroz','1')");
        db.execSQL("insert into tb_usuario(unombre,ucorreo,ucontrasenia,plato,cantidad)values('jose','m','111','arroz','1')");
        db.execSQL("insert into tb_usuario(unombre,ucorreo,ucontrasenia,plato,cantidad)values('jose','m','111','arroz','1')");
        db.execSQL("insert into tb_usuario(unombre,ucorreo,ucontrasenia,plato,cantidad)values('jose','m','111','arroz','1')");
        db.execSQL("insert into tb_usuario(unombre,ucorreo,ucontrasenia,plato,cantidad)values('jose','m','111','arroz','1')");
        db.execSQL("insert into tb_usuario(unombre,ucorreo,ucontrasenia,plato,cantidad)values('jose','m','111','arroz','1')");
        db.execSQL("insert into tb_usuario(unombre,ucorreo,ucontrasenia,plato,cantidad)values('jose','m','111','arroz','1')");
        db.execSQL("insert into tb_usuario(unombre,ucorreo,ucontrasenia,plato,cantidad)values('jose','m','111','arroz','1')");
        db.execSQL("insert into tb_usuario(unombre,ucorreo,ucontrasenia,plato,cantidad)values('jose','m','111','arroz','1')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
