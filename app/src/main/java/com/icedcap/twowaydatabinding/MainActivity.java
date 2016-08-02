package com.icedcap.twowaydatabinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.icedcap.twowaydatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setBinding(new MainBinding());
    }

    public class MainBinding {
        public Class<?> twoWay = TwoWayActivity.class;
        public Class<?> custom = CustomBindingActivity.class;
        public Class<?> rotation = RotationStoreActivity.class;
        public Class<?> login = LoginActivity.class;

        public void startTarget(Class<?> cla) {
            startActivity(new Intent(MainActivity.this, cla));
        }
    }
}
