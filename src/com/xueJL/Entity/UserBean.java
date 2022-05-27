package com.xueJL.Entity;

public class UserBean {
  int usrId;
  String usrName;
  String usrEmail;
  String usrPhone;
  String usrBalance;
  String usrPassword;

  public UserBean() {}

  public UserBean(
      int usrId,
      String usrName,
      String usrEmail,
      String usrPhone,
      String usrBalance,
      String usrPassword) {
    this.usrId = usrId;
    this.usrName = usrName;
    this.usrEmail = usrEmail;
    this.usrPhone = usrPhone;
    this.usrBalance = usrBalance;
    this.usrPassword = usrPassword;
  }

  public int getUsrId() {
    return usrId;
  }

  public void setUsrId(int usrId) {
    this.usrId = usrId;
  }

  public String getUsrName() {
    return usrName;
  }

  public void setUsrName(String usrName) {
    this.usrName = usrName;
  }

  public String getUsrEmail() {
    return usrEmail;
  }

  public void setUsrEmail(String usrEmail) {
    this.usrEmail = usrEmail;
  }

  public String getUsrPhone() {
    return usrPhone;
  }

  public void setUsrPhone(String usrPhone) {
    this.usrPhone = usrPhone;
  }

  public String getUsrBalance() {
    return usrBalance;
  }

  public void setUsrBalance(String usrBalance) {
    this.usrBalance = usrBalance;
  }

  public String getUsrPassword() {
    return usrPassword;
  }

  public void setUsrPassword(String usrPassword) {
    this.usrPassword = usrPassword;
  }

  @Override
  public String toString() {
    return "UserBean{"
        + "usrId="
        + usrId
        + ", usrName='"
        + usrName
        + '\''
        + ", usrEmail='"
        + usrEmail
        + '\''
        + ", usrPhone='"
        + usrPhone
        + '\''
        + ", usrBalance='"
        + usrBalance
        + '\''
        + '}';
  }

  //    public usrdata() {
  //    }
  //
  //    @Override
  //    public String toString() {
  //        return "usrdata{" +
  //                "usrId=" + usrId +
  //                ", usrName='" + usrName + '\'' +
  //                ", usrEmail='" + usrEmail + '\'' +
  //                ", usrPhone=" + usrPhone +
  //                '}';
  //    }
  //
  //    public int getUsrId() {
  //        return usrId;
  //    }
  //
  //    public void setUsrId(int usrId) {
  //        this.usrId = usrId;
  //    }
  //
  //    public String getUsrName() {
  //        return usrName;
  //    }
  //
  //    public void setUsrName(String usrName) {
  //        this.usrName = usrName;
  //    }
  //
  //    public String getUsrEmail() {
  //        return usrEmail;
  //    }
  //
  //    public void setUsrEmail(String usrEmail) {
  //        this.usrEmail = usrEmail;
  //    }
  //
  //    public String getUsrPhone() {
  //        return usrPhone;
  //    }
  //
  //    public void setUsrPhone(String usrPhone) {
  //        this.usrPhone = usrPhone;
  //    }
  //
  //    public usrdata(int usrId, String usrName, String usrEmail, String usrPhone) {
  //        this.usrId = usrId;
  //        this.usrName = usrName;
  //        this.usrEmail = usrEmail;
  //        this.usrPhone = usrPhone;
  //    }
}
