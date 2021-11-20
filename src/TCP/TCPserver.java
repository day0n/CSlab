
package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

    public class TCPserver {

        public void server() throws IOException {
            ServerSocket servers = new ServerSocket(23243);//创建一个服务器tcpsocket对象，并且赋值入本地开放端口
            Socket ss = servers.accept(); //使用accept方法，该方法会使得ss对象编程阻塞线程的状态，并且该方法会返回一个和客户端对象相连接的对象。
            InputStream ser = ss.getInputStream();  //创建输出流
            byte[] buffer = new byte[1000];   //使用字节数组接收输出流的数据
            int n;
            n = ser.read(buffer);
            System.out.println(new String( buffer,0,n)); //把字节数组转换成string输出

            ss.close();
            ser.close();    //关闭相应资源
        }
    public static void main(String[] args) {

        TCPserver s = new TCPserver();
        try {
            s.server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
