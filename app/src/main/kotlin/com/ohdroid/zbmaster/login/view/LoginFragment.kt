package com.ohdroid.zbmaster.login.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.ohdroid.zbmaster.R
import com.ohdroid.zbmaster.application.ex.showToast
import com.ohdroid.zbmaster.base.view.BaseFragment
import com.ohdroid.zbmaster.login.model.AccountInfo
import com.ohdroid.zbmaster.login.presenter.LoginPresenter
import com.rengwuxian.materialedittext.MaterialEditText
import org.jetbrains.anko.support.v4.find

/**
 * Created by ohdroid on 2016/3/5.
 */
class LoginFragment : BaseFragment(), LoginView, View.OnClickListener {


    val loginBtn: Button by lazy {
        find<Button>(R.id.btn_login)
    }
    val registerBtn: TextView by lazy {
        find<TextView>(R.id.btn_register)
    }
    val userName: MaterialEditText by lazy { find<MaterialEditText>(R.id.et_name) }
    val userPassword: MaterialEditText  by lazy { find<MaterialEditText>(R.id.et_password) }

    lateinit var loginPresenter: LoginPresenter;

    companion object {
        @JvmField val TAG: String = "LoginFragment"

        @JvmStatic fun launch(manager: FragmentManager, containerId: Int) {
            var fragment: Fragment? = null
            if (null == manager.findFragmentByTag(LoginFragment.TAG)) {
                fragment = LoginFragment()
                manager.beginTransaction()
                        .add(containerId, fragment)
                        .commit()
            } else {
                fragment = manager.findFragmentByTag(LoginFragment.TAG)
                manager.beginTransaction()
                        .show(fragment)
                        .commit()
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        component.inject(this)
        loginPresenter = component.loginPresenter()

        loginPresenter.attachView(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.login_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginBtn.setOnClickListener(this)
        registerBtn.setOnClickListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.attachView(this)
    }

    override fun onClick(btn: View?) {
        when (btn?.id) {
            R.id.btn_login -> login()
            R.id.btn_register -> register()
        }
    }

    fun register() {
        RegisterFragment.launch(activity.supportFragmentManager, R.id.fragment_container)
    }

    fun login() {
        if (TextUtils.isEmpty(userName.text.toString())) {
            userName.error = getString(R.string.empty_account_name)
            return
        }

        if (TextUtils.isEmpty(userPassword.text.toString())) {
            userPassword.error = getString(R.string.empty_account_pwd)
            return
        }

        val accountInfo: AccountInfo = AccountInfo()
        accountInfo.username = userName.text.toString()
        accountInfo.setPassword(userPassword.text.toString())
        loginPresenter.login(accountInfo)
    }

    //===============================响应行为相关==============================
    override fun showProgress() {
    }

    override fun loginSuccess() {
        //跳转到表情同步页面
        showToast(getString(R.string.login_ok))
        activity.finish()
    }

    override fun loginFailed(errorMessage: String) {
        showToast(getString(R.string.login_error))
    }


}