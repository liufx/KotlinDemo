package com.gsww.kotlin.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.gsww.kotlin.R
import com.gsww.kotlin.entity.UserObj
import com.gsww.kotlin.entity.UserObj.Companion.objectFromData
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.model.Response
import com.lzy.okgo.request.base.Request
import kotlinx.android.synthetic.main.activity_login.*

/**
 *
 * @package: com.gsww.kotlin.ui
 * @author: liufx
 * @date: 2018/12/9 11:35 AM
 * Copyright © 2018 中国电信甘肃万维公司. All rights reserved.
 * @description: 用户登录
 *
 */
class LoginActivity : AppCompatActivity() {

    val LOGIN_URL = "https://www.apiopen.top/login";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_login.setOnClickListener(View.OnClickListener { login() })
    }

    //登录设置
    fun login() {
        var account = et_account.text;
        var pwd = et_pwd.text;
        if (account.isEmpty()) {

            Toast.makeText(this, "账号不能为空！", Toast.LENGTH_SHORT).show();
            return
        }
        if (pwd.isEmpty()) {

            Toast.makeText(this, "账号不能为空！", Toast.LENGTH_SHORT).show();
            return
        }
        OkGo.post<String>(LOGIN_URL)
            .params("key", "00d91e8e0cca2b76f515926a36db68f5")
            .params("phone", "13594347817")//13594347817
            .params("passwd", pwd.toString())//123456
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
                    var userObj: UserObj = objectFromData(data);
                    if (userObj.code == 200) {//成功
                        Toast.makeText(baseContext, userObj.msg, Toast.LENGTH_SHORT).show();
                        var intent = Intent();
                        intent.setClass(baseContext, MainActivity().javaClass)
                        startActivity(intent)
                        finish()
                    } else {//登录失败

                        Toast.makeText(baseContext, userObj.msg, Toast.LENGTH_SHORT).show();
                    }

                }

                override fun onError(response: Response<String>) {
                    super.onError(response)
                }
            });
    }
}