package app.com.proyectorestaurant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import app.com.proyectorestaurant.R;
import app.com.proyectorestaurant.model.Usuario;

/**
 * Created by Magallanes on 07/07/2016.
 */
public class AdapterUsuario extends BaseAdapter {
    private ArrayList<Usuario> lista;
    private Context context;
    private TextView itemNombre,itemCantidad;

    public AdapterUsuario(ArrayList<Usuario> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_plato,parent,false);
        itemNombre = (TextView) view.findViewById(R.id.itemNombre);
        itemCantidad = (TextView)view.findViewById(R.id.itemCantidad);
        Usuario item = (Usuario) getItem(position);
        itemNombre.setText("Nombre de Plato :"+item.getUnombre());
        itemCantidad.setText("Su cantidad pedida fue: "+item.getCantidad());
        return view;
    }
}
