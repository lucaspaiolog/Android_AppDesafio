package br.edu.fatecpg.appdesafio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.appdesafio.model.Item
import br.edu.fatecpg.appdesafio.R
import com.squareup.picasso.Picasso

class ItemAdapter(private val itens: MutableList<Item>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgItem: ImageView = itemView.findViewById(R.id.img_item)
        val txtNome: TextView = itemView.findViewById(R.id.txt_nome)
    val txtValor: TextView = itemView.findViewById(R.id.txt_valor)
        val btnExcluir: Button = itemView.findViewById(R.id.btn_excluir)
        val btnEditar: Button = itemView.findViewById(R.id.btn_editar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itens[position]

        holder.txtNome.text = item.nome
        holder.txtValor.text = item.valor
        Picasso.get().load(item.imagemUrl).into(holder.imgItem)

        holder.btnExcluir.setOnClickListener {
            itens.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itens.size)
        }

        // botão editar não precisa funcionar ainda
        holder.btnEditar.setOnClickListener { }
    }

    override fun getItemCount() = itens.size
}