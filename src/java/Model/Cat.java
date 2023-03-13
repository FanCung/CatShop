/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anh
 */
public class Cat {

    private int catID;
    private String catName;
    private int yob;
    private boolean gender;
    private String image;
    private String description;
    private int price;
    private int cateID;
    private boolean status;

    public Cat(int catID, String catName, int yob, boolean gender, String image, String description, int price, int cateID,boolean status) {
        this.catID = catID;
        this.catName = catName;
        this.yob = yob;
        this.gender = gender;
        this.image = image;
        this.description = description;
        this.price = price;
        this.cateID = cateID;
        this.status= status;
    }

    public Cat( String catName, int yob, boolean gender, String image, String description, int price, int cateID,boolean status) {
        this.catName = catName;
        this.yob = yob;
        this.gender = gender;
        this.image = image;
        this.description = description;
        this.price = price;
        this.cateID = cateID;
        this.status= status;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int age) {
        this.yob = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
