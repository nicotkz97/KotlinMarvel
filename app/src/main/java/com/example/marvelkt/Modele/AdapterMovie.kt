

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelkt.Modele.Données.Movie
import com.example.marvelkt.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item.view.*


class AdapterMovie (private val context: Context, private val cardList: MutableList<Movie>) : RecyclerView.Adapter<AdapterMovie.MyViewHolder>(){

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var image: ImageView
        var nom : TextView
        var acteurs : TextView

        init {
            image = itemView.image
            nom = itemView.nom
            acteurs = itemView.acteurs
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Picasso.get().load(cardList[position].url).into(holder.image)
        holder.nom.text = cardList[position].nom
        holder.acteurs.text = cardList[position].acteurs

    }


}