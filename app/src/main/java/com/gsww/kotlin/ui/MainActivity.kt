package com.gsww.kotlin.ui

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.gsww.kotlin.R
import com.gsww.kotlin.adapter.KotlinRecycleAdapter
import com.gsww.kotlin.entity.TopObj
import com.gsww.kotlin.util.Constant
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.model.Response
import com.lzy.okgo.request.base.Request

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<TopObj.TopLine>? = null
    private var adapter1: KotlinRecycleAdapter? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        loadData()
    }

    //初始化布局
    fun initView() {
        val mRecyclerView = findViewById<RecyclerView>(R.id.rv_list)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        // layoutManager
        mRecyclerView.layoutManager = layoutManager

        // animation
        //mRecyclerView.itemAnimator = DefaultItemAnimator()

        list = ArrayList()
        // setAdapter
        adapter1 = KotlinRecycleAdapter(list, this)
        mRecyclerView.adapter = adapter1
        // itemClick
        adapter1?.setOnKotlinItemClickListener(object : KotlinRecycleAdapter.IKotlinItemClickListener {

            override fun onItemClickListener(position: Int) {
                var topline: TopObj.TopLine = list?.get(position)!!

            }
        })
    }

    //加载数据
    fun loadData() {
        OkGo.post<String>(Constant.YOULING_API)
            .params("uid", Constant.UID)
            .params("appkey", Constant.APP_KEY)
            .params("type", "0")
            .execute(object : StringCallback() {

                override fun onStart(request: Request<String, out Request<Any, Request<*, *>>>?) {
                    super.onStart(request)
                }

                override fun onFinish() {
                    super.onFinish()
                }

                override fun onSuccess(response: Response<String>) {
                    //注意这里已经是在主线程了
                    val data = response.body()//这个就是返回来的结果
                    var topObj: TopObj = TopObj.objectFromData(data);
                    if (topObj.code.equals("1000")) {//成功
                        Toast.makeText(baseContext, topObj.msg, Toast.LENGTH_SHORT).show();
                        list!!?.addAll(topObj.datas!!)
                        adapter1?.notifyDataSetChanged()
                    } else {

                        Toast.makeText(baseContext, topObj.msg, Toast.LENGTH_SHORT).show();
                    }

                }

                override fun onError(response: Response<String>) {
                    super.onError(response)
                }
            });
    }
}
