package com.example.myapplication.layoutdrawing

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class NameAutoFillAdapter(
    val mContext:Context,
    val mlayoutResourceId:Int,
    private val userLiser: ArrayList<UserNameItems>) : ArrayAdapter<UserNameItems>(mContext,mlayoutResourceId,userLiser){

    private val userList = ArrayList<UserNameItems>(userLiser)
    override fun getFilter(): Filter {
        return filterResult
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertTemp=convertView
        if (convertTemp ==null){
            convertTemp=LayoutInflater.from(mContext).inflate(
                mlayoutResourceId,parent,false
            )
        }
        var tvUserName =convertTemp?.findViewById<TextView>(R.id.tvUserName)
        var tvPhoneNum = convertTemp?.findViewById<TextView>(R.id.tvUserPhone)
        var ivImage = convertTemp?.findViewById<ImageView>(R.id.ivImage)
        var userLiser = getItem(position)!!


        tvUserName?.text = userLiser.userName
        tvPhoneNum?.text = userLiser.userPh
        ivImage?.setImageResource(userLiser.userImage)

        return convertTemp!!
    }



    val filterResult = object : Filter(){
        override fun performFiltering(p0: CharSequence?): FilterResults {
            val result=FilterResults()
            val suggestions=ArrayList<UserNameItems>()

            if(p0.isNullOrEmpty()){
                suggestions.addAll(userList)
                Log.d("Called once","Called Once Onnce")
            }
            else{
                val stringPattern:String= p0.toString().lowercase().trim()
                for(item in userList){
                    if (item.userName.lowercase().contains(stringPattern)){
                        suggestions.add(item)
                        }
                }

            }
            result.count=suggestions.size
            result.values=suggestions
            Log.d("Sleepy2","Her is ${result.values}")
            return result
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            userLiser.clear()
            userLiser.addAll(p1?.values as List<UserNameItems>)
            notifyDataSetChanged()
            Log.d("Sleepy","Her is ${p1.values.toString()}")

        }

        override fun convertResultToString(resultValue: Any?): CharSequence {
            val temp =resultValue as UserNameItems
            Log.d("Sleepy1","Her is $temp")
            return temp.userName

        }
    }

}