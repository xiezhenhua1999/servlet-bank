package com.xueJL.Entity;

public class MenuBean {
  private Integer userId;
  private String userName;
  private Integer userBalance;
  private String createTime;

  public MenuBean(Integer userId, String userName, Integer userBalance, String createTime) {
    this.userId = userId;
    this.userName = userName;
    this.userBalance = userBalance;
    this.createTime = createTime;
  }

  public MenuBean() {}

  @Override
  public String toString() {
    return "MenuBean{"
        + "userId="
        + userId
        + ", userName='"
        + userName
        + '\''
        + ", userBalance="
        + userBalance
        + ", createTime='"
        + createTime
        + '\''
        + '}';
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getUserBalance() {
    return userBalance;
  }

  public void setUserBalance(Integer userBalance) {
    this.userBalance = userBalance;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }
}
