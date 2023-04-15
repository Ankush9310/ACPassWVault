package com.ac10.acpaswvault.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ac10.acpaswvault.R
import com.ac10.acpaswvault.databinding.LoginListItemBinding
import com.ac10.acpaswvault.model.LoginDetailsItem
import com.ac10.acpaswvault.ui.dialog.LoginDialog
import java.util.Locale

class LoginDetailsAdapter(
    private var context: Context?,
    private var list: MutableList<LoginDetailsItem>,
    private var fragmentManager: FragmentManager
):RecyclerView.Adapter<LoginDetailsAdapter.LoginDetailsViewHolder>() {

    private lateinit var binding:LoginListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):LoginDetailsViewHolder {
        binding = LoginListItemBinding.inflate(
            LayoutInflater.from(context),parent,false
        )
        return LoginDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LoginDetailsViewHolder, position: Int) {

//        binding.itemTitle.text =list[position].loginName
//        binding.itemid.text = list[position].loginEmail
//        setItemIcon(binding.itemIcon,list[position].loginName)
//        binding.loginItemCard.setOnClickListener {
//            val dialog = LoginDialog(list[position])
//            dialog.show(fragmentManager,"Login Dialog")
//        }


        holder.bindItem(list[position], fragmentManager)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(updatedList: MutableList<LoginDetailsItem>){
        val callback = CustomCallback(list,updatedList)
        val result = DiffUtil.calculateDiff(callback)

        list.clear()
        list.addAll(updatedList)
        result.dispatchUpdatesTo(this)
    }

    fun itemDeleted(loginItem:LoginDetailsItem){
        val newList:ArrayList<LoginDetailsItem> = ArrayList()
        newList.addAll(list)
        newList.toMutableList()
        list.remove(loginItem)

        val callback = CustomCallback(newList, list)
        val result = DiffUtil.calculateDiff(callback)
        result.dispatchUpdatesTo(this)
    }

    fun getItemAt(position : Int) : LoginDetailsItem{
        return list[position]
    }

    class LoginDetailsViewHolder(
        private val binding: LoginListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItem(loginItem : LoginDetailsItem, fragmentManager: FragmentManager){
            binding.itemTitle.text = loginItem.loginName
            binding.itemid.text = loginItem.loginEmail
            setItemIcon(binding.itemIcon,loginItem.loginName)
            binding.loginItemCard.setOnClickListener {
                val dialog = LoginDialog(loginItem)
                dialog.show(fragmentManager,"Login Dialog")
            }
        }

        private fun setItemIcon(itemIcon: ImageView, name : String) {
            when(name.lowercase(Locale.ROOT).trim()){
                "google" -> itemIcon.setImageResource(R.drawable.gmail)
                "github" -> itemIcon.setImageResource(R.drawable.github)
                "slack" -> itemIcon.setImageResource(R.drawable.slack)
                "amazon" -> itemIcon.setImageResource(R.drawable.amazon)
                "flipkart" -> itemIcon.setImageResource(R.drawable.flipkart)
                "facebook" -> itemIcon.setImageResource(R.drawable.facebook)
                "instagram" -> itemIcon.setImageResource(R.drawable.instagram)
                "reddit" -> itemIcon.setImageResource(R.drawable.reddit)
                "pinterest" -> itemIcon.setImageResource(R.drawable.pinterest)
                "linkedin" -> itemIcon.setImageResource(R.drawable.linkedin)
                "spotify" -> itemIcon.setImageResource(R.drawable.spotify)
                "dribble" -> itemIcon.setImageResource(R.drawable.dribble)
                "teamviewer" -> itemIcon.setImageResource(R.drawable.team)
            }
        }
    }

    class CustomCallback(
        private val oldList: MutableList<LoginDetailsItem>,
        private val newList: MutableList<LoginDetailsItem>) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItemPosition == newItemPosition
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }



}