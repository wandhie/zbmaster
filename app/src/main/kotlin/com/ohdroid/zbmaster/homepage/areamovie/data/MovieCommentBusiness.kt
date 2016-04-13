package com.ohdroid.zbmaster.homepage.areamovie.data

import android.content.Context
import cn.bmob.v3.listener.SaveListener
import com.ohdroid.zbmaster.application.data.BaseBusiness
import com.ohdroid.zbmaster.application.data.api.BmobDataManager
import com.ohdroid.zbmaster.homepage.areamovie.model.MovieComment

/**
 * Created by ohdroid on 2016/4/12.
 */
class MovieCommentBusiness : BaseBusiness<MovieComment>() {

    var context: Context? = null

    companion object {
        @JvmField val PAGE_LIMIT = 20
    }

    override fun byGet() {
    }

    override fun byPost() {
    }

    fun addComment(saveListener: SaveListener?, comment: MovieComment) {
        BmobDataManager.getInstance().addItem(context!!, comment, saveListener)
    }

}