package com.example.nikul.gifsearchapplication.presentation.screens.main;

import android.view.ViewGroup;

import com.example.domain.entity.DataEntity;
import com.example.nikul.gifsearchapplication.presentation.base.BaseAdapter;
import com.example.nikul.gifsearchapplication.presentation.base.BaseItemViewHolder;


public class DataAdapter extends BaseAdapter<DataEntity,DataItemViewModel> {


    private boolean isClickable;

    @Override
    public BaseItemViewHolder<DataEntity, DataItemViewModel, ?> onCreateViewHolder(ViewGroup parent, int viewType) {


        return DataItemViewHolder.create(parent, new DataItemViewModel());
    }
}
