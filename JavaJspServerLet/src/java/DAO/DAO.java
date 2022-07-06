package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connect.ConnectDB;
import Model.Account;
import Model.Category;
import Model.Product;

public class DAO {

    
//        public List<Account> listAccount(){
//            List<Account> list = new ArrayList();
//            Connection conn = null;
//		ResultSet rs = null;
//		PreparedStatement sttm = null;
//	
//		try {
//			String sql = "Select * from Account" ;
//			conn = ConnectDB.getConnection();
//			sttm = conn.prepareStatement(sql);
//			rs = sttm.executeQuery();
//			
//			while(rs.next()) {
//				Account a = new Account();
//                                a.setId(rs.getInt(1));
//                                a.setUser(rs.getString(2));
//                                a.setPass(rs.getString(3));
//                                a.setIsSell(rs.getInt(4));
//                                a.setIsAdmin(rs.getInt(5));
//                                list.add(a);
//			}
//                        return  list;
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally {
//			try {
//				rs.close();
//				//SQL_D.getCon().close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//			
//		}
//		return null;
//            
//        }
    
    
    
        public Account login(String user, String pass){
            Connection conn = null;
		ResultSet rs = null;
		PreparedStatement sttm = null;
	
		try {
			String sql = "Select * from Account where [user] = ? and pass = ?" ;
			conn = ConnectDB.getConnection();
			sttm = conn.prepareStatement(sql);
                        sttm.setString(1, user);
                        sttm.setString(2, pass);
			rs = sttm.executeQuery();
			
			if(rs.next()) {
				Account a = new Account();
                                a.setId(rs.getInt(1));
                                a.setUser(rs.getString(2));
                                a.setPass(rs.getString(3));
                                a.setIsSell(rs.getInt(4));
                                a.setIsAdmin(rs.getInt(5));
                                return a;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rs.close();
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return null;
            
        }
        
        public void signUp(String user, String pass){
            Connection conn = null;
            PreparedStatement sttm = null;
            
            try {
			String sql = "Insert into Account ([user],pass,isSell,isAdmin) values(?,?,0,0)";
			conn = ConnectDB.getConnection();
			sttm = conn.prepareStatement(sql);
                        sttm.setString(1, user);
                        sttm.setString(2, pass);
			sttm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
            
        }
        
        public Account checkAccountExist(String user){
            Connection conn = null;
		ResultSet rs = null;
		PreparedStatement sttm = null;
	
		try {
			String sql = "Select * from product where [user] = ?" ;
			conn = ConnectDB.getConnection();
			sttm = conn.prepareStatement(sql);
                        sttm.setString(1, user);
			rs = sttm.executeQuery();
			
			if(rs.next()) {
				Account a = new Account();
                                a.setId(rs.getInt(1));
                                a.setUser(rs.getString(2));
                                a.setPass(rs.getString(3));
                                a.setIsSell(rs.getInt(4));
                                a.setIsAdmin(rs.getInt(5));
                                return a;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rs.close();
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return null;
            
        }
        
        public void addProduct(String name, String image, String price, String title, String description, String cateID){
            Connection conn = null;
            PreparedStatement sttm = null;
            
            try {
			String sql = "INSERT [dbo].[product] ([name], [image], [price], [title], [description], [cateID]) VALUES(?,?,?,?,?,?)";
			conn = ConnectDB.getConnection();
			sttm = conn.prepareStatement(sql);
                        sttm.setString(1, name);
                        sttm.setString(2, image);
                        sttm.setString(3, price);
                        sttm.setString(4, title);
                        sttm.setString(5, description);
                        sttm.setString(6, cateID);
			sttm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
            
        }
        
        public void editProduct(String id, String name, String image, String price, String title, String description, String cateID){
            Connection conn = null;
            PreparedStatement sttm = null;
            
            try {
			String sql = "Update product set [name] = ?, [image] = ?, [price] = ?, [title] = ?, [description] = ?, [cateID] = ? where id = ?";
			conn = ConnectDB.getConnection();
			sttm = conn.prepareStatement(sql);
                        
                        sttm.setString(1, name);
                        sttm.setString(2, image);
                        sttm.setString(3, price);
                        sttm.setString(4, title);
                        sttm.setString(5, description);
                        sttm.setString(6, cateID);
                        sttm.setString(7, id);
			sttm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
            
        }
        
        
        public void deleteProduct(int id){
            Connection conn = null;
            PreparedStatement sttm = null;
            
            try {
			String sql = "Delete from product where id = ?";
			conn = ConnectDB.getConnection();
			sttm = conn.prepareStatement(sql);
                        sttm.setInt(1, id);
			sttm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
            
        }
        
        
	public List<Product> getAllProducts(){
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement sttm = null;
	
		try {
			String sql = "Select * from product";
			conn = ConnectDB.getConnection();
			sttm = conn.prepareStatement(sql);
			rs = sttm.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setImage(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setTitle(rs.getString(5));
				p.setDescription(rs.getString(6));
				list.add(p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rs.close();
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return list;
	}
        
        public List<Product> getProductsByCID(int cid){
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement sttm = null;
	
		try {
			String sql = "Select * from product where cateID = ?" ;
			conn = ConnectDB.getConnection();
			sttm = conn.prepareStatement(sql);
                        sttm.setInt(1, cid);
			rs = sttm.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setImage(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setTitle(rs.getString(5));
				p.setDescription(rs.getString(6));
				list.add(p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rs.close();
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return list;
	}
        
        public Product getProductByID(int id){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement sttm = null;
	
		try {
			String sql = "Select * from product where id = ?" ;
			conn = ConnectDB.getConnection();
			sttm = conn.prepareStatement(sql);
                        sttm.setInt(1, id);
			rs = sttm.executeQuery();
			
			if(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setImage(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setTitle(rs.getString(5));
				p.setDescription(rs.getString(6));
                                return p;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rs.close();
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return null;
	}
        
        public List<Product> getProductsByName(String name){
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement sttm = null;
	
		try {
			String sql = "Select * from product where name like ?" ;
			conn = ConnectDB.getConnection();
			sttm = conn.prepareStatement(sql);
                        sttm.setString(1, "%"+name+"%");
			rs = sttm.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setImage(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setTitle(rs.getString(5));
				p.setDescription(rs.getString(6));
				list.add(p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rs.close();
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return list;
	}
        
	public Product getLast(){
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement sttm = null;
            try {
                String sql = "select top 1 * from product order by id desc";
                conn = ConnectDB.getConnection();
                sttm = conn.prepareStatement(sql);
		rs = sttm.executeQuery();
                if(rs.next()){
                    Product p = new Product();
                    p.setId(rs.getInt(1));
                    p.setName(rs.getString(2));
                    p.setImage(rs.getString(3));
                    p.setPrice(rs.getDouble(4));
                    p.setTitle(rs.getString(5));
                    p.setDescription(rs.getString(6));
                    return p;
                }
            } catch (Exception e) {
            }
            
            return null;
        }
        public List<Category> getAllCategory(){
		List<Category> list = new ArrayList<>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement sttm = null;
	
		try {
			String sql = "Select * from category";
			conn = ConnectDB.getConnection();
			sttm = conn.prepareStatement(sql);
			rs = sttm.executeQuery();
			
			while(rs.next()) {
				Category c = new Category();
				c.setCid(rs.getInt(1));
                                c.setCname(rs.getString(2));
				list.add(c);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rs.close();
				//SQL_D.getCon().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return list;
	}
        
	public static void main(String[] args) {
//		DAO d = new DAO();
//		List<Account> list = d.listAccount();
//		for(Account p : list) {
//			System.out.println(p);
//		}

//		List<Category> list = d.getAllCategory();
//		for(Category p : list) {
//			System.out.println(p);
//		}
	}
}
