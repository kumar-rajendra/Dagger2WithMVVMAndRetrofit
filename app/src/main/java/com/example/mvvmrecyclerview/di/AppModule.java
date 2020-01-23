package com.example.mvvmrecyclerview.di;

import com.example.mvvmrecyclerview.repositories.NicePlaceRepository;
import com.example.mvvmrecyclerview.services.IRemoteService;
import com.example.mvvmrecyclerview.services.RemoteService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {


    @Provides
    static IRemoteService getRemoteService()
    {
        return new RemoteService(NicePlaceRepository.getInstance());
    }

    @Provides
    static NicePlaceRepository getNicePlaceRepo()
    {
        return NicePlaceRepository.getInstance();
    }
}
