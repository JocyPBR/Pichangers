package pe.edu.ulima.pc1.listadoequipos;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Melgarejo on 18/05/2016.
 */
public class ListaEquiposItemView extends ImageView {

    public ListaEquiposItemView(Context context) {
        super(context);
    }

    public ListaEquiposItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListaEquiposItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
