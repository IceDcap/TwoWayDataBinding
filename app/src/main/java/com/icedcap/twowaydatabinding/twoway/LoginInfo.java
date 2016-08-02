package com.icedcap.twowaydatabinding.twoway;

import android.support.design.widget.Snackbar;
import android.util.Patterns;
import android.view.View;

import com.icedcap.twowaydatabinding.R;

import java.io.Serializable;

/**
 * Author: doushuqi
 * Date: 16-8-1
 * Email: shuqi.dou@singuloid.com
 * LastUpdateTime:
 * LastUpdateBy:
 */
public class LoginInfo implements Serializable {
    public BindableStringSerializable email = new BindableStringSerializable();
    public BindableStringSerializable password = new BindableStringSerializable();
    public BindableStringSerializable emailError = new BindableStringSerializable();
    public BindableStringSerializable passwordError = new BindableStringSerializable();
    public BindableBoolean existingUser = new BindableBoolean();

    private boolean loginExecuted;

    public LoginInfo() {
//        this.emailError.set("error!");
    }

    public void reset() {
        email.set(null);
        password.set(null);
        emailError.set(null);
        passwordError.set(null);
        loginExecuted = false;
    }

    public boolean validate(View view) {
        if (!loginExecuted) {
            return true;
        }
        int emailErrorRes = 0;
        int passwordErrorRes = 0;
        if (email.get().isEmpty()) {
            emailErrorRes = R.string.mandatory_field;
        } else {
            if (!Patterns.EMAIL_ADDRESS.matcher(email.get()).matches()) {
                emailErrorRes = R.string.invalid_email;
            }
        }

        if (existingUser.get() && password.get().isEmpty()) {
            passwordErrorRes = R.string.mandatory_field;
        }

        emailError.set(emailErrorRes != 0 ? view.getResources().getString(emailErrorRes) : null);
        passwordError.set(passwordErrorRes != 0 ? view.getResources().getString(passwordErrorRes) : null);
        return emailErrorRes == 0 && passwordErrorRes == 0;
    }

    public void login(View view) {
        loginExecuted = true;
        if (validate(view)) {
            Snackbar.make(view, email.get() + " - " + password.get(), Snackbar.LENGTH_LONG).show();
        }
    }

}
