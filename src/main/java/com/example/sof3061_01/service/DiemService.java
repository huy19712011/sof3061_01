package com.example.sof3061_01.service;

import com.example.sof3061_01.dto.DiemDto;
import com.example.sof3061_01.entity.Diem;

import java.util.List;

public interface DiemService {

    //List<Diem> getDiems();
    List<DiemDto> getDiems();

    Diem getDiem(long id);

    Diem updateDiem(Diem diem, long id);

    void deleteDiem(long id);
}
