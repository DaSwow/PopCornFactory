package chaira.carlos.popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Catalogo : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()

        var gridview: GridView = findViewById(R.id.gridview)
        adapter = PeliculaAdapter(peliculas, this)
        gridview.adapter = adapter
    }

    fun cargarPeliculas(){
        peliculas.add(Pelicula("Big hero",R.drawable.bighero6,R.drawable.headerbighero6,"When a devastating turn of events catapults them into the midst of a dangerous plot unfolding in the streets of San Fransokyo, Hiro turns to Baymax and his group of friends—who transform into a band of unlikely heroes."))
        peliculas.add(Pelicula("1917",R.drawable.mil,R.drawable.milheader,"Partially inspired by stories told to Mendes by his paternal grandfather Alfred about his service during World War I"))
        peliculas.add(Pelicula("Leap Year",R.drawable.leapyear,R.drawable.leapyearheader,"Leap Year is a 2010 romantic comedy directed by Anand Tucker and written by Harry Elfont and Deborah Kaplan. Leap Year stars Amy Adams and Matthew Goode."))
        peliculas.add(Pelicula("Men in black",R.drawable.mib,R.drawable.mibheader,"A police officer joins a secret organization that polices and monitors extraterrestrial interactions on Earth."))
        peliculas.add(Pelicula("Toy story",R.drawable.toystory,R.drawable.toystoryheader,"Woody (Tom Hanks), a good-hearted cowboy doll who belongs to a young boy named Andy (John Morris), sees his position as Andy's favorite toy jeopardized when his parents buy him a Buzz Lightyear (Tim Allen) action figure. Even worse, the arrogant Buzz thinks he's a real spaceman on a mission to return to his home planet. When Andy's family moves to a new house, Woody and Buzz must escape the clutches of maladjusted neighbor Sid Phillips (Erik von Detten) and reunite with their boy."))
        peliculas.add(Pelicula("Inception",R.drawable.inception,R.drawable.inceptionheader,"Dom Cobb (Leonardo DiCaprio) is a thief with the rare ability to enter people's dreams and steal their secrets from their subconscious. His skill has made him a hot commodity in the world of corporate espionage but has also cost him everything he loves. Cobb gets a chance at redemption when he is offered a seemingly impossible task: Plant an idea in someone's mind. If he succeeds, it will be the perfect crime, but a dangerous enemy anticipates Cobb's every move."))

        peliculas.add(Pelicula("Dr. House",R.drawable.drhouse,R.drawable.househeader,"The series follows the life of anti-social, pain killer addict, witty and arrogant medical doctor Gregory House (Hugh Laurie) with only half a muscle in his right leg. He and his team of medical doctors try to cure complex and rare diseases from very ill ordinary people in the United States of America."))
        peliculas.add(Pelicula("Dr. Who",R.drawable.drwho,R.drawable.drwhoheader,"Doctor Who chronicled the adventures of an eccentric time-traveling scientist from the remote planet Gallifrey, home of the Time Lords. The Doctor, a Time Lord himself, traveled through time and space in his unique craft, the TARDIS, an acronym for Time and Relative Dimensions in Space."))
        peliculas.add(Pelicula("Friends",R.drawable.friends,R.drawable.friendsheader,"Friends is a 90's Comedy TV show, based in Manhattan, about 6 friends who go through just about every life experience imaginable together; love, marriage, divorce, children, heartbreaks, fights, new jobs and job losses and all sorts of drama."))
        peliculas.add(Pelicula("Smallville",R.drawable.smallville,R.drawable.smallvilleheader,"Smallville is based on the popular DC Comics character, Superman. The series follows the life of a teenage Clark Kent living in the town of Smallville, Kansas that is set at the start of the 21st century."))

    }

     class PeliculaAdapter : BaseAdapter{
        var peliculas = ArrayList<Pelicula>()
        var context: Context? = null

        constructor(peliculas: ArrayList<Pelicula>, context: Context?) : super(){
            this.peliculas = peliculas
            this.context = context
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(p0: Int): Any {
            return peliculas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var pelicula = peliculas[p0]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.pelicula, null)
            var imagen=vista.findViewById(R.id.iv_pelicula) as ImageView
            var nombre=vista.findViewById(R.id.tv_titulo) as TextView

            imagen.setImageResource(pelicula.image)
            nombre.setText(pelicula.titulo)

            imagen.setOnClickListener (){
                var intent = Intent(context, Detalle_pelicula::class.java)
                intent.putExtra("titulo", pelicula.titulo)
                intent.putExtra("image", pelicula.image)
                intent.putExtra("header", pelicula.header)
                intent.putExtra("sinopsis", pelicula.sinopsis)
                context!!.startActivity(intent)

            }
            return vista
        }

    }

}