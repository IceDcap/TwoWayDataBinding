package com.icedcap.twowaydatabinding.twoway;

import android.databinding.BaseObservable;

import com.icedcap.twowaydatabinding.util.Objects;

/**
 * Author: doushuqi
 * Date: 16-8-1
 * Email: shuqi.dou@singuloid.com
 * LastUpdateTime:
 * LastUpdateBy:
 */
public class BindableString extends BaseObservable {
    private String value;

    public String get() {
        return value != null ? value : "";
    }


    public void set(String value) {
        if (!Objects.equals(value, this.value)) {
            this.value = value;
            notifyChange();
        }
    }

    public boolean isEmpty() {
        return value == null || value.isEmpty();
    }


}
