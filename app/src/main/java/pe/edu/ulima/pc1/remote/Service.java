package pe.edu.ulima.pc1.remote;

import java.util.List;

import pe.edu.ulima.pc1.beans.Equipo;
import pe.edu.ulima.pc1.beans.Integrante;
import pe.edu.ulima.pc1.beans.LoginRespuesta;
import pe.edu.ulima.pc1.beans.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Melgarejo on 16/05/2016.
 */
public interface Service {
    @POST("alumnos/login")
    Call<LoginRespuesta> loginUsuario(@Body Usuario usuario);

    @GET("alumnos")
    Call<List<Integrante>> obtenerIntegrantes(@Query("sin_equipo") boolean sinEquipo);

    @POST("integrantes")
    Call agregarIntegrantes(@Body Integrante integrante);

    @GET("equipos")
    Call<List<Equipo>> obtenerEquipo();

    @POST("equipos")
    Call agregarEquipos(@Body Equipo equipo);

    @GET("equipos")
    Call<Equipo> obtenerInformacion(@Path("id") long id);
}
