package com.nanfang.backend.wj.bean;

/**
 * @author nanfang
 * @create 2020/02/06/23:18
 */
public class Book {
    private int id;
    private String cover;
    private String title;
    private String author;
    private String date;
    private String price;
    private String newOld;
    private String contact;
    private String phone;
    private String qq;
    private String weChat;
    private String img_1;
    private String img_2;
    private String img_3;
    private String img_4;
    private String img_5;
    private String abs;
    private String cid;
    private String uid;

    //书的种类


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNewOld() {
        return newOld;
    }

    public void setNewOld(String newOld) {
        this.newOld = newOld;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getImg_1() {
        return img_1;
    }

    public void setImg_1(String img_1) {
        this.img_1 = img_1;
    }

    public String getImg_2() {
        return img_2;
    }

    public void setImg_2(String img_2) {
        this.img_2 = img_2;
    }

    public String getImg_3() {
        return img_3;
    }

    public void setImg_3(String img_3) {
        this.img_3 = img_3;
    }

    public String getImg_4() {
        return img_4;
    }

    public void setImg_4(String img_4) {
        this.img_4 = img_4;
    }

    public String getImg_5() {
        return img_5;
    }

    public void setImg_5(String img_5) {
        this.img_5 = img_5;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", price='" + price + '\'' +
                ", newOld='" + newOld + '\'' +
                ", contact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", weChat='" + weChat + '\'' +
                ", img_1='" + img_1 + '\'' +
                ", img_2='" + img_2 + '\'' +
                ", img_3='" + img_3 + '\'' +
                ", img_4='" + img_4 + '\'' +
                ", img_5='" + img_5 + '\'' +
                ", abs='" + abs + '\'' +
                ", cid='" + cid + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
