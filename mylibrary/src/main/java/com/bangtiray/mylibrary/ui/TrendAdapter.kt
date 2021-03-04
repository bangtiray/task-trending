package com.bangtiray.mylibrary.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangtiray.mylibrary.data.source.remote.response.ResponseDto
import com.bangtiray.mylibrary.databinding.ItemTrendViewBinding
import com.bumptech.glide.Glide

class TrendAdapter : RecyclerView.Adapter<TrendAdapter.VH>() {
    private val listResponse = ArrayList<ResponseDto>()

    fun setData(list: List<ResponseDto>?) {
        if (list == null) return
        listResponse.clear()
        listResponse.addAll(list)
        notifyDataSetChanged()
    }

    var onItemClick: ((ResponseDto) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemTrendViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = listResponse.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(listResponse[position])
    }

    inner class VH(private val binding: ItemTrendViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(rDto: ResponseDto) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(rDto.avatar)
                    .into(imgItemPhoto)
                tvItemName.text = rDto.name
                tvLanguage.text = rDto.language
                tvLanguage.setTextColor(Color.parseColor(rDto.languageColor))
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listResponse[adapterPosition])
            }
        }
    }
}