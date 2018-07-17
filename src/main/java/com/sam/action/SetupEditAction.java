package com.sam.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;
import com.sam.bean.Country;
import com.sam.dao.CountryDAO;

public class SetupEditAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String name;
	private Country country;
	CountryDAO dao = null;
	int i = 0;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		try {
			dao = new CountryDAO();
			country = new Country();
			ResultSet rs = dao.fetchCountry(name.trim());
			if (rs != null) {
				while (rs.next()) {
					country.setId(rs.getInt("ID"));
					country.setName(rs.getString("NAME"));
					country.setPresident(rs.getString("PRESIDENT"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SETUPEDIT";
	}

}
