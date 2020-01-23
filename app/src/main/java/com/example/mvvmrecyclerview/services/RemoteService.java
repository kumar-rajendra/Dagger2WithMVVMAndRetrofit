package com.example.mvvmrecyclerview.services;

import com.example.mvvmrecyclerview.repositories.NicePlaceRepository;

public class RemoteService implements IRemoteService {

    NicePlaceRepository nicePlaceRepository;

    public RemoteService(NicePlaceRepository nicePlaceRepository)
    {
        this.nicePlaceRepository = nicePlaceRepository;
    }


    @Override
    public String GetServerName() {
        return "Remote Server Injection " + this.nicePlaceRepository.getNicePlaces().getValue().size();
    }
}
