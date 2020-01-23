package com.example.mvvmrecyclerview.viewmodels;

import com.example.mvvmrecyclerview.models.NicePlace;
import com.example.mvvmrecyclerview.repositories.NicePlaceRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
     private  MutableLiveData<List<NicePlace>> nicePlaces;
     private NicePlaceRepository mRepo;
     public void init()
     {
          if(nicePlaces!= null)
          {
               return;
          }
          mRepo= NicePlaceRepository.getInstance();
          nicePlaces = mRepo.getNicePlaces();
     }

     public LiveData<List<NicePlace>> getNicePlaces()
     {
         return  nicePlaces;
     }
}
