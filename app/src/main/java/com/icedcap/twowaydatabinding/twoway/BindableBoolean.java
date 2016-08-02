package com.icedcap.twowaydatabinding.twoway;

import android.databinding.BaseObservable;

/**
 * Author: doushuqi
 * Date: 16-8-1
 * Email: shuqi.dou@singuloid.com
 * LastUpdateTime:
 * LastUpdateBy:
 */
public class BindableBoolean extends BaseObservable {
    private boolean enabled;

    public boolean get() {
        return enabled;
    }

    public void set(boolean value) {
        if (enabled != value) {
            this.enabled = value;
            notifyChange();
        }
    }
}
