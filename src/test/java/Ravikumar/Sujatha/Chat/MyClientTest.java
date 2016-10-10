package Ravikumar.Sujatha.Chat;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by sujatharavikumar on 10/6/16.
 */
public class MyClientTest {

    @Test
    public void unknownHostTest(){
        try{
            Socket socket = new Socket("locahost", 3333);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        }
        catch(UnknownHostException e){
            String message = "Unknown Host";
            System.out.println(message);
            Assert.assertTrue(message.equals("Unknown Host"));
        }
        catch(IOException e){
            String message = "IOException occured";
            System.out.println(message);
        }

    }

    @Test
    public void ioExceptionTest(){
        try{
            Socket socket = new Socket("localhost", 3333);
        }
        catch(IOException e){
            String message = "IOException occured";
            System.out.println(message);
            Assert.assertTrue(message.equals("IOException occured"));

        }
    }


    @Test
    public void bufferedReaderTest(){
        try{
            Socket socket = new Socket("localhost", 3333);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String strToServer = null;
            dataOutputStream.writeUTF(strToServer);
        }
        catch(IOException e){
            String message = "IOException occured";
            System.out.println(message);
            Assert.assertTrue(message.equals("IOException occured"));
        }

    }

    @Test
    public void readUTFTest(){
        try{
            Socket socket = new Socket("localhost", 3333);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String strFromServer = dataInputStream.readUTF();
        }
        catch(IOException e){
            String message = "IOException occured";
            System.out.println(message);
            Assert.assertTrue(message.equals("IOException occured"));
        }
    }

    @Test
    public void flushTest(){
        try{
            Socket socket = new Socket("localhost", 3333);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.close();
            dataOutputStream.flush();
        }
        catch(IOException e){
            String message = "IOException occured";
            System.out.println(message);
            Assert.assertTrue(message.equals("IOException occured"));
        }

    }
}
