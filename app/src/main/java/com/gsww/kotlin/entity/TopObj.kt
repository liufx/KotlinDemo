package com.gsww.kotlin.entity

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

import java.io.Serializable

/**
 * @package: com.gsww.kotlin.entity
 * @author: liufx
 * @date: 2018/12/9 7:55 PM
 * Copyright © 2018 中国电信甘肃万维公司. All rights reserved.
 * @description: 幽灵头条
 */
class TopObj : Serializable {

    /**
     * code : 1000
     * msg : success
     * datas : [{"uniquekey":"051289c807a37021384e5c6a7100b52c","title":"厦门西先生西服定制\u2014\u2014不甘平庸，所以注定不凡","date":"2018-08-21 14:43","author_name":"福建西先生","thumbnail_pic_s":"http://09imgmini.eastday.com/mobile/20180821/20180821144345_6bdc300bd6f151daa9e0f6325a6b361c_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09imgmini.eastday.com/mobile/20180821/20180821144345_6bdc300bd6f151daa9e0f6325a6b361c_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09imgmini.eastday.com/mobile/20180821/20180821144345_6bdc300bd6f151daa9e0f6325a6b361c_1_mwpm_03200403.jpg","url":"http://mini.eastday.com/mobile/180821144345643.html","category":"头条"},{"uniquekey":"4ec984d00f1e3a0d3d5e58d31b5caeec","title":"关于开内眼角的这些事","date":"2018-08-21 14:44","author_name":"哈尔滨欧兰仁美","thumbnail_pic_s":"http://00imgmini.eastday.com/mobile/20180821/20180821144418_73377160d6242c202cc9f02ccff43d66_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00imgmini.eastday.com/mobile/20180821/20180821144418_73377160d6242c202cc9f02ccff43d66_6_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00imgmini.eastday.com/mobile/20180821/20180821144418_73377160d6242c202cc9f02ccff43d66_4_mwpm_03200403.jpg","url":"http://mini.eastday.com/mobile/180821144418079.html","category":"头条"},{"uniquekey":"081f53c3280612134893d63bdbead018","title":"拍照，这8个小技巧能让你的照片提升10个等级","date":"2018-08-21 14:56","author_name":"合肥婚纱摄影","thumbnail_pic_s":"http://01imgmini.eastday.com/mobile/20180821/20180821145638_0fbbff3b17a71a699253a6d92cd8b151_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01imgmini.eastday.com/mobile/20180821/20180821145638_0fbbff3b17a71a699253a6d92cd8b151_1_mwpm_03200403.jpg","thumbnail_pic_s03":null,"url":"http://mini.eastday.com/mobile/180821145638517.html","category":"头条"}]
     */

    var code: String? = null
    var msg: String? = null
    var datas: List<TopLine>? = null

    class TopLine {
        /**
         * uniquekey : 051289c807a37021384e5c6a7100b52c
         * title : 厦门西先生西服定制——不甘平庸，所以注定不凡
         * date : 2018-08-21 14:43
         * author_name : 福建西先生
         * thumbnail_pic_s : http://09imgmini.eastday.com/mobile/20180821/20180821144345_6bdc300bd6f151daa9e0f6325a6b361c_2_mwpm_03200403.jpg
         * thumbnail_pic_s02 : http://09imgmini.eastday.com/mobile/20180821/20180821144345_6bdc300bd6f151daa9e0f6325a6b361c_3_mwpm_03200403.jpg
         * thumbnail_pic_s03 : http://09imgmini.eastday.com/mobile/20180821/20180821144345_6bdc300bd6f151daa9e0f6325a6b361c_1_mwpm_03200403.jpg
         * url : http://mini.eastday.com/mobile/180821144345643.html
         * category : 头条
         */

        var uniquekey: String? = null
        var title: String? = null
        var date: String? = null
        @SerializedName("author_name")
        var authorName: String? = null
        @SerializedName("thumbnail_pic_s")
        var thumbnailPicS: String? = null
        @SerializedName("thumbnail_pic_s02")
        var thumbnailPicS02: String? = null
        @SerializedName("thumbnail_pic_s03")
        var thumbnailPicS03: String? = null
        var url: String? = null
        var category: String? = null

        companion object {

            fun objectFromData(str: String): TopLine {

                return Gson().fromJson(str, TopLine::class.java)
            }
        }
    }

    companion object {

        fun objectFromData(str: String): TopObj {

            return Gson().fromJson(str, TopObj::class.java)
        }
    }
}
