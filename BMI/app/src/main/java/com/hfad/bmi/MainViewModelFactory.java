package com.hfad.bmi;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    Context context;
    MainViewModelFactory(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)){
            MainViewModel viewModel = new MainViewModel(context);
            return (T) viewModel;
        }else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
