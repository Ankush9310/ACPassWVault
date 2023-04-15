package com.ac10.acpaswvault.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.ac10.acpaswvault.databinding.BankListItemBinding
import com.ac10.acpaswvault.model.BankDetailsItem
import com.ac10.acpaswvault.ui.dialog.BankDialog

class BankDetailsAdapter(
    private var context: Context?,
    private var list: List<BankDetailsItem>,
    private var fragmentManager: FragmentManager
): RecyclerView.Adapter<BankDetailsAdapter.BankDetailsViewHolder>() {

    private lateinit var binding: BankListItemBinding

    class BankDetailsViewHolder(bindings: BankListItemBinding):RecyclerView.ViewHolder(bindings.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankDetailsViewHolder {
        binding = BankListItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return BankDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BankDetailsViewHolder, position: Int) {
        binding.bankName.text = list.get(position).bankName
        binding.bankAccountNumber.text = list[position].bankAccNumber.toString()
        binding.bankItemCard.setOnClickListener{
            val dialog = BankDialog(list[position])
            dialog.show(fragmentManager, "Bank Dialog")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getItemAt (position: Int):BankDetailsItem{
        return list[position]
    }

}