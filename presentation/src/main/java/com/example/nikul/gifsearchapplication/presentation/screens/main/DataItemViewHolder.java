package com.example.nikul.gifsearchapplication.presentation.screens.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.domain.entity.DataEntity;
import com.example.nikul.gifsearchapplication.databinding.ItemDataBinding;
import com.example.nikul.gifsearchapplication.presentation.base.BaseItemViewHolder;


public class DataItemViewHolder extends BaseItemViewHolder<DataEntity,DataItemViewModel,ItemDataBinding> {



    public DataItemViewHolder(ItemDataBinding binding, DataItemViewModel viewModel) {
        super(binding, viewModel);
    }

    public static DataItemViewHolder create(ViewGroup parent, DataItemViewModel dataItemViewModel){
        ItemDataBinding binding =
                ItemDataBinding.inflate
                        (LayoutInflater.from(parent.getContext()),parent,false);

        return new DataItemViewHolder(binding, dataItemViewModel);
    }
}
