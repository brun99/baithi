package vn.edu.ntu.vancuong.baithi.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.vancuong.baithi.model.ThongTin;

public class Controller extends Application implements IController {

    List<ThongTin> thongTinList;
    public Controller() {
        thongTinList = new ArrayList<>();
    }

    @Override
    public List<ThongTin> getAllThongTin() {
        return thongTinList;
    }

    @Override
    public void add(ThongTin thongTin) {
        thongTinList.add(thongTin);
    }
}
