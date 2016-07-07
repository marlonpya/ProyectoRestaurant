package app.com.proyectorestaurant.aplication;

import android.app.Application;

import app.com.proyectorestaurant.util.QuerysSQL;

/**
 * Created by Marlon on 07/07/2016.
 */
public class Configuracion extends Application {
    public static QuerysSQL querysSQL;

    @Override
    public void onCreate() {
        super.onCreate();
        querysSQL = new QuerysSQL(getApplicationContext());
    }

}
