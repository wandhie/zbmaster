package com.ohdroid.zbmaster.login.di

import android.content.Context
import com.ohdroid.zbmaster.di.exannotation.PerActivity
import com.ohdroid.zbmaster.login.presenter.LoginPresenter
import com.ohdroid.zbmaster.login.presenter.imp.LoginPresenterImp
import dagger.Module
import dagger.Provides

/**
 * Created by ohdroid on 2016/2/28.
 */
@Module
class LoginActivityModule {

    @Provides
    @PerActivity
    fun provideLoginPresenter(context: Context): LoginPresenter {
        return LoginPresenterImp(context)
    }
}