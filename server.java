package it.fi.itsmeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server extends Thread{

    ServerSocket server =null;
    Socket client =null;
    String StringaRicevuta =null;
    String StringMandata = null;
    BufferedReader input;
    DataOutputStream output;


    public server(Socket socket) {
        client= socket;
    }

    public void run(){
        try{
            comunica();
        }
        catch(Exception e){
            e.printStackTrace(System.out);
        }
    }

    public void comunica(){
        inDalClinet = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    

}