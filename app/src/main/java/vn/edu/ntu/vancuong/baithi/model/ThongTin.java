package vn.edu.ntu.vancuong.baithi.model;

public class ThongTin {
    String monhoc;
    String ngaybd;
    String ngaykt;
    String giangduong;
    String hinhthuc;

    public ThongTin() {
    }

    public ThongTin(String monhoc, String ngaybd, String ngaykt, String giangduong, String hinhthuc) {
        this.monhoc = monhoc;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
        this.giangduong = giangduong;
        this.hinhthuc = hinhthuc;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }

    public String getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(String ngaybd) {
        this.ngaybd = ngaybd;
    }

    public String getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(String ngaykt) {
        this.ngaykt = ngaykt;
    }

    public String getGiangduong() {
        return giangduong;
    }

    public void setGiangduong(String giangduong) {
        this.giangduong = giangduong;
    }

    public String getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }
}
