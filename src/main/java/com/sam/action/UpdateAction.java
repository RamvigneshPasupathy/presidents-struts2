package com.sam.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sam.bean.Country;
import com.sam.dao.CountryDAO;

public class UpdateAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private Country country;
	CountryDAO dao = null;
	int i = 0;
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	// reference: https://dzone.com/tutorials/java/struts-2/struts-2-example/struts-2-validation-example-1.html
	public void validate() {
        if (country.getPresident().trim().length() == 0) {
            addFieldError("country.president", "president name cannot be empty");
        }
    }
	
	@Override
	public String execute() throws Exception {
		dao = new CountryDAO();
		try {
			i = dao.updatePresident(country);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "HOME";
	}

}
