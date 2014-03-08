package com.ecorecycle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.ecorecycle.vo.*;
import com.ecorecycle.db.DAOException;


public class RecycleManagementDaoImpl implements RecycleManagementDAO {
	// Table ITEM list
	private static final String TABLE_ITEM = "ITEM";
	private static final String TABLE_ITEM_ID = "id";
	private static final String TABLE_ITEM_NAME = "name";
	private static final String TABLE_ITEM_PRICE = "price";
	private static final String TABLE_ITEM_WEIGHT = "weight";
	private static final String TABLE_ITEM_TYPE = "type";
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// Table RCM List
	private static final String TABLE_RCM_MACHINE_ID= "machine_id";
	private static final String TABLE_RCM_GROUP_ID = "group_id";
	private static final String TABLE_RCM_OP_STATUS = "op_status";
	private static final String TABLE_RCM_LOCATION = "location";
	private static final String TABLE_RCM_MAX_CAPACITY = "max_capacity";
	private static final String TABLE_RCM_LAST_ACTIVATED = "time_last_activated";
	private static final String TABLE_RCM_DEFAULT_CASH = "cash_default_amount";
	private static final String TABLE_RCM = "RCM_GROUP";
	
	public static Connection connectDb() {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager
					.getConnection("jdbc:sqlite:/Applications/EcoReCycle/ecorecycle.db");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	


	@Override
	public ItemVO getItem(int itemId) throws DAOException {
		Connection conn = connectDb();
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery("SELECT * FROM " + TABLE_ITEM + " WHERE "
					+ TABLE_ITEM_ID + "=" + itemId + ";");
			ItemVO item = null;
			if (rs.next()) {
				item = new ItemVO();
				item.setItemId(rs.getInt(TABLE_ITEM_ID));
				item.setItemName(rs.getString(TABLE_ITEM_NAME));
				item.setType(rs.getString(TABLE_ITEM_TYPE));
				item.setPrice(rs.getDouble(TABLE_ITEM_PRICE));
				item.setWeight(rs.getDouble(TABLE_ITEM_WEIGHT));
			}
			return item;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}  finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
	}

	@Override
	public List<ItemVO> getAllItems() throws DAOException {
		Connection conn = connectDb();
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery("SELECT * FROM " + TABLE_ITEM + ";");
			List<ItemVO> items = new ArrayList<ItemVO>();
			while (rs.next()) {
				ItemVO item = new ItemVO();
				item.setItemId(rs.getInt(TABLE_ITEM_ID));
				item.setItemName(rs.getString(TABLE_ITEM_NAME));
				item.setType(rs.getString(TABLE_ITEM_TYPE));
				item.setPrice(rs.getDouble(TABLE_ITEM_PRICE));
				item.setWeight(rs.getDouble(TABLE_ITEM_WEIGHT));
				items.add(item);
			}
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
	}

	public int insertItem(ItemVO item) throws DAOException {
		Connection conn = connectDb();
		Statement statement = null;
		try {
			conn.setAutoCommit(false);
			String insertSql = "INSERT INTO " + TABLE_ITEM + " ( " + TABLE_ITEM_ID + ","
					+ TABLE_ITEM_NAME + "," + TABLE_ITEM_TYPE + ","
					+ TABLE_ITEM_PRICE + "," + TABLE_ITEM_WEIGHT + ")" + " VALUES " + " (null,"
					+ "'" + item.getItemName() + "'" + "," + "'" +item.getType() + "'" + ","
					+ item.getPrice() + "," + item.getWeight()
					+ ");";
			statement = conn.createStatement();
			int rowsInserted = statement.executeUpdate(insertSql);
			if (rowsInserted == 1) {
				conn.commit();
			}
			return rowsInserted;
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
	}
	@Override
	public int updateItem(ItemVO item) throws DAOException {
		Connection conn = connectDb();
		PreparedStatement statement = null;
		try {
			conn.setAutoCommit(false);
			statement = conn.prepareStatement("UPDATE " + TABLE_ITEM + " SET "
					+ TABLE_ITEM_NAME + "= ?," + TABLE_ITEM_TYPE + "=?," + TABLE_ITEM_PRICE 
					+ "= ?," + TABLE_ITEM_WEIGHT + "= ? " + " WHERE " + TABLE_ITEM_ID + "= ?");
			
			statement.setString(1, item.getItemName());
			statement.setString(2, item.getType());
			statement.setDouble(3, item.getPrice());
			statement.setDouble(4, item.getWeight());
			statement.setInt(5, item.getItemId());
			int rowsUpdated = statement.executeUpdate();
			conn.commit();
			return rowsUpdated;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		} finally {
			try {

				if (statement != null) {
					statement.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
	}

	
	public int insertRCM(RCMVo rcm) throws DAOException {
		Connection conn = connectDb();
		Statement statement = null;
		try {
			conn.setAutoCommit(false);
			String insertSql = "INSERT INTO " + TABLE_RCM + " ( " + TABLE_RCM_MACHINE_ID + ","
					+ TABLE_RCM_GROUP_ID + "," + TABLE_RCM_OP_STATUS + "," 
					+ TABLE_RCM_LOCATION + "," + TABLE_RCM_MAX_CAPACITY + ","
				    + TABLE_RCM_DEFAULT_CASH + "," + TABLE_RCM_LAST_ACTIVATED +")" + 
					" VALUES " + " (null," + "'" + rcm.getGroupId() + "'" + ",'" + rcm.getOpStatus() + "'"
					+ "," + rcm.getLocation() + "," + rcm.getMaxCapacity() 
					+ "," + rcm.getCashDefaultAmount() + "," + rcm.getTime_last_activated() +");";
			statement = conn.createStatement();
			int rowsInserted = statement.executeUpdate(insertSql);
			if (rowsInserted == 1) {
				conn.commit();
			}
			return rowsInserted;
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
	}




//	public static void main(String[] args) {
//		RecycleManagementDAO itemDao = new RecycleManagementDaoImpl();
//		try {
//			System.out.println(itemDao.getItem(1));
////			ItemVO item = new ItemVO();
////			item.setItemName("quilt");
////			item.setType("cotton");
////			item.setPrice(2.3);
////			item.setWeight(3.2);
////			itemDao.insertItem(item);
//			ItemVO item = itemDao.getItem(5);
//			item.setItemName("bag");
//			itemDao.updateItem(item);
//		//	System.out.println(itemDao.getAllItems());
////			ItemVO item = itemDao.getItem(1);
////			item.setType("plasticanos");
////			item.setRatePerLb(4.2);
////			itemDao.updateItem(item);
//			System.out.println(itemDao.getItem(5));
//		} catch (DAOException e) {
//			e.printStackTrace();
//		}
//	}

}