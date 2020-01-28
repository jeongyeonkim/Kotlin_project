package com.example.d.kotlin_todolist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainAdapter(context: Context, item: ArrayList<String>) : BaseAdapter(){
    private val mContext = context
    private val mItem = item

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        lateinit var viewHolder : ViewHolder
        var view = convertView

        if (view == null){
            viewHolder = ViewHolder()
            view = LayoutInflater.from(mContext).inflate(R.layout.list_todo,parent,false)
            viewHolder.textView = view.findViewById(R.id.text_todo)
            viewHolder.Button = view.findViewById(R.id.btn_delete)
            view.tag = viewHolder
            viewHolder.textView.text = mItem[position]
            viewHolder.Button.setOnClickListener {
                mItem.removeAt(position)
                notifyDataSetChanged()
            }

            viewHolder.textView.setOnClickListener {
                val intent = Intent(mContext, ModifyActivity::class.java)
                intent.putExtra("todoText",viewHolder.textView.text.toString())
                mContext.startActivity(intent)
            }

            return view
        }else{
            viewHolder = view.tag as ViewHolder
        }
        viewHolder.textView.text = mItem[position]
        return  view
    }

    override fun getItem(position: Int) = mItem[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = mItem.size

    inner class ViewHolder{
        lateinit var textView : TextView
        lateinit var Button : Button
        var checkBox : CheckBox? = null

    }

}

