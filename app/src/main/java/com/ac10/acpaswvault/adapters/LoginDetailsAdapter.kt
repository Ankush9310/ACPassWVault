package com.ac10.acpaswvault.adapters

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ac10.acpaswvault.model.LoginDetailsItem

class LoginDetailsAdapter(
    private var context: Context?,
    private var list: MutableList<LoginDetailsItem>,
    private var fragmentManager: FragmentManager
):RecyclerView.Adapter<LoginDetailsItem.LoginDetailsViewHolder>() {

}