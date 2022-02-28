package chaira.carlos.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detalle_pelicula : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val iv_pelicula_imagen: ImageView = findViewById(R.id.iv_peliculaImagen)
        val tv_nombre_pelicula: TextView = findViewById(R.id.tv_peliculaNombre)
        val tv_pelicula_desc: TextView = findViewById(R.id.tv_peliculaDesc)

        val bundle=intent.extras
        if (bundle!=null){
            iv_pelicula_imagen.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("titulo"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))

        }

    }
}