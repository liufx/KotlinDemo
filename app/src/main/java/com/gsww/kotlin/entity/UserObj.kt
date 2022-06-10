package com.gsww.kotlin.entity

import java.io.Serializable

/**
 *
 * @package: com.gsww.kotlin.entity
 * @author: liufx
 * @date: 2018/12/9 2:35 PM
 * @description: 返回的对象
 */

class UserObj : Serializable {


    /**
     * code : 200
     * msg : 成功!
     * data : {"key":"00d91e8e0cca2b76f515926a36db68f5","phone":"13594347817","name":"peakchao","passwd":"123456","text":"这是我的签名。","img":"https://res.apiopen.top/2018031820405521.key.png","other":"这是我的备注信息1","other2":"这是我的备注信息2","createTime":"2018-03-18 20:40:55"}
     */

    var code: Int = 0
    var msg: String? = null
    var data: User? = null

    class User {
        /**
         * key : 00d91e8e0cca2b76f515926a36db68f5
         * phone : 13594347817
         * name : peakchao
         * passwd : 123456
         * text : 这是我的签名。
         * img : https://res.apiopen.top/2018031820405521.key.png
         * other : 这是我的备注信息1
         * other2 : 这是我的备注信息2
         * createTime : 2018-03-18 20:40:55
         */

        var key: String? = null
        var phone: String? = null
        var name: String? = null
        var passwd: String? = null
        var text: String? = null
        var img: String? = null
        var other: String? = null
        var other2: String? = null
        var createTime: String? = null

        companion object {

            fun objectFromData(str: String): User {

                return com.google.gson.Gson().fromJson(str, User::class.java)
            }
        }
    }

    companion object {

        fun objectFromData(str: String): UserObj {

            return com.google.gson.Gson().fromJson(str, UserObj::class.java)
        }
    }
}
