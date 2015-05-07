import example.project.Login;
import example.project.User_data;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import sun.java2d.cmm.kcms.ICC_Transform;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        String str_host = "192.168.15.22";
        int    i_port = 8080;

        TTransport i_transport = null;
        try {
            i_transport = new TSocket(str_host, i_port);
            i_transport.open();
            if (i_transport.isOpen()){
                System.out.println("open socket successfull");
                System.out.println("system info :  IP : "+ str_host +" port : "+ String.valueOf(i_port));
            }
            TProtocol i_protocol = new TBinaryProtocol(i_transport);
            Login.Client i_client = new Login.Client(i_protocol);
            ///////////////////////////////////////////////////////////
            
            User_data i_data = new User_data();
            i_data.username = "leo";
            i_data.password = "123456";

            while (true)
            {
                System.out.print("begin to login server ");
                String session_ID = i_client.Login_in(i_data);
                System.out.println("login result : " + session_ID);

//                try{
//                    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
//                    String s = bufferRead.readLine();
//                    System.out.println(s);
//                } catch(IOException e)
//                {
//                    e.printStackTrace();
//                }

                i_client.Query(session_ID , "hello world");
                i_client.Login_out(session_ID);
            }

            ///////////////////////////////////////////////////////////

        } catch (TTransportException e){
            System.out.println(e.toString());
        } catch (TException  e) {
            e.printStackTrace();
        }

        i_transport.close();
        System.out.println("socket close");


    }
}
