package app.com.proyectorestaurant;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.com.proyectorestaurant.sqlite.ManageOpenHelper;

public class PedidosActivity extends AppCompatActivity {
    private TextView lblPlatos;
    private EditText txtCantidad;
    private Button btnRegresar,btnPedir;
    private String cantidad,plato;
    private ManageOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        txtCantidad = (EditText)findViewById(R.id.txtCantidad);
        lblPlatos = (TextView) findViewById(R.id.lblPlatos);
        btnPedir = (Button)findViewById(R.id.btnPedir);
        btnRegresar = ( Button)findViewById(R.id.btnRegresar);

    }

    @Override
    protected void onResume() {
        super.onResume();
        lblPlatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = getResources().getStringArray(R.array.platos);
                new AlertDialog.Builder(PedidosActivity.this)
                        .setTitle("Escoge un plato")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                lblPlatos.setText(items[which]);
                            }
                        })
                        .create()
                        .show();
            }
        });
        btnPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidad = txtCantidad.getText().toString().trim();
                plato = lblPlatos.getText().toString().trim();
                if (cantidad.isEmpty()){
                    Toast.makeText(PedidosActivity.this, "por favor ingrese una cantidad", Toast.LENGTH_SHORT).show();
                }else if (cantidad.length()>2){
                    Toast.makeText(PedidosActivity.this, "su cantidad es excesiva, ingrese menor de 10", Toast.LENGTH_SHORT).show();

                }else if(plato.equals("Escoga un plato")){
                    Toast.makeText(PedidosActivity.this,"necesita un plato para el registro",Toast.LENGTH_SHORT).show();
                }else{
                    helper = new ManageOpenHelper(getApplicationContext());
                    SQLiteDatabase db = helper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put("plato",plato );
                    values.put("cantidad",cantidad);
                    db.insert("tb_usuario",null,values);

                    Intent intent = new Intent(PedidosActivity.this,ListaPedidosActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PedidosActivity.this,PerfilUsuarioActivity.class);
                        startActivity(intent);
            }
        });
    }
}
