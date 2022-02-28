package chaira.carlos.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class Catalogo : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()
    val gridview: GridView = findViewById(R.id.gridview)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()

        adapter = PeliculasAdapter(peliculas, this)
        gridview.adapter = adapter
    }

    fun cargarPeliculas(){
        peliculas.add(Pelicula("Big hero",R.drawable.bighero6,R.drawable.headerbighero6,""))
        peliculas.add(Pelicula("1917",R.drawable.mil,R.drawable.milHeader,""))
        peliculas.add(Pelicula("Leap Year",R.drawable.leapyear,R.drawable.leapyearheader,""))
        peliculas.add(Pelicula("Men in black",R.drawable.mib,R.drawable.mibheader,""))
        peliculas.add(Pelicula("Toy story",R.drawable.toystory,R.drawable.toystoryheader,""))
        peliculas.add(Pelicula("Inception",R.drawable.inception,R.drawable.inceptionheader,""))

        peliculas.add(Pelicula("Dr. House",R.drawable.drhouse,R.drawable.dr,""))
        peliculas.add(Pelicula("Dr. Who",,,""))
        peliculas.add(Pelicula("Friends",,,""))
        peliculas.add(Pelicula("Smallville",,,""))

    }

}