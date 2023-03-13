/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Account;
import Model.Cat;
import Model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anh
 */
public class DAO {

    private String status;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account userLogin(String email, String password) {
        String sql = "select * from [Account] where [email]=? and [password]=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {

        }

        return null;
    }

    public List<Account> getAllUser() {
        List<Account> acc = new ArrayList<Account>();
        String sql = "select * from Account";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                acc.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
        } catch (Exception e) {

        }
        return acc;
    }

    public Account getAccountByID(int id) {
        String sql = "select * from Account where accID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void resetPassword(int id, String password) {
        String sql = "Update Account \n" + "set [password]= ?" + " where accID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void registerAccount(Account a) {
        String sql = "insert into Account values(?,?,?,?,0,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getEmail());
            ps.setString(2, a.getPassword());
            ps.setString(3, a.getFullname());
            ps.setString(4, a.getPhone());
            ps.setString(5, a.getQuestion());
            ps.setString(6, a.getAnswer());
            ps.setString(7, a.getAddress());
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void update(int id, String name, String phone, String question, String answer, String address) {
        String sql = "Update Account \n" + "set [fullname]= ? ,phone=? ,question=? ,answer=? ,address=?" + " where accID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, question);
            ps.setString(4, answer);
            ps.setString(5, address);
            ps.setInt(6, id);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public List<Category> getCategory() {
        List<Category> cate = new ArrayList<>();
        String sql = "select * from Category";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cate.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return cate;
    }

    public List<Cat> getCatByCategoryID(int id) {
        List<Cat> cat = new ArrayList<>();
        String sql = "select * from Cat c left join Category ca on c.cateID= ca.cateID where c.cateID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                cat.add(new Cat(id, rs.getString(2), rs.getInt(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8),rs.getBoolean(9)));
            }
        } catch (Exception e) {

        }
        return cat;
    }

    public void addCat(Cat cat) {
        String sql = "insert into Cat values(?,?,?,?,?,?,?,1)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getCatName());
            ps.setInt(2, cat.getYob());
            ps.setBoolean(3, cat.isGender());
            ps.setString(4, cat.getImage());
            ps.setString(5, cat.getDescription());
            ps.setInt(6, cat.getPrice());
            ps.setInt(7, cat.getCateID());
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void updateCat(Cat cat) {
        String sql="update Cat \n"+"set catName=? ,yob=? ,gender=? , image=? ,descripton=? ,price=? ,cateID=?  where catID =? ";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getCatName());
            ps.setInt(2, cat.getYob());
            ps.setBoolean(3, cat.isGender());
            ps.setString(4,cat.getImage());
            ps.setString(5, cat.getDescription());
            ps.setInt(6, cat.getPrice());
            ps.setInt(7, cat.getCateID());
            ps.setInt(8, cat.getCatID());
            ps.executeUpdate();

        } catch (Exception e) {

        }

    }

    public void deleteCat(int id) {
        String sql = "delete from Cat where catID=? ";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public List<Cat> getAllCat() {
        List<Cat> cat = new ArrayList<>();
        String sql = "select * from Cat";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cat.add(new Cat(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8),rs.getBoolean(9)));
            }
        } catch (Exception e) {

        }
        return cat;
    }
    
    public void createOrder(int catID, int accID){
        
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Cat> list = dao.getCatByCategoryID(1);
        if (list == null) {
            System.out.println("AAAAAAAA");
        } else {
            for (Cat c : list) {
                System.out.println(c.isStatus());

            }
        }
//        dao.update(1, "Anh Nguyen Lmao","0385699822","is cat the best","yes","Hanoi");
//        List<Account> list = dao.getAllUser();
//        for (Account a : list) {
//            if (a.getAccID() == 1) {
//                System.out.println(a.getFullname());
//            }
//        }
    }

}
