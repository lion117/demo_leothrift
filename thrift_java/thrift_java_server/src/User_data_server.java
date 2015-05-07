import example.project.Login;
import example.project.User_data;

/**
 * Created by LEO on 2015/5/7.
 */
public class User_data_server  implements Login.Iface {

    public String Login_in(User_data t_user) throws org.apache.thrift.TException{

        System.out.println("new client try to connect ");

        String str_return;
        if (t_user.username.compareTo("leo") !=0)
        {
            str_return = "user name error";


        }
        else  if (t_user.password.compareTo("123456") !=0 ){
            str_return= "password error";
        }
        else {
            str_return = "login_successful_!!!!";
        }

        System.out.println(str_return);
        return  str_return;
    }

    public int Query(String t_ID, String t_data) throws org.apache.thrift.TException{

        return  0;
    }

    public int Login_out(String t_ID) throws org.apache.thrift.TException{
        return 0;
    }



}
