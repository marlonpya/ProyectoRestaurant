package app.com.proyectorestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.com.proyectorestaurant.aplication.Configuracion;

public class LoginActivity extends AppCompatActivity {
    private EditText txtCorreo,txtContrasenia;
    private Button btnIngresar,btnRegistrar;
    private String correo,contrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContrasenia = (EditText)findViewById(R.id.txtContrasenia);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        btnRegistrar = (Button)findViewById(R.id.btnRegistrar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo = txtCorreo.getText().toString().trim();
                contrasenia = txtContrasenia.getText().toString().trim();

                if (correo.equals("") && contrasenia.equals("")){
                    Toast.makeText(LoginActivity.this,"se requieren todos los datos",Toast.LENGTH_SHORT).show();

                }else if(Configuracion.querysSQL.validarUsuario(correo,contrasenia)){
                    Intent intent = new Intent(LoginActivity.this,PerfilUsuarioActivity.class);
                    intent.putExtra("correo",correo);
                    intent.putExtra("contrasenia",contrasenia);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"Usuario incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegistrarActivity.class);
                startActivity(intent);
            }
        });
    }
}
