package com.xueJL.Entity;

public class ProfileBean {
  private String userid;
  private String username;
  private String useremail;
  private String userphone;
  private String userpassword;
  private String userbalance;
  private String createtime;

  public ProfileBean(
      String userid,
      String username,
      String useremail,
      String userphone,
      String userpassword,
      String userbalance,
      String createtime) {
    this.userid = userid;
    this.username = username;
    this.useremail = useremail;
    this.userphone = userphone;
    this.userpassword = userpassword;
    this.userbalance = userbalance;
    this.createtime = createtime;
  }

  public ProfileBean() {}

  @Override
  public String toString() {
    return "ProfileBean{"
        + "userid='"
        + userid
        + '\''
        + ", username='"
        + username
        + '\''
        + ", useremail='"
        + useremail
        + '\''
        + ", userphone='"
        + userphone
        + '\''
        + ", userpassword='"
        + userpassword
        + '\''
        + ", userbalance='"
        + userbalance
        + '\''
        + ", createtime='"
        + createtime
        + '\''
        + '}';
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUseremail() {
    return useremail;
  }

  public void setUseremail(String useremail) {
    this.useremail = useremail;
  }

  public String getUserphone() {
    return userphone;
  }

  public void setUserphone(String userphone) {
    this.userphone = userphone;
  }

  public String getUserpassword() {
    return userpassword;
  }

  public void setUserpassword(String userpassword) {
    this.userpassword = userpassword;
  }

  public String getUserbalance() {
    return userbalance;
  }

  public void setUserbalance(String userbalance) {
    this.userbalance = userbalance;
  }

  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }
}
