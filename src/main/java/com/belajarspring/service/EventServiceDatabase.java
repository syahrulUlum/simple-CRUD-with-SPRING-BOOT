package com.belajarspring.service;

import com.belajarspring.dao.EventMapper;
import com.belajarspring.model.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceDatabase extends EventService {
    @Autowired
    EventMapper eventMapper;

    @Override
    public void tambahEvent(EventModel event) {
        eventMapper.tambahEvent(event);
    }

    @Override
    public List<EventModel> lihatSemuaEvent() {
        return eventMapper.ambilSemuaEvent();
    }

    @Override
    public void ubahEvent(EventModel event){
        eventMapper.ubahEvent(event);
    }
    @Override
    public EventModel ambilEvent(int id) {
        return eventMapper.ambilEvent(id);
    }
}
