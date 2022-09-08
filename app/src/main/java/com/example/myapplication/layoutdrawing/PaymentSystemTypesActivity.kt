package com.example.myapplication.layoutdrawing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.layoutdrawing.adapter.PaymentSystemAdapter
import com.example.myapplication.layoutdrawing.databinding.ActivityPaymentSystemTypesBinding
import com.example.myapplication.layoutdrawing.models.PaymentSystemModel

class PaymentSystemTypesActivity : AppCompatActivity(), RecyclerClickInterface {
    var defaultList=ArrayList<PaymentSystemModel>()
    var bankList=ArrayList<PaymentSystemModel>()
    var digitalList=ArrayList<PaymentSystemModel>()
    var cardList=ArrayList<PaymentSystemModel>()
    private lateinit var binding: ActivityPaymentSystemTypesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPaymentSystemTypesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
////////////////////////////////////////////
        listReveal()
        defualtListAdd()
        bankListAdd()
        digitalAdd()
        cardAdd()
        setUpAdapter()
    }

    private fun setUpAdapter() {

        binding.rvDefaultPayment.layoutManager=LinearLayoutManager(this)
        binding.rvDefaultPayment.setHasFixedSize(true)

        val defaultPayment = PaymentSystemAdapter(defaultList)
        binding.rvDefaultPayment.adapter = defaultPayment

        binding.rvBanks.layoutManager=LinearLayoutManager(this)
        binding.rvBanks.setHasFixedSize(true)
        val bankPayment = PaymentSystemAdapter(bankList)
        binding.rvBanks.adapter=bankPayment

        binding.rvDigitalMoney.layoutManager=LinearLayoutManager(this)
        binding.rvDigitalMoney.setHasFixedSize(true)
        val digitalPayment = PaymentSystemAdapter(digitalList)
        binding.rvDigitalMoney.adapter=digitalPayment

        binding.rvCards.layoutManager=LinearLayoutManager(this)
        binding.rvCards.setHasFixedSize(true)
        val cardPayment= PaymentSystemAdapter(cardList)
        binding.rvCards.adapter=cardPayment

    }

    fun defualtListAdd(){
        defaultList.add(PaymentSystemModel(R.drawable.dollar_sign,"ငွေသား"))
        defaultList.add(PaymentSystemModel(R.drawable.bicycle_logo,"အိမ်အရောက်ငွေချေစနစ်"))
    }

    fun bankListAdd(){
        bankList.add(PaymentSystemModel(R.drawable.kbz_logo,"KBZBank"))
        bankList.add(PaymentSystemModel(R.drawable.aya_logo,"AYABank"))
        bankList.add(PaymentSystemModel(R.drawable.three,"CBBank"))
        bankList.add(PaymentSystemModel(R.drawable.yoma_logo,"Yoma Bank"))
        bankList.add(PaymentSystemModel(R.drawable.three,"A Bank"))
        bankList.add(PaymentSystemModel(R.drawable.three,"Sample Bank"))
    }

    fun digitalAdd(){
        digitalList.add(PaymentSystemModel(R.drawable.kbz_logo,"KBZPay"))
        digitalList.add(PaymentSystemModel(R.drawable.aya_logo,"AYAPay"))
        digitalList.add(PaymentSystemModel(R.drawable.onepay_logo,"OnePay"))
        digitalList.add(PaymentSystemModel(R.drawable.wavepay_logo,"WavePay"))
        digitalList.add(PaymentSystemModel(R.drawable.three,"SaiSaiPay"))
    }

    fun cardAdd(){
        cardList.add(PaymentSystemModel(R.drawable.jcb_logo,"JCB"))
        cardList.add(PaymentSystemModel(R.drawable.unionpay_logo,"UnionPay"))
        cardList.add(PaymentSystemModel(R.drawable.mastercard_logo,"MasterCard"))
        cardList.add(PaymentSystemModel(R.drawable.visa_logo,"Visa"))
    }

    fun listReveal(){

        binding.llBanks.setOnClickListener{
            if(binding.rvBanks.visibility==View.GONE)
            {
                binding.rvBanks.visibility= View.VISIBLE
                binding.ivBankArrow.setImageResource(R.drawable.ic_arrow_up_24)
            }
            else if(binding.rvBanks.visibility==View.VISIBLE)
            {
                binding.rvBanks.visibility= View.GONE
                binding.ivBankArrow.setImageResource(R.drawable.ic_arrow_down_24)
            }
        }

        binding.llDigitalMoney.setOnClickListener{
            if(binding.rvDigitalMoney.visibility==View.GONE)
            {
                binding.rvDigitalMoney.visibility= View.VISIBLE
                binding.ivDigitalArrow.setImageResource(R.drawable.ic_arrow_up_24)
            }
            else if(binding.rvDigitalMoney.visibility==View.VISIBLE)
            {
                binding.rvDigitalMoney.visibility= View.GONE
                binding.ivDigitalArrow.setImageResource(R.drawable.ic_arrow_down_24)
            }
        }

        binding.llCards.setOnClickListener{
            if(binding.rvCards.visibility==View.GONE)
            {
                binding.rvCards.visibility= View.VISIBLE
                binding.ivCardArrow.setImageResource(R.drawable.ic_arrow_up_24)
            }
            else if(binding.rvCards.visibility==View.VISIBLE)
            {
                binding.rvCards.visibility= View.GONE
                binding.ivCardArrow.setImageResource(R.drawable.ic_arrow_down_24)
            }
        }
    }

    override fun onItemClick(position: Int) {
        TODO("Not yet implemented")
    }
}