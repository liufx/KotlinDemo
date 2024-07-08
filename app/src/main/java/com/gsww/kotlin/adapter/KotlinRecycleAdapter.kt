package com.gsww.kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.gsww.kotlin.R
import com.gsww.kotlin.entity.TopObj

/**
 *
 * @package: com.gsww.kotlin.adapter
 * @author: liufx
 * @date: 2018/12/9 8:33 PM
 * @description: 列表适配器
 *
 */
class KotlinRecycleAdapter : RecyclerView.Adapter<KotlinRecycleAdapter.MyViewHolder> {
    private var list: ArrayList<TopObj.TopLine>? = null
    private var context: Context? = null

    private var itemClickListener: IKotlinItemClickListener? = null

    constructor(list: ArrayList<TopObj.TopLine>?, context: Context?) : super() {
        this.list = list
        this.context = context
    }


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_topline, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var t: TopObj.TopLine = list?.get(position)!!
        holder.tvTitle.text = t.title
        holder.tvAuthor.text = t.authorName
        holder.tvTime.text = t.date
        Glide.with(context!!).load(t.thumbnailPicS).into(holder.imageView)
        // 点击事件
        holder.itemView.setOnClickListener {
            itemClickListener!!.onItemClickListener(position)
        }
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        //"?"加在变量名后，系统在任何情况不会报它的空指针异常。
        //"!!"加在变量名后，如果对象为null，那么系统一定会报异常！
        var tvTitle: TextView = itemView!!.findViewById(R.id.tv_title)
        var tvAuthor: TextView = itemView!!.findViewById(R.id.tv_author)
        var tvTime: TextView = itemView!!.findViewById(R.id.tv_time)
        var imageView: ImageView = itemView!!.findViewById(R.id.iv_img)

    }

    // 提供set方法
    fun setOnKotlinItemClickListener(itemClickListener: IKotlinItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    //自定义接口
    interface IKotlinItemClickListener {
        fun onItemClickListener(position: Int)
    }
}
