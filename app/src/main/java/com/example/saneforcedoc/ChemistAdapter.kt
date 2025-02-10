package com.example.saneforcedoc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saneforcedoc.databinding.ChemistItemBinding
import com.example.saneforcedoc.repo.Chemist

class ChemistAdapter (val clickListener: ItemClickListener, var productList: List<Chemist>?)
    : RecyclerView.Adapter<ChemistAdapter.UniversityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        return UniversityViewHolder(
            ChemistItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false))
    }

    override fun getItemCount(): Int {

        if (productList == null)
            return 0
        return productList!!.size

    }


    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val name = productList?.get(position)
        if (name != null) {
            holder.bindData(name)
        }

    }


    inner class UniversityViewHolder(val binding: ChemistItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(d: Chemist?){
            binding.apply {
                doctor = d
                root.setOnClickListener{
                    clickListener.onItemClick(d!!)
                }
            }
        }

    }
    public interface ItemClickListener{
        public fun onItemClick(p: Chemist)
    }
}