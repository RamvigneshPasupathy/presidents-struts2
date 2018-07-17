package com.sam.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sam.dao.CountryDAO;

public class DeleteAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private CountryDAO dao = new CountryDAO();
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		try {
			dao.deleteCountry(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "HOME";
	}

}
