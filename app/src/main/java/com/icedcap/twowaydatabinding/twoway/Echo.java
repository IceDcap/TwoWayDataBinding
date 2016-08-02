package com.icedcap.twowaydatabinding.twoway;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

import com.icedcap.twowaydatabinding.util.Objects;

import java.io.Serializable;


/**
 * Author: doushuqi
 * Date: 16-8-1
 * Email: shuqi.dou@singuloid.com
 * LastUpdateTime:
 * LastUpdateBy:
 */
public class Echo implements Serializable{
    //    public String text = "ddd";
//    public String text;
    public ObservableField<String> text = new ObservableField<>();
    public TextWatcher watch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            /* no-op*/
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            /* no-op*/
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!Objects.equals(text.get(), s.toString())) {
                text.set(s.toString());
            }
        }
    };
}
