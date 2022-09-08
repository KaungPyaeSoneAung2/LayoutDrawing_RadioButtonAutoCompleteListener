package com.example.myapplication.layoutdrawing

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.layoutdrawing.adapter.AutoCompleteTextViewAdapter
import com.example.myapplication.layoutdrawing.databinding.LoginLayoutBinding
import com.example.myapplication.layoutdrawing.models.UserNameModel

class LoginActivity: AppCompatActivity() {
    private lateinit var binding: LoginLayoutBinding
    var userList=ArrayList<UserNameModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= LoginLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userList.add(UserNameModel("Kyaw Kyaw",R.drawable.one,"09123456789"))
        userList.add(UserNameModel("Naing Kyaw",R.drawable.two,"09123456789"))
        userList.add(UserNameModel("Soe Kyaw",R.drawable.three,"09123456789"))
        userList.add(UserNameModel("Moe Kyaw",R.drawable.one,"09123456789"))

        val mAdapter = AutoCompleteTextViewAdapter(this,R.layout.layout_name_auto_fill,userList)
        binding.tvBuyerName.setAdapter(mAdapter)

        binding.ibAddedCustomer.setOnClickListener{
            Intent(this,PaymentSystemTypesActivity::class.java).also{startActivity(it)}
        }

        }
    }