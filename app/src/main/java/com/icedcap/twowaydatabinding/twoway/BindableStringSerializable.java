package com.icedcap.twowaydatabinding.twoway;

import android.databinding.BaseObservable;

import com.icedcap.twowaydatabinding.util.Objects;

import java.io.Serializable;

/**
 * Author: doushuqi
 * Date: 16-8-2
 * Email: shuqi.dou@singuloid.com
 * LastUpdateTime:
 * LastUpdateBy:
 */
public class BindableStringSerializable extends BaseObservable implements Serializable {
    static final long serialVersionUID = 1L;
    private String mValue;

    public String get() {
        return mValue != null ? mValue : "";
    }


    public void set(String mValue) {
        if (!Objects.equals(mValue, this.mValue)) {
            this.mValue = mValue;
            notifyChange();
        }
    }

    public boolean isEmpty() {
        return mValue == null || mValue.isEmpty();
    }

}
