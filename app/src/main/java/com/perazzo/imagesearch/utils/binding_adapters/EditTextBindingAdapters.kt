package com.perazzo.imagesearch.utils.binding_adapters

import android.databinding.BindingAdapter
import android.text.TextWatcher
import android.widget.EditText

@BindingAdapter("textChangedListener")
fun bindTextWatcher(editText: EditText, textWatcher: TextWatcher) {
    editText.addTextChangedListener(textWatcher)
}