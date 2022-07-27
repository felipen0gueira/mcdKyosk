/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.mckyosk.dao;

import com.felipe.mckyosk.enums.CategoryEnum;
import com.felipe.mckyosk.model.MealModel;
import com.felipe.mckyosk.model.MenuItemModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author felip
 */
public class ItemDao {

    private Connection connect() {

        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/felip/OneDrive/Documentos/Repeat CA 22/McData";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;

    }

    public void selectAllItems() {
        String sql = "SELECT * from item";

        System.out.println("SELECT * FROM item");

        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id_item") + "\t"
                        + rs.getString("item_category") + "\t"
                        + rs.getString("item_name") + "\t"
                        + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<MenuItemModel> selectAllItemsByCategory(int categoryId) {
        String sql = "SELECT item.id_item,item.item_name, item.item_size, item.price, item_has_categories.category_id,item_has_categories.item_id "
                + "from item "
                + "INNER JOIN item_has_categories on item_has_categories.item_id=item.id_item "
                + "where category_id=? ";

        System.out.println("selectAllItemsByCategory");
        List<MenuItemModel> items = new ArrayList<>();

        try (
                 Connection conn = this.connect(); //Statement stmt = conn.createStatement();  
                  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, categoryId);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                MenuItemModel i = new MenuItemModel(rs.getInt("id_item"), rs.getString("item_name"), null, rs.getString("item_size"), rs.getFloat("price"));
                items.add(i);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return items;
    }

    public MenuItemModel getItemById(int itemId) {
        String sql = "SELECT * from item where id_item=?";

        List<Integer> categories = categoriesById(itemId);

        try (
                 Connection conn = this.connect(); //Statement stmt = conn.createStatement();  
                  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, itemId);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                if (categories.stream().anyMatch(x -> x == CategoryEnum.MEAL.getId())) {
                    System.out.println("MEAL MEAL");
                    MealModel m = new MealModel(rs.getInt("id_item"), rs.getString("item_name"), categories, rs.getString("item_size"), rs.getFloat("price"));
                    return m;

                } else {
                    MenuItemModel i = new MenuItemModel(rs.getInt("id_item"), rs.getString("item_name"), categories, rs.getString("item_size"), rs.getFloat("price"));
                    return i;

                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

    public List<Integer> categoriesById(int itemId) {
        List<Integer> categoriesId = new ArrayList<Integer>();
        String sql = "SELECT * from item_has_categories where item_id=?";

        try (
                 Connection conn = this.connect(); //Statement stmt = conn.createStatement();  
                  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, itemId);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("category_id"));
                categoriesId.add(rs.getInt("category_id"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return categoriesId;
    }

    public static void main(String[] args) {

        ItemDao d = new ItemDao();

        d.selectAllItemsByCategory(11);
        //d.selectAllItems();
    }

    public List<MenuItemModel> getDrinksList(String mealSize) {
        String sql = "SELECT item.id_item,item.item_name, item.item_size, item.price, item_has_categories.category_id,item_has_categories.item_id "
                + "from item "
                + " INNER JOIN item_has_categories on item_has_categories.item_id=item.id_item "
                + " where category_id=3 and item_size=? ";

        List<MenuItemModel> drinksList = new ArrayList<>();

        try (
                 Connection conn = this.connect(); //Statement stmt = conn.createStatement();  
                  PreparedStatement pstmt = conn.prepareStatement(sql);) {
            
             pstmt.setString(1, mealSize);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                
                MenuItemModel i = new MenuItemModel(rs.getInt("id_item"), rs.getString("item_name"), null, rs.getString("item_size"), rs.getFloat("price"));
                drinksList.add(i);
                System.out.println(i.getItemName());
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return drinksList;
    }
    
    
    public List<MenuItemModel> getSidesList(String mealSize) {
        String sql = "SELECT item.id_item,item.item_name, item.item_size, item.price, item_has_categories.category_id,item_has_categories.item_id "
                + "from item "
                + " INNER JOIN item_has_categories on item_has_categories.item_id=item.id_item "
                + " where (category_id=9 and item_size=?) OR (category_id=9 and item_size is NULL)";

        List<MenuItemModel> sidesList = new ArrayList<>();

        try (
                 Connection conn = this.connect(); //Statement stmt = conn.createStatement();  
                  PreparedStatement pstmt = conn.prepareStatement(sql);) {
            
            pstmt.setString(1, mealSize);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                
                MenuItemModel i = new MenuItemModel(rs.getInt("id_item"), rs.getString("item_name"), null, rs.getString("item_size"), rs.getFloat("price"));
                sidesList.add(i);
                System.out.println(i.getItemName());
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return sidesList;
    }

}
