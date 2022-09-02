package com.example.myapplication.layoutdrawing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.layoutdrawing.databinding.OrderAddressItemsBinding

class AddressListAdapter(val itermLayout: List<itemLayoutModel>)
    :RecyclerView.Adapter<AddressListAdapter.AddressHolder>() {
    private var selectedItem=-1

inner class AddressHolder(private val binding: OrderAddressItemsBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(itermLayout: itemLayoutModel){

        binding.tvAddressType.text=itermLayout.addressType
        binding.tvCity.text=itermLayout.city
        binding.tvNear.text=itermLayout.near
        binding.tvAdressDetail.text=itermLayout.addresss

        binding.rbTop.setOnClickListener{
            if(binding.rbTop.isChecked){
                selectedItem=adapterPosition
                notifyDataSetChanged()
            }
        }
        binding.root.setOnClickListener{
            if(!binding.rbTop.isChecked){
                selectedItem=adapterPosition
                notifyDataSetChanged()
            }
        }
        binding.rbTop.isChecked=selectedItem==adapterPosition
    }

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressHolder {
        return (AddressHolder(OrderAddressItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)))
    }

    override fun onBindViewHolder(holder: AddressListAdapter.AddressHolder, position: Int) {

        holder.bind(itermLayout[position])
        }

    override fun getItemCount(): Int {
        return itermLayout.size
    }
}