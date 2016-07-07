package app.com.proyectorestaurant;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.com.proyectorestaurant.sqlite.ManageOpenHelper;

public class RegistrarActivity extends AppCompatActivity {
    private EditText txtNombre,txtCorreo,txtContrasenia;
    private Button btnRegistrarUsuario;
    private String nombre,correo,contrasenia;
    private ManageOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtCorreo = (EditText)findViewById(R.id.txtCorreo);
        txtContrasenia = (EditText)findViewById(R.id.txtContrasenia);
        btnRegistrarUsuario = (Button)findViewById(R.id.btnRegistrarUsuario);
    }

    @Override
    protected void onResume() {
        super.onResume();
        nombre = txtNombre.getText().toString().trim();
        correo = txtCorreo.getText().toString().trim();
        contrasenia = txtContrasenia.getText().toString().trim();

        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre.equals("") || contrasenia.equals("")|| contrasenia.equals("")){
                    Toast.makeText(RegistrarActivity.this, "Se requieren todos los datos", Toast.LENGTH_SHORT).show();
                }else{
                    ContentValues values = new ContentValues();
                    values.put("unombre",nombre);
                    values.put("ucontrasenia",contrasenia);
                    values.put("ucorreo",correo);
                    helper = new ManageOpenHelper(getApplicationContext());
                    SQLiteDatabase db = helper.getWritableDatabase();
                    db.insert("tb_usuario",null,values);
                }
            }
        });
    }
}
