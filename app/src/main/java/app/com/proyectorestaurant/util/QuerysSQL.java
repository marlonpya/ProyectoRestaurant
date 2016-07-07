package app.com.proyectorestaurant.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import app.com.proyectorestaurant.model.Usuario;
import app.com.proyectorestaurant.sqlite.ManageOpenHelper;

/**
 * Created by Magallanes on 07/07/2016.
 */
public class QuerysSQL {

    private ManageOpenHelper dbConexion;

    public QuerysSQL(Context context){
        dbConexion = new ManageOpenHelper(context);
    }


    public ArrayList<Usuario> listarPlatos(){
        ArrayList<Usuario> lista = new ArrayList<>();
        SQLiteDatabase db =dbConexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_usuario",null);
        if (cursor!=null){
            if (cursor.getCount()>0){
                if (cursor.moveToFirst()){
                    do {
                        Usuario usuario = new Usuario(cursor.getInt(cursor.getColumnIndex("uid")),
                                                        cursor.getString(cursor.getColumnIndex("unombre")),
                                                        cursor.getString(cursor.getColumnIndex("ucorreo")),
                                                        cursor.getString(cursor.getColumnIndex("ucontrasenia")),
                                                        cursor.getString(cursor.getColumnIndex("plato")),
                                                        cursor.getString(cursor.getColumnIndex("cantidad")));
                        lista.add(usuario);
                    }while (cursor.moveToNext());
                }
            }
        }
        return lista;
    }

    public boolean validarUsuario( String correo, String contrasenia){
        boolean resultado =false;
        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_usuario order by uid desc" +
                " where ucorreo='"+correo+"' and ucontrasenia='"+contrasenia+"'",null);
        if (cursor.moveToFirst()){
            resultado = true;
        }
        return resultado;
    }
}

