package com.icedcap.twowaydatabinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.icedcap.twowaydatabinding.twoway.LoginInfo;
import com.icedcap.twowaydatabinding.databinding.ActivityLoginBinding;

/**
 * Author: doushuqi
 * Date: 16-8-1
 * Email: shuqi.dou@singuloid.com
 * LastUpdateTime:
 * LastUpdateBy:
 */
public class LoginActivity extends Activity {
    private static final String KEY = "LOGINMESSIGE";
    private LoginInfo mLoginInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null == savedInstanceState) {
            mLoginInfo = new LoginInfo();
        } else {
            mLoginInfo = (LoginInfo) savedInstanceState.getSerializable(KEY);
        }
        final ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setLoginInfo(mLoginInfo);
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mLoginInfo.validate(binding.getRoot());
            }
        };

        binding.etEmail.addTextChangedListener(watcher);
        binding.etPassword.addTextChangedListener(watcher);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY, mLoginInfo);
    }
}
