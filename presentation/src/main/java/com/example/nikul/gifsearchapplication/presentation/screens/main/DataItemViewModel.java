package com.example.nikul.gifsearchapplication.presentation.screens.main;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.domain.entity.DataEntity;
import com.example.nikul.gifsearchapplication.presentation.base.BaseItemViewModel;


public class DataItemViewModel extends BaseItemViewModel<DataEntity> {

    public ObservableField<String> id = new ObservableField<>("");
    public ObservableField<String> url = new ObservableField<>("");



    @Override
    public void setItem(DataEntity dataEntity, int position) {
        id.set(dataEntity.getId());
        url.set(String.valueOf(dataEntity.getUrl()));
    }

    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url).into(view);
    }
}
