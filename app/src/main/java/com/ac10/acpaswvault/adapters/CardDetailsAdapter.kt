package com.ac10.acpaswvault.adapters

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ac10.acpaswvault.R
import com.ac10.acpaswvault.databinding.DebitCardItemBinding
import com.ac10.acpaswvault.model.CardDetailsItem
import com.wajahatkarim3.easyflipview.EasyFlipView
import java.util.Locale

class CardDetailsAdapter(
    private var context: Context?,
    private var list:List<CardDetailsItem>
): RecyclerView.Adapter<CardDetailsAdapter.CardDetailsViewHolder>() {
    private lateinit var binding: DebitCardItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CardDetailsViewHolder {
        binding = DebitCardItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CardDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder:CardDetailsViewHolder, position:Int) {
        binding.cardHolder.text = list[position].cardHolder
        setItemIcon(
            binding.cardIssuer,
            list[position].cardIssuer,
            binding.debitCardItemCardFront,
            binding.debitCardItemCardBack,
            binding.backRelativeLayout,
            binding.frontRelativeLayout)
        binding.cardExpiry.text = list[position].cardExpiryMonth +"/"+ list[position].cardExpiryYear

        val splitNumber = list[position].cardNumber.toString().split("-")

        binding.cardNumberPart1.text = splitNumber[0]
        binding.cardNumberPart2.text = splitNumber[1]
        binding.cardNumberPart3.text = splitNumber[2]
        binding.cardNumberPart4.text = splitNumber[3]

        binding.debitCardCVV.text = list[position].cardCVV

        binding.flipView.setOnClickListener{
            it as EasyFlipView
            it.flipTheView()
        }

        binding.flipView.setOnLongClickListener{
            it as EasyFlipView

            var clipboardManager: ClipboardManager = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            if (clipboardManager.hasPrimaryClip()) {
                var number = list[position].cardNumber
                number = number.replace(Regex("""[-]"""), "")
                var data: ClipData = ClipData.newPlainText("copied Text", number)
                clipboardManager.setPrimaryClip(data)
            }
            Toast.makeText(context,"Copied to ClipBoard", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true

        }

    }

    private fun setItemIcon(itemIcon: ImageView, name:String, front: CardView, back:CardView, backLayout: RelativeLayout, frontLayout: RelativeLayout){
        when(name.toLowerCase(Locale.ROOT).trim()) {

            "master card" -> {
                itemIcon.setImageResource(R.drawable.ic_mc_symbol)
            }

            "visa" -> {
                itemIcon.setImageResource(R.drawable.ic_visa)
                front.setCardBackgroundColor(android.graphics.Color.parseColor("#5494F1"))
                back.setCardBackgroundColor(android.graphics.Color.parseColor("#5494F1"))
                frontLayout.setBackgroundColor(android.graphics.Color.parseColor("#5494F1"))
                backLayout.setBackgroundColor(android.graphics.Color.parseColor("#5494F1"))
            }

            "rupay" -> itemIcon.setImageResource(R.drawable.ic_mastercard)

            "maestro" -> {
                itemIcon.setImageResource(R.drawable.ic_mastercard)
                front.setCardBackgroundColor(android.graphics.Color.parseColor("#ED6033"))
                back.setCardBackgroundColor(android.graphics.Color.parseColor("#ED6033"))
                frontLayout.setBackgroundColor(android.graphics.Color.parseColor("#ED6033"))
                backLayout.setBackgroundColor(android.graphics.Color.parseColor("#ED6033"))
            }
        }
    }



    class CardDetailsViewHolder(binding:DebitCardItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    fun getItemAt(position: Int): CardDetailsItem {
        return list[position]
    }

}