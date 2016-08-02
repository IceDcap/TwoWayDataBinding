package com.icedcap.twowaydatabinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.icedcap.twowaydatabinding.databinding.ActivityRotationBinding;
import com.icedcap.twowaydatabinding.twoway.Rotation;

/**
 * Author: doushuqi
 * Date: 16-8-1
 * Email: shuqi.dou@singuloid.com
 * LastUpdateTime:
 * LastUpdateBy:
 */
public class RotationStoreActivity extends Activity {

    private static final String ECHO = "ECHO";
    private Rotation mEcho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null == savedInstanceState) {
            mEcho = new Rotation();
        } else {
            mEcho = (Rotation) savedInstanceState.getSerializable(ECHO);
        }
        ActivityRotationBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_rotation);
        binding.setEcho(mEcho);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ECHO, mEcho);
    }


}
