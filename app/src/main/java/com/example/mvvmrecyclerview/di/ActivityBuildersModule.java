package com.example.mvvmrecyclerview.di;

import com.example.mvvmrecyclerview.MainActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @Provides
    static String TestString()
    {
        return "this is test injection";
    }

}
