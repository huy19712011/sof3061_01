package com.example.sof3061_01.service.impl;

import com.example.sof3061_01.entity.Diem;
import com.example.sof3061_01.exception.ResourceNotFoundException;
import com.example.sof3061_01.repository.DiemRepository;
import com.example.sof3061_01.service.DiemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiemServiceImpl implements DiemService {

    private final DiemRepository diemRepository;

    @Override
    public List<Diem> getDiems() {

        return diemRepository.findAll();
    }

    @Override
    public Diem getDiem(long id) {

        return diemRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diem not found with id: " + id));
    }
}
