package model;

public class LopHoc {
    private int id;
    private String tenLop;
    private String moTa;
    private String giangVien;

    public LopHoc(int id, String tenLop, String moTa, String giangVien) {
        this.id = id;
        this.tenLop = tenLop;
        this.moTa = moTa;
        this.giangVien = giangVien;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }
}
