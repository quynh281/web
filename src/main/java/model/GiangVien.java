package model;

public class GiangVien {
    private int id;
    private String ten;
    private String chucDanh;
    private String email;
    private String soDienThoai;

    // Constructor
    public GiangVien(int id, String ten, String chucDanh, String email, String soDienThoai) {
        this.id = id;
        this.ten = ten;
        this.chucDanh = chucDanh;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }

    // Getter và Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public String getChucDanh() { return chucDanh; }
    public void setChucDanh(String chucDanh) { this.chucDanh = chucDanh; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }
}
