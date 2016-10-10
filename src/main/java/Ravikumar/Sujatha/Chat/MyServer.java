package Ravikumar.Sujatha.Chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sujatharavikumar on 10/2/16.
 */
public class MyServer {

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(3333);
            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String strFromClient = "", strToClient = "";
            while(!(strFromClient.equals("bye"))){
                strFromClient = dataInputStream.readUTF();
                System.out.println("CLIENT: "+strFromClient);
                System.out.print("ME: ");
                strToClient = reader.readLine();
                dataOutputStream.writeUTF(strToClient);
                dataOutputStream.flush();
            }
            dataInputStream.close();
            socket.close();
            serverSocket.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
