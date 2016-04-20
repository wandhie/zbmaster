package com.ohdroid.zbmaster.application.data;

import com.ohdroid.zbmaster.facesync.data.FaceSyncManager;
import com.ohdroid.zbmaster.login.data.LoginManager;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ohdroid on 2016/3/14.
 * <p>
 * 所有数据总管家
 */
@Singleton
public class DataManager {
    private LoginManager loginManager;
    private FaceSyncManager faceSyncManager;

    @Inject
    public DataManager(LoginManager loginManager, FaceSyncManager faceSyncManager) {
        this.loginManager = loginManager;
        this.faceSyncManager = faceSyncManager;

        System.out.println("===========data manager init==================");
    }

    public LoginManager getLoginManger() {
        return this.loginManager;
    }

    public FaceSyncManager getFaceSyncManager() {
        return this.faceSyncManager;

    }
}
