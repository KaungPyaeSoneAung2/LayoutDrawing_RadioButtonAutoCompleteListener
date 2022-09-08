package com.example.myapplication.layoutdrawing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.layoutdrawing.models.PaymentSystemModel
import com.example.myapplication.layoutdrawing.databinding.LayoutPaymentItemsBinding

//, val recyclerClickInterface: RecyclerClickInterface
class PaymentSystemAdapter( val paymentLayout:List<PaymentSystemModel>)
    :RecyclerView.Adapter<PaymentSystemAdapter.ListHolder>() {
    private var selectedItem=-1

    inner class ListHolder(private val binding: LayoutPaymentItemsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(paymentLayout: PaymentSystemModel){
            binding.ivIcon.setImageResource(paymentLayout.img)
            binding.tvText.text= paymentLayout.name

//            itemView.setOnClickListener(View.OnClickListener())
//            {
//                recyclerClickInterface.onItemClick(adapterPosition)
//            }

//            binding.cvCheckedOrNot.setOnClickListener{
//                if(binding.cvCheckedOrNot.isVisible){
//                    selectedItem=View.VISIBLE
//                    selectedItem=adapterPosition
//                    notifyDataSetChanged()
//                }
//            }
//            binding.root.setOnClickListener{
//                if(!binding.cvCheckedOrNot.isVisible){
//                    selectedItem=View.VISIBLE
//                    selectedItem=adapterPosition
//                    notifyDataSetChanged()
//                }
//            }
//            binding.cvCheckedOrNot.isVisible=selectedItem==adapterPosition
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return (ListHolder(LayoutPaymentItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)))
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(paymentLayout[position])
//        holder.itemView.setOnClickListener {
//            holder.itemView.findViewById<ImageView>(R.id.ivCheckedOrNot)
//        }
    }

    override fun getItemCount(): Int {
        return paymentLayout.size
    }

}