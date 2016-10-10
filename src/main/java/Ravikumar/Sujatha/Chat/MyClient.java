package Ravikumar.Sujatha.Chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by sujatharavikumar on 10/2/16.
 */
public class MyClient {

    public static void main(String[] args) {
        try{

            Socket socket = new Socket("localhost", 3333);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String strToServer = "", strFromServer = "";
            while(!(strToServer.equals("bye"))){
                System.out.print("ME: ");
                strToServer = reader.readLine();
                dataOutputStream.writeUTF(strToServer);
                dataOutputStream.flush();
                strFromServer = dataInputStream.readUTF();
                System.out.println("SERVER: "+strFromServer);
            }
            dataOutputStream.close();
            socket.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
