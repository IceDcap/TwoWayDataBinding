package com.icedcap.twowaydatabinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import com.icedcap.twowaydatabinding.databinding.ActivityTwowayBinding;
import com.icedcap.twowaydatabinding.twoway.Echo;

/**
 * Author: doushuqi
 * Date: 16-8-1
 * Email: shuqi.dou@singuloid.com
 * LastUpdateTime:
 * LastUpdateBy:
 */
public class TwoWayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTwowayBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_twoway);
        binding.setEcho(new Echo());
    }

}
