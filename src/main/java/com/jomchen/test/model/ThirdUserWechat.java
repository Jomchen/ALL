package com.jomchen.test.model;

/**
 * create by Jomchen on 2018/12/18
 */
public class ThirdUserWechat {
    /**
     *  主键
     */
    private String id;
    /**
     * 用户的微信端身份
     */
    private String openid;
    /**
     *  用户电话
     */
    private String phone;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 是否逻辑删除 0-false:逻辑未删除 1-true:逻辑已删除
     */
    private boolean deletec;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间 yyyyMMddHHmmss
     */
    private long createTime;
    /**
     * 更新时间 yyyyMMddHHmmss
     */
    private long updateTime;

    public ThirdUserWechat() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean getDeletec() {
        return deletec;
    }

    public void setDeletec(boolean deletec) {
        this.deletec = deletec;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ThirdUserWechat{" +
                "id='" + id + '\'' +
                ", openid='" + openid + '\'' +
                ", phone='" + phone + '\'' +
                ", userId='" + userId + '\'' +
                ", deletec=" + deletec +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
