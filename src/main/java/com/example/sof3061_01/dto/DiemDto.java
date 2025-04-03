package com.example.sof3061_01.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DiemDto {

    private long id;
    private String maDiem;


    private String hoTen; // hoTen of SinhVien
    private String diaChi; // diaChi of SinhVien


    private String monHoc;
    private double diemSo;
}
