package com.example.sof3061_01.controller;

import com.example.sof3061_01.entity.Diem;
import com.example.sof3061_01.service.DiemService;
import com.example.sof3061_01.service.impl.DiemServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/diems")
public class DiemController {

    private final DiemService diemService;

    @GetMapping
    public ResponseEntity<List<Diem>> getDiems() {

        List<Diem> diems = diemService.getDiems();

        //return new ResponseEntity<>(diems, HttpStatus.OK);
        return ResponseEntity.ok(diems);
    }

    @GetMapping("{id}")
    public ResponseEntity<Diem> getDiem(@PathVariable("id") long id) {

        Diem diem = diemService.getDiem(id);

        return ResponseEntity.ok(diem);
    }
}
