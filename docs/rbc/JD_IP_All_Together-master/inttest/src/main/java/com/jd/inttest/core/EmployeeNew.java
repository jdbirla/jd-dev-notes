package com.jd.inttest.core;

public class EmployeeNew {

    private String empName;
    private String empDaprtName;

    public EmployeeNew(String empName, String empDaprtName) {
        this.empName = empName;
        this.empDaprtName = empDaprtName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDaprtName() {
        return empDaprtName;
    }

    public void setEmpDaprtName(String empDaprtName) {
        this.empDaprtName = empDaprtName;
    }

    @Override
    public String toString() {
        return "EmployeeNew{" +
                "empName='" + empName + '\'' +
                ", empDaprtName='" + empDaprtName + '\'' +
                '}';
    }
}
