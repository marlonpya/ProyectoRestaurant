package app.com.proyectorestaurant.model;

/**
 * Created by Magallanes on 07/07/2016.
 */
public class Usuario {

    private int id;
    private String unombre;
    private String ucorreo;
    private String ucontrasenia;
    private String plato;
    private String cantidad;

    public Usuario(int id, String unombre, String ucorreo, String ucontrasenia, String plato, String cantidad) {
        this.id = id;
        this.unombre = unombre;
        this.ucorreo = ucorreo;
        this.ucontrasenia = ucontrasenia;
        this.plato = plato;
        this.cantidad = cantidad;
    }

    public Usuario(String plato, String cantidad) {
        this.plato = plato;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnombre() {
        return unombre;
    }

    public void setUnombre(String unombre) {
        this.unombre = unombre;
    }

    public String getUcorreo() {
        return ucorreo;
    }

    public void setUcorreo(String ucorreo) {
        this.ucorreo = ucorreo;
    }

    public String getUcontrasenia() {
        return ucontrasenia;
    }

    public void setUcontrasenia(String ucontrasenia) {
        this.ucontrasenia = ucontrasenia;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}

