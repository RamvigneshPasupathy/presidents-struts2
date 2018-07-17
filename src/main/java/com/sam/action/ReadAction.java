package com.sam.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sam.bean.Country;
import com.sam.dao.CountryDAO;

public class ReadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	ResultSet rs = null;
	Country country = null;
	List<Country> countryList = null;
	CountryDAO dao = new CountryDAO();
	private boolean noData = false;

	@Override
	public String execute() throws Exception {
		try {
			countryList = new ArrayList<Country>();
			rs = dao.fetchCountries();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					country = new Country();
					country.setId(rs.getInt("ID"));
					country.setName(rs.getString("NAME"));
					country.setPresident(rs.getString("PRESIDENT"));
					countryList.add(country);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "HOME";
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}
}
