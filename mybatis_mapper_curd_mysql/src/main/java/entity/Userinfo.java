package entity;

import java.util.Date;

public class Userinfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.ID
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.USERNAME
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.PASSWORD
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.AGE
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    private Integer age;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.INSERTDATE
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    private Date insertdate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.ID
     *
     * @return the value of userinfo.ID
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.ID
     *
     * @param id the value for userinfo.ID
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.USERNAME
     *
     * @return the value of userinfo.USERNAME
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.USERNAME
     *
     * @param username the value for userinfo.USERNAME
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.PASSWORD
     *
     * @return the value of userinfo.PASSWORD
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.PASSWORD
     *
     * @param password the value for userinfo.PASSWORD
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.AGE
     *
     * @return the value of userinfo.AGE
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.AGE
     *
     * @param age the value for userinfo.AGE
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.INSERTDATE
     *
     * @return the value of userinfo.INSERTDATE
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    public Date getInsertdate() {
        return insertdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.INSERTDATE
     *
     * @param insertdate the value for userinfo.INSERTDATE
     *
     * @mbggenerated Mon Oct 26 15:28:49 CST 2020
     */
    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }
}