package com.sam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sam.bean.Country;

public class CountryDAO {

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int addCountry(Country country) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO COUNTRY (name , president) VALUES (?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, country.getName());
			ps.setString(2, country.getPresident());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public ResultSet fetchCountries() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM COUNTRY";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public ResultSet fetchCountry(String name) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM COUNTRY WHERE NAME=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public int updatePresident(Country country) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE COUNTRY SET PRESIDENT=? WHERE NAME=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(2, country.getName());
			ps.setString(1, country.getPresident());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public int deleteCountry(String name) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM COUNTRY WHERE NAME=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, name);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

}