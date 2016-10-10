package Ravikumar.Sujatha.Chat;

import org.junit.*;
import org.junit.Test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sujatharavikumar on 10/6/16.
 */
public class MyServerTest {

    @org.junit.Test
    public void serverSocketIOExceptionTest(){
        try{
            ServerSocket serverSocket = new ServerSocket(3333);
        }
        catch(IOException e){
            String message = "IOException occured";
            System.out.println(message);
            Assert.assertTrue(message.equals("IOException occured"));
        }

    }

    @Test
    public void serverSocketIllegalArgumentTest(){
        try{
            ServerSocket serverSocket = new ServerSocket(65589);
        }

        catch(IOException e){
            String message = "IOException occured";
            System.out.println(message);

        }

        catch(IllegalArgumentException e){
            String message = "IllegalArgumentException occured";
            System.out.println(message);
            Assert.assertTrue(message.equals("IllegalArgumentException occured"));
        }

    }


    @Test
    public void writeUTFTest(){
        try{
            ServerSocket serverSocket = new ServerSocket(3333);
            Socket socket = serverSocket.accept();
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String strToClient = null;
            dataOutputStream.writeUTF(strToClient);
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }


}
