package com.pbcbz.shop.entities;

import lombok.*;

import javax.persistence.*;

/**
 * 使用逆向工程生成实体类后会报错，因为@Table、@Id、@Column等注解使用的是jpa
 * 因此还要在pom中引入mapper依赖，该依赖与MGB插件依赖不是一码事
 * MGB不会生成构造器和toString
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tabple_emp")
public class Employee {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_salary")
    private Double empSalary;

    @Column(name = "emp_age")
    private Integer empAge;

    /**
     * @return emp_id
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * @param empId
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * @return emp_name
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return emp_salary
     */
    public Double getEmpSalary() {
        return empSalary;
    }

    /**
     * @param empSalary
     */
    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    /**
     * @return emp_age
     */
    public Integer getEmpAge() {
        return empAge;
    }

    /**
     * @param empAge
     */
    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }
}