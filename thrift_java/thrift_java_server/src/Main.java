import example.project.Login;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;


public class Main {

    public static void main(String[] args) {
        int i_port = 8080;

        try {
            TServerSocket i_sev_socket = new TServerSocket(i_port);
            TBinaryProtocol.Factory  i_facotry = new TBinaryProtocol.Factory();
            TProcessor i_processor = new  Login.Processor( new User_data_server());

            TThreadPoolServer.Args  para = new TThreadPoolServer.Args(i_sev_socket);
            para.processor(i_processor);
            para.protocolFactory(i_facotry);
            TServer i_server = new TThreadPoolServer( para);


            if (i_server.isServing()){
                System.out.println("server setup .....");
            }

            i_server.serve();








        } catch ( TTransportException e){

            System.out.println(e.toString());
        }







    }
}
