package com.icedcap.twowaydatabinding.util;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.ObservableField;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.icedcap.twowaydatabinding.R;
import com.icedcap.twowaydatabinding.twoway.BindableBoolean;
import com.icedcap.twowaydatabinding.twoway.BindableString;
import com.icedcap.twowaydatabinding.twoway.BindableStringSerializable;

/**
 * Author: doushuqi
 * Date: 16-8-1
 * Email: shuqi.dou@singuloid.com
 * LastUpdateTime:
 * LastUpdateBy:
 */
public class Converters {

    @BindingConversion
    public static String convertBindableToString(BindableString bindableString) {
        return bindableString.get();
    }

    @BindingConversion
    public static boolean convertBindableToBoolean(BindableBoolean bindableBoolean) {
        return bindableBoolean.get();
    }

    @BindingAdapter("app:binding")
    public static void bindEditText(EditText editText, final BindableString bindableString) {
        Pair<BindableString, TextWatcher> pair = (Pair) editText.getTag(R.id.bound_observable);
        if (null == pair || pair.first != bindableString) {
            if (pair != null) {
                editText.removeTextChangedListener(pair.second);
            }
            TextWatcher textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    /* no-op */
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    bindableString.set(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {
                    /* no-op */
                }
            };

            editText.setTag(R.id.bound_observable, new Pair<>(bindableString, textWatcher));
            editText.addTextChangedListener(textWatcher);
        }
        String newValue = bindableString.get();
        if (!editText.getText().toString().equals(newValue)) {
            editText.setText(newValue);
        }
    }

    @BindingAdapter("app:binding")
    public static void bindObservableEditText(EditText editText, final BindableStringSerializable value) {
        Pair<BindableStringSerializable, TextWatcher> pair = (Pair) editText.getTag(R.id.bound_observable);
        if (null == pair || pair.first != value) {
            if (pair != null) {
                editText.removeTextChangedListener(pair.second);
            }
            TextWatcher textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    /* no-op */
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    value.set(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {
                    /* no-op */
                }
            };

            editText.setTag(R.id.bound_observable, new Pair<>(value, textWatcher));
            editText.addTextChangedListener(textWatcher);
        }
        String newValue = value.get();
        if (!editText.getText().toString().equals(newValue)) {
            editText.setText(newValue);
        }
    }

    @BindingAdapter("app:binding")
    public static void bindRadioGroup(RadioGroup radioGroup, final BindableBoolean value) {
        if (radioGroup.getTag(R.id.bound_observable) != value) {
            radioGroup.setTag(R.id.bound_observable, value);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    value.set(checkedId == group.getChildAt(1).getId());
                }
            });
        }
        boolean newValue = value.get();
        ((RadioButton) radioGroup.getChildAt(newValue ? 1 : 0)).setChecked(true);
    }

    @BindingAdapter("app:error")
    public static void error(TextInputLayout inputLayout, BindableString value) {
        if (inputLayout.getTag(R.id.bound_observable) != value) {
            inputLayout.setTag(R.id.bound_observable, value);
        }
        inputLayout.setErrorEnabled(!value.isEmpty());
        inputLayout.setError(value.get());
    }

    @BindingAdapter("app:error")
    public static void error(TextInputLayout inputLayout, BindableStringSerializable value) {
        if (inputLayout.getTag(R.id.bound_observable) != value) {
            inputLayout.setTag(R.id.bound_observable, value);
        }
        inputLayout.setErrorEnabled(!value.isEmpty());
        inputLayout.setError(value.get());
    }
}
