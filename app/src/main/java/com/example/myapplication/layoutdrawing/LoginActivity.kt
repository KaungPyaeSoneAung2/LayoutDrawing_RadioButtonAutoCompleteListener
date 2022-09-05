package com.example.myapplication.layoutdrawing

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.myapplication.layoutdrawing.databinding.LoginLayoutBinding

class LoginActivity: AppCompatActivity() {
    private lateinit var binding: LoginLayoutBinding
    var userList=ArrayList<UserNameItems>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= LoginLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userList.add(UserNameItems("Kyaw Kyaw",R.drawable.one,"09123456789"))
        userList.add(UserNameItems("Naing Kyaw",R.drawable.two,"09123456789"))
        userList.add(UserNameItems("Soe Kyaw",R.drawable.three,"09123456789"))
        userList.add(UserNameItems("Moe Kyaw",R.drawable.one,"09123456789"))

        val mAdapter = NameAutoFillAdapter(this,R.layout.layout_name_auto_fill,userList)
        binding.tvBuyerName.setAdapter(mAdapter)

        binding.ibAddedCustomer.setOnClickListener{
            Intent(this,PaymentSystemTypesActivity::class.java).also{startActivity(it)}
        }

        }
    }