package com.lemonwind.test.model;

/**
 * create by lemonwind on 2018/12/18
 */
public class User {
    private String id;
    private String username;
    private int age;
    private String address;
    private String remark;
    private boolean deletec;
    private long createTime;
    private long updateTime;

    public User() {
    }

    public User(
            String id,
            String username,
            int age,
            String address,
            String remark,
            boolean deletec,
            long createTime,
            long updateTime) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.address = address;
        this.remark = remark;
        this.deletec = deletec;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getRemark() {
        return remark;
    }

    public boolean isDeletec() {
        return deletec;
    }

    public long getCreateTime() {
        return createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setDeletec(boolean deletec) {
        this.deletec = deletec;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", deletec=" + deletec +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
