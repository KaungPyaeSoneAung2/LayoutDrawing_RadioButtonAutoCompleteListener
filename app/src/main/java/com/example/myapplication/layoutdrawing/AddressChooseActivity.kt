package com.example.myapplication.layoutdrawing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.layoutdrawing.adapter.AddressListAdapter
import com.example.myapplication.layoutdrawing.databinding.OrderAddressConfirmBinding
import com.example.myapplication.layoutdrawing.models.ItemLayoutModel

class AddressChooseActivity : AppCompatActivity() {
    private lateinit var binding: OrderAddressConfirmBinding

    var tempData=ArrayList<ItemLayoutModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=OrderAddressConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataAddingIntoTempData()

        binding.rvListAddress.layoutManager=LinearLayoutManager(this@AddressChooseActivity)
        binding.rvListAddress.setHasFixedSize(true)
        binding.rvListAddress.adapter= AddressListAdapter(tempData)

        binding.cvBtnLayout.setOnClickListener{
            Intent(this,LoginActivity::class.java).also { startActivity(it) }
        }

    }

    private fun dataAddingIntoTempData() {
        tempData.add(
            ItemLayoutModel(
                "အိမ်",
                "Aung Pan",
                "No.478, Sample Ward, Sample Street.",
                "Near Pyin Thar Monastery"
            )
        )
        tempData.add(
            ItemLayoutModel(
                "အလုပ်",
                "Yangon,Kamayut",
                "No.848885, Bo Gyoke St, 60 Ward",
                "Near ABC Store"
            )
        )
        tempData.add(
            ItemLayoutModel(
                "အိမ်",
                "Mandalay, Chan Mya Thar Si",
                "No.799, 48x40 Block",
                "Near Zay Cho Entrance"
            )
        )
    }
}