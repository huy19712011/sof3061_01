package com.example.sof3061_01.service.impl;

import com.example.sof3061_01.dto.DiemDto;
import com.example.sof3061_01.entity.Diem;
import com.example.sof3061_01.exception.ResourceNotFoundException;
import com.example.sof3061_01.repository.DiemRepository;
import com.example.sof3061_01.service.DiemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class DiemServiceImpl implements DiemService {

    private final DiemRepository diemRepository;
    private final ModelMapper modelMapper;

    public DiemServiceImpl(DiemRepository diemRepository, ModelMapper modelMapper) {
        this.diemRepository = diemRepository;
        this.modelMapper = modelMapper;

        TypeMap<Diem, DiemDto> propertyMapper = modelMapper.createTypeMap(Diem.class, DiemDto.class);
        propertyMapper.addMappings(mapper -> {
            mapper.map(src -> src.getSinhVien().getHoTen(), DiemDto::setHoTen);
            mapper.map(src -> src.getSinhVien().getDiaChi(), DiemDto::setDiaChi);
        });
    }

    //@Override
    //public List<Diem> getDiems() {
    //
    //    return diemRepository.findAll();
    //}

    @Override
    public List<DiemDto> getDiems() {

        return diemRepository.findAll().stream()
                .map(i -> modelMapper.map(i, DiemDto.class))
                .collect(Collectors.toList());
    }



    @Override
    public Diem getDiem(long id) {

        return diemRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diem not found with id: " + id));
    }

    @Override
    public Diem updateDiem(Diem diem, long id) {

        Diem exitstingDiem = diemRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diem not found with id: " + id));

        exitstingDiem.setDiemSo(diem.getDiemSo());

        return diemRepository.save(exitstingDiem);
    }

    @Override
    public void deleteDiem(long id) {

        Diem exitstingDiem = diemRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diem not found with id: " + id));

        //diemRepository.deleteById(id);
        diemRepository.delete(exitstingDiem);

    }


}
