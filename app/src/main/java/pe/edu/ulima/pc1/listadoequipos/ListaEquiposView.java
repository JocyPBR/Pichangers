package pe.edu.ulima.pc1.listadoequipos;

import java.util.List;

import pe.edu.ulima.pc1.beans.Equipo;

/**
 * Created by Melgarejo on 16/05/2016.
 */
public interface ListaEquiposView {
    public void setPresenter(ListaEquiposPresenter presenter);
    public void mostrarListaEquipos(List<Equipo> equipos);
}
