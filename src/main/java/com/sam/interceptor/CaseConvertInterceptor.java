package com.sam.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;
import com.sam.bean.Country;

// reference: https://www.javatpoint.com/struts-2-custom-interceptor-example-tutorial
public class CaseConvertInterceptor implements Interceptor {  
	  
	private static final long serialVersionUID = 1L;

	public void init() {}  
    
    public String intercept(ActionInvocation invocation) throws Exception {
		ValueStack stack = invocation.getStack();  
		Country country = (Country) stack.findValue("country");
        country.setName(country.getName().toLowerCase());
        country.setPresident(country.getPresident().toLowerCase());

        stack.setValue("country", country);
        
        return invocation.invoke(); 
	} 
     
    public void destroy() {}
	 
}  
