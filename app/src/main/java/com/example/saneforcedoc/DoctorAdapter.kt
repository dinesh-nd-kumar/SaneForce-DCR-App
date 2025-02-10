package com.example.saneforcedoc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saneforcedoc.databinding.DoctorItemBinding
import com.example.saneforcedoc.repo.Doctor

class DoctorAdapter(val clickListener: ItemClickListener, var productList: List<Doctor>?)
    : RecyclerView.Adapter<DoctorAdapter.UniversityViewHolder>() {
//        private var key : List<String> = productList?.products?.keys!!.map { it }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        return UniversityViewHolder(
            DoctorItemBinding.inflate(
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


    inner class UniversityViewHolder(val binding:DoctorItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(d: Doctor?){
            binding.apply {
              doctor = d
                root.setOnClickListener{
                    clickListener.onItemClick(d!!)
                }
            }
        }

    }
    public interface ItemClickListener{
        public fun onItemClick(p: Doctor)
    }
}