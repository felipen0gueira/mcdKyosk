/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.mckyosk.dao;

import com.felipe.mckyosk.controller.OrderListSingleton;
import com.felipe.mckyosk.enums.CategoryEnum;
import com.felipe.mckyosk.model.ItemCustomizationModel;
import com.felipe.mckyosk.model.MealModel;
import com.felipe.mckyosk.model.MenuItemModel;
import java.awt.MenuItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
            String url = "jdbc:sqlite:./src/database/McData.db";
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
        /* String sql = "SELECT item.id_item,item.item_name, item.item_size, item.price, item_has_categories.category_id,item_has_categories.item_id "
                + "from item "
                + "INNER JOIN item_has_categories on item_has_categories.item_id=item.id_item "
                + "where category_id=? ";*/

//        String sql = "select * from item group by item.item_name\n"
//                + "HAVING MIN(ROWID)\n"
//                + "ORDER BY ROWID where ";
        String sql = "select * from (select * from item INNER JOIN item_has_categories on item_has_categories.item_id=item.id_item ) as itemInner where itemInner.category_id  = ? group by itemInner.item_name";

        System.out.println("selectAllItemsByCategory");
        List<MenuItemModel> items = new ArrayList<>();

        try (
                 Connection conn = this.connect(); //Statement stmt = conn.createStatement();  
                  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, categoryId);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                MenuItemModel i = new MenuItemModel(rs.getInt("id_item"), rs.getString("item_name"), null, rs.getString("item_size"), rs.getFloat("price"), rs.getInt("group_id"));
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
                    System.out.println("MEAL MEAL group_id " + rs.getInt("group_id"));
                    MealModel m = new MealModel(rs.getInt("id_item"), rs.getString("item_name"), categories, rs.getString("item_size"), rs.getFloat("price"), rs.getInt("group_id"));
                    return m;

                } else {
                    MenuItemModel i = new MenuItemModel(rs.getInt("id_item"), rs.getString("item_name"), categories, rs.getString("item_size"), rs.getFloat("price"), rs.getInt("group_id"));
                    System.out.println("ITEM group_id" + rs.getInt("group_id"));
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

    public List<MenuItemModel> getDrinksList(String mealSize) {
        String sql = "SELECT item.id_item,item.item_name, item.item_size, item.price, group_id,item_has_categories.category_id,item_has_categories.item_id "
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

                MenuItemModel i = new MenuItemModel(rs.getInt("id_item"), rs.getString("item_name"), null, rs.getString("item_size"), rs.getFloat("price"), rs.getInt("group_id"));
                drinksList.add(i);
                System.out.println(i.getItemName());

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return drinksList;
    }

    public List<MenuItemModel> getSidesList(String mealSize) {
        String sql = "SELECT item.id_item,item.item_name, item.item_size, item.price,item.group_id, item_has_categories.category_id,item_has_categories.item_id "
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

                MenuItemModel i = new MenuItemModel(rs.getInt("id_item"), rs.getString("item_name"), null, rs.getString("item_size"), rs.getFloat("price"), rs.getInt("group_id"));
                sidesList.add(i);
                System.out.println(i.getItemName());

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return sidesList;
    }

    public List<ItemCustomizationModel> getCustomizationOptions() {
        String sql = "SELECT customization_id, customization, price "
                + "FROM "
                + "	item_customisation n;";

        List<ItemCustomizationModel> list = new ArrayList<>();

        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("customization") + "\t"
                        + rs.getDouble("price"));

                String custom = rs.getString("customization");
                float price = rs.getFloat("price");
                int id = rs.getInt("customization_id");

                list.add(new ItemCustomizationModel(id, price, custom));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public int insertOrder() {
        String sql = "INSERT INTO customer_order (is_eat_in, order_status, total) values (?, ?, ?)";
        List<Object[]> orderList = OrderListSingleton.getInstance().getOrderList();

        int ordId = -1;

        try (
                 Connection conn = this.connect(); //Statement stmt = conn.createStatement();  
                  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setBoolean(1, OrderListSingleton.getInstance().getOrderType() == 0);
            pstmt.setString(2, "order_status");
            pstmt.setFloat(3, OrderListSingleton.getInstance().getTotal());

            pstmt.executeUpdate();

            sql = "select last_insert_rowid()";

            Statement sttm = conn.createStatement();

            ResultSet rSet = sttm.executeQuery(sql);

            while (rSet.next()) {
                ordId = rSet.getInt("last_insert_rowid()");
                System.out.println("id " + ordId);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ///////////////////////////////////

        sql = "INSERT INTO order_has_item (order_id, item_id, item_amount) values (?, ?, ?)";
        try (
                 Connection conn = this.connect(); //Statement stmt = conn.createStatement();  
                  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            for (Object[] objects : orderList) {
                if (objects[1] instanceof MealModel) {

                    MealModel i = (MealModel) objects[1];
                    pstmt.setInt(1, ordId);
                    pstmt.setInt(2, i.getItemId());
                    pstmt.setInt(3, (int) objects[0]);

                    pstmt.addBatch();

                    List<MenuItemModel> mAddItem = i.getMealAditionalItems();
                    for (MenuItemModel menuItemModel : mAddItem) {
                        //add Drink and Side incase it is a Meal Order. 
                        pstmt.setInt(1, ordId);
                        pstmt.setInt(2, menuItemModel.getItemId());
                        pstmt.setInt(3, (int) objects[0]);

                        pstmt.addBatch();

                    }
//                    System.out.println(i.getItemName());
//
//                    System.out.println("Its a MealModel");
                } else {
                    MenuItemModel i = (MenuItemModel) objects[1];

                    pstmt.setInt(1, i.getItemId());
                    pstmt.setInt(2, (int) objects[0]);

                    pstmt.addBatch();

                    System.out.println(i.getItemName());
                    System.out.println("Its an Item");

                }

            }

            pstmt.executeBatch();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ordId;

    }

    public List<MenuItemModel> selectItemsByGroupId(int groupId) {
        System.err.println("GROUP ID "+groupId);
        
        
        boolean isMeal = isGroupInMealCategoty(groupId);

        String sql = "SELECT item.id_item,item.item_name, item.item_size, item.price,item.group_id, item_has_categories.item_id ,item_has_categories.category_id "
                + " from item "
                + " INNER JOIN item_has_categories on item_has_categories.item_id=item.id_item where group_id = ?  group by item.item_size order by item_has_categories.category_id";

        List<MenuItemModel> mealAditionalItems = new ArrayList<>();
        try (
                 Connection conn = this.connect(); //Statement stmt = conn.createStatement();  
                  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, groupId);
            System.err.println("GROUP ID "+groupId);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                int itemId = rs.getInt("id_item");
                String itemName = rs.getString("item_name"); 
                String itemSize = (rs.getString("item_size") == null)? "": rs.getString("item_size"); 
                float price = rs.getFloat("price"); 
                int grId= rs.getInt("group_id");
                
                System.err.println(itemId +" "+" "+ itemName);
                
                if(isMeal && (!itemSize.equals(""))){
                    MealModel meal = new MealModel(itemId, itemName, null, itemSize, price, grId);
                    mealAditionalItems.add(meal);
                }
                else{
                    
                    MenuItemModel item = new MenuItemModel(itemId, itemName, null, itemSize, price, groupId);
                    mealAditionalItems.add(item);
                    
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return mealAditionalItems;

    }

    private boolean isGroupInMealCategoty(int groupId) {

        String sql = "SELECT item.id_item,item.item_name, item.item_size, item.price,item.group_id, item_has_categories.item_id ,item_has_categories.category_id "
                + " from item "
                + " INNER JOIN item_has_categories on item_has_categories.item_id=item.id_item where group_id = ?  and category_id=1 ";

        try (
                 Connection conn = this.connect(); //Statement stmt = conn.createStatement();  
                  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, groupId);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                return true;

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

}
