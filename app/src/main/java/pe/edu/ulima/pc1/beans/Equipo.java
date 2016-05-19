package pe.edu.ulima.pc1.beans;

import java.io.Serializable;

public class Equipo implements Serializable {
    private long id;
    private String nombre;
    private String urlFoto;
    private int partidosGanados;
    private int partidosPerdidos;

    public Equipo() {
        super();
    }

    public Equipo(long id, String nombre, String urlFoto, int partidosGanados, int partidosPerdidos) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
