package com.belajarspring.service;

import com.belajarspring.model.EventModel;

import java.util.List;

public abstract class EventService {
    public abstract void tambahEvent(EventModel event);

    public abstract List<EventModel> lihatSemuaEvent();

    public abstract void ubahEvent(EventModel event);

    public abstract EventModel ambilEvent(int id);
}
