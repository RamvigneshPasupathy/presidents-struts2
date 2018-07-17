package com.sam.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sam.bean.Country;
import com.sam.dao.CountryDAO;

public class CreateAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private Country country;
	CountryDAO dao = null;
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public String execute() throws Exception {
		dao = new CountryDAO();

		try {
			dao.addCountry(country);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "HOME";
	}

}
