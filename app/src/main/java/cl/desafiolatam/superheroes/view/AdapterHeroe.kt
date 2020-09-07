package cl.desafiolatam.superheroes.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.superheroes.R
import cl.desafiolatam.superheroes.model.api.HeroeListMini
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.heroe_list.view.*

class AdapterHeroe (private var heroeDataset : MutableList<HeroeListMini>) :RecyclerView.Adapter<AdapterHeroe.HeroeViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.heroe_list,parent,false)
        return HeroeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return heroeDataset.size
    }

    val heroeSelected = MutableLiveData<HeroeListMini>()

    override fun onBindViewHolder(holder: HeroeViewHolder, position: Int) {
        holder.textname.text = heroeDataset.get(position).name
        holder.textid.text = heroeDataset.get(position).id.toString()
        Picasso.get().load(heroeDataset.get(position).images_md).into(holder.textView)

        //funcion del click
        holder.itemView.setOnClickListener{
            Log.d("viewholder", "${heroeDataset.get(position)}")
            heroeSelected.value = heroeDataset.get(position)
        }
    }



    class HeroeViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        val textid = itemView.textViewId
        val textname = itemView.textViewName
        val textView = itemView.imageViewImages

    }

    fun updateItems (it: List<HeroeListMini>) {
        heroeDataset.clear()
        heroeDataset.addAll(it)
        notifyDataSetChanged()
    }
}