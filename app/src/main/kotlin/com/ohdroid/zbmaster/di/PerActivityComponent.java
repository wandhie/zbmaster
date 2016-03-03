package com.ohdroid.zbmaster.di;

import android.app.Activity;

import com.ohdroid.zbmaster.di.exannotation.PerActivity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import dagger.Component;

/**
 * Created by ohdroid on 2016/2/27.
 * activity scope 服务 所以生命周期应该与activity同步
 */
@PerActivity
@Component(dependencies = AppModule.class, modules = PerActivityModule.class)
public interface PerActivityComponent {

    //暴露以供使用
    @PerActivity
    Activity activity();
}
