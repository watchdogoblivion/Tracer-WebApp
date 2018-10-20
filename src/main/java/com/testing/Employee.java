package com.testing;

public class Employee {
    protected static String companyName = "hey";
    protected String empName;
    Employee(String ename) {
    empName = ename;
    }
    public static String getcompanyName() {
    return(companyName);
    }
    public String getempName() {
    return empName;
    }
}
