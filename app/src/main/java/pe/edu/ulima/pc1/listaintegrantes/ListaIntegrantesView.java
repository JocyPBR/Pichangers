package pe.edu.ulima.pc1.listaintegrantes;

import java.util.List;

import pe.edu.ulima.pc1.beans.Integrante;

/**
 * Created by Melgarejo on 15/05/2016.
 */
public interface ListaIntegrantesView {
    public void setPresenter(ListaIntegrantesPresenter presenter);
    public void mostrarListaIntegrantes(List<Integrante> body);
}
