package com.belajarspring.dao;

import com.belajarspring.model.EventModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EventMapper {
    @Insert("INSERT INTO event (nama, kategori, lokasi, deskripsi) VALUES (#{nama}, #{kategori}, #{lokasi}, #{deskripsi})")
    void tambahEvent(EventModel event);

    @Select("SELECT * FROM event")
    List<EventModel> ambilSemuaEvent();

    @Update("UPDATE event SET nama=#{nama}, kategori=#{kategori}, lokasi=#{lokasi}, deskripsi=#{deskripsi} WHERE id=#{id}")
    void ubahEvent(EventModel event);

    @Select("SELECT * FROM event WHERE id=#{id}")
    EventModel ambilEvent(int id);
}
