package com.lemubit.lemuel.architecturalcomponentstest.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lemubit.lemuel.architecturalcomponentstest.db.MainRepository;
import com.lemubit.lemuel.architecturalcomponentstest.db.Model;

public class UserViewModel extends AndroidViewModel {
    private MainRepository mainRepository;
    private LiveData<Integer> count;

    //for view model example
    public int plusOne = 0;


    public UserViewModel(@NonNull Application application) {
        super(application);
        mainRepository = new MainRepository(application);
        count = mainRepository.getCount();

    }

    public void insert(Model model) {
        mainRepository.insertNewUser(model);
    }

    public LiveData<Integer> getCount() {
        return count;
    }
}
