import com.xueJL.UsrMenu.allenterinit;
import com.xueJL.UtilsTool.dbifexits;
import com.xueJL.UtilsTool.renewdatabase;

public class MainEnter {
  public static void main(String[] args) {
    if (dbifexits.adminexist() && dbifexits.userexist()) {
      allenterinit.enterd();
    } else {
      renewdatabase.tryrenew();
      allenterinit.enterd();
    }
  }
}
