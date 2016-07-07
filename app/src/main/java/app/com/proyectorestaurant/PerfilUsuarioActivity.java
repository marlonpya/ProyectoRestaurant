package app.com.proyectorestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PerfilUsuarioActivity extends AppCompatActivity {
    private TextView txtNombreUsuario,txtCorreo;
    private Button btnIrAPedidos,btnCerrarSesion,btnIrALista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        txtNombreUsuario=(TextView)findViewById(R.id.txtNombreUsuario);
        txtCorreo =(TextView)findViewById(R.id.txtCorreo);
        btnIrAPedidos=(Button)findViewById(R.id.btnIrAPedidos);
        btnCerrarSesion =(Button)findViewById(R.id.btnCerrarSesion);
        btnIrALista=(Button)findViewById(R.id.btnIrALista);

        txtNombreUsuario.setText(getIntent().getStringExtra("correo"));
        txtCorreo.setText(getIntent().getStringExtra("contrasenia"));
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnIrAPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilUsuarioActivity.this,PedidosActivity.class);
                startActivity(intent);
            }
        });
        btnIrALista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PerfilUsuarioActivity.this,ListaPedidosActivity.class);
                startActivity(intent);
            }
        });
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilUsuarioActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
