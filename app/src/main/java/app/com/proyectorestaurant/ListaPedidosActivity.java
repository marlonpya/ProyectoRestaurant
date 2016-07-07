package app.com.proyectorestaurant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import app.com.proyectorestaurant.adapter.AdapterUsuario;
import app.com.proyectorestaurant.aplication.Configuracion;
import app.com.proyectorestaurant.model.Usuario;

public class ListaPedidosActivity extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Usuario> array;
    private AdapterUsuario adapterUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos);

        lista = (ListView)findViewById(R.id.lista);

        array = Configuracion.querysSQL.listarPlatos();

        adapterUsuario = new AdapterUsuario(array,ListaPedidosActivity.this);
        lista.setAdapter(adapterUsuario);
    }
}
