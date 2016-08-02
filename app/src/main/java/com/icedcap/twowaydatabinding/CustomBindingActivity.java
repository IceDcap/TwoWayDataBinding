package com.icedcap.twowaydatabinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.icedcap.twowaydatabinding.databinding.ActivityCustomBinding;
import com.icedcap.twowaydatabinding.twoway.CustomEcho;


/**
 * Author: doushuqi
 * Date: 16-8-1
 * Email: shuqi.dou@singuloid.com
 * LastUpdateTime:
 * LastUpdateBy:
 */
public class CustomBindingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCustomBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_custom);
        binding.setEcho(new CustomEcho());
    }

}
