/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anh
 */
public class Account {
    private int accID;
    private String email;
    private String password;
    private String fullname;
    private String phone;
    boolean admin;
    private String question;
    private String answer;
    private String address;

    public Account(int accID, String email, String password, String fullname, String phone, boolean admin, String question, String answer, String address) {
        this.accID = accID;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.admin = admin;
        this.question = question;
        this.answer = answer;
        this.address = address;
    }
    
        public Account( String email, String password, String fullname, String phone, String question, String answer, String address) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.question = question;
        this.answer = answer;
        this.address = address;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
