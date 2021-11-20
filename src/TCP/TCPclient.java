package TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

//实现tcp的网络编程
public class TCPclient {
    public void clients(){
        InetAddress hostip = null; //设置host ip存储变量
        try {
             hostip = InetAddress.getByName("127.0.0.1"); //对hostip赋值ip
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        Socket  client = null;  //创建客户端socket对象
        try {
            client = new Socket(hostip,23243);     //设置客户端socket对象ip和端口
            OutputStream os = client.getOutputStream(); //获得一个输入流
            os.write("hello.".getBytes(StandardCharsets.UTF_8));  //向输入流中写入句子
            os.close();      //关闭输出流
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        TCPclient c = new TCPclient();
        c.clients();
    }
}













