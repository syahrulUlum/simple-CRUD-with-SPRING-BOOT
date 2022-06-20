package com.belajarspring.controller;

import com.belajarspring.model.EventModel;
import com.belajarspring.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    EventService eventService;

    @RequestMapping("/event/tambah")
    public String tambahEvent(){
        return "tambah-event";
    }

    @RequestMapping(value = "/event/tambah/simpan", method = RequestMethod.POST)
    public String simpanEvent(
            @RequestParam(value = "nama", required = false) String nama,
            @RequestParam(value = "kategori", required = false) String kategori,
            @RequestParam(value = "lokasi", required = false) String lokasi,
            @RequestParam(value = "deskripsi", required = false) String deskripsi
    ) {
        EventModel event = new EventModel(0, nama, kategori, lokasi, deskripsi);
        eventService.tambahEvent(event);
        return "redirect:/";

    }

    @RequestMapping("/")
    public String semuaEvent(Model model){
       List<EventModel> events =  eventService.lihatSemuaEvent();
       model.addAttribute("events", events);
        return "semua-event";
    }

    @RequestMapping("/event/ubah/{id}")
    public String ubahEvent(@PathVariable(value = "id") int id, Model model){
        EventModel event = eventService.ambilEvent(id);
        model.addAttribute("event", event);
        return "ubah-event";
    }

    @RequestMapping("/event/ubah/simpan")
    public String updateEvent(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "nama", required = false) String nama,
            @RequestParam(value = "kategori", required = false) String kategori,
            @RequestParam(value = "lokasi", required = false) String lokasi,
            @RequestParam(value = "deskripsi", required = false) String deskripsi
    ) {
        EventModel event = new EventModel(id, nama, kategori, lokasi, deskripsi);
        eventService.ubahEvent(event);
        return "redirect:/";

    }

}
