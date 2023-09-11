package com.winmar.pojo;

import java.util.Date;

public class User {
    private String id;
    private String UsersName;
    private String pwd;
    private int UserLevel;
    private Date RegistrationDate;
    private Date ValidTo;
    private String Email;

    private boolean valid;//有效期变量
    public boolean isValid(){
        //函数判断当前用户level等级是否有效
        Date date = new Date();
        if((date.getTime()-ValidTo.getTime())<=0){
            this.valid=false;
        }
        return valid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRegistrationDate(Date registrationDate) {
        RegistrationDate = registrationDate;
    }

    public void setValidTo(Date validTo) {
        ValidTo = validTo;
    }

    public String getUsersName() {
        return UsersName;
    }

    public void setUsersName(String usersName) {
        UsersName = usersName;
    }

    public String getUserPassword() {
        return pwd;
    }

    public void setUserPassword(String pwd) {
        this.pwd = pwd;
    }

    public int getUserLevel() {
        return UserLevel;
    }

    public void setUserLevel(int userLevel) {
        UserLevel = userLevel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getRegistrationDate() {
        return RegistrationDate;
    }

    public Date getValidTo() {
        return ValidTo;
    }
    private Integer age;//年龄

    private String userRoleName;    //用户角色名称


    public String getUserRoleName() {
        return userRoleName;
    }
    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }
    public Integer getAge() {
		/*long time = System.currentTimeMillis()-birthday.getTime();
		Integer age = Long.valueOf(time/365/24/60/60/1000).IntegerValue();*/
        Date date = new Date();
        @SuppressWarnings("deprecation")
        Integer age = ValidTo.getDate()-RegistrationDate.getDate();
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UsersList{" +
                "id='" + id + '\'' +
                ", UsersName='" + UsersName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", UserLevel=" + UserLevel +
                ", RegistrationDate='" + RegistrationDate + '\'' +
                ", ValidTo='" + ValidTo + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
