package pe.edu.ulima.pc1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pe.edu.ulima.pc1.beans.Equipo;

public class InformacionActivity extends AppCompatActivity{
    TextView tviNombreEquipo, tviVictoria, tviDerrota;
    ImageView eteEquipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        tviNombreEquipo = (TextView) findViewById(R.id.tviNombreEquipo);
        eteEquipo = (ImageView) findViewById(R.id.eteEquipo);
        tviVictoria = (TextView) findViewById(R.id.tviVictoria);
        tviDerrota = (TextView) findViewById(R.id.tviDerrota);

        Intent intent = getIntent();
        Equipo equipo = (Equipo) intent.getSerializableExtra("equipo");

        tviNombreEquipo.setText(equipo.getNombre());
        tviVictoria.setText("Partidos ganados: " + String.valueOf(equipo.getPartidosGanados()));
        tviDerrota.setText("Partidos perdidos: " + String.valueOf(equipo.getPartidosPerdidos()));

        Picasso.with(this).load(equipo.getUrlFoto()).into(eteEquipo);
    }
}
