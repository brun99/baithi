package vn.edu.ntu.vancuong.baithi.controller;

import java.util.List;

import vn.edu.ntu.vancuong.baithi.model.ThongTin;

public interface IController {
    public List<ThongTin> getAllThongTin();
    public void add(ThongTin thongTin);
}
