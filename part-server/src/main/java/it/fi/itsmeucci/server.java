package it.fi.itsmeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server{


    ServerSocket server=null;
    Socket client=null;
    String stringa_ricevuta=null;
    String stringa_modificata=null;
    BufferedReader inDalClinet;
    DataOutputStream outDalClient;

    public server() {
        try{
            server = new ServerSocket(8080);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("errore fatale nel server3");
            System.exit(1);
        }
    }



    public Socket attendi(){
        try{
            System.out.println("server in esecuzione");
                

            client = server.accept();

            inDalClinet = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outDalClient = new DataOutputStream(client.getOutputStream());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("errore fatale nel server1");
            System.exit(1);
        }
        return client;
    }



    public void comunica(){
        try{
            System.out.println("benvenuto, scrivi una frase ");
            stringa_ricevuta = inDalClinet.readLine();
            System.out.println("il server ha ricevuto questa stringa"+stringa_ricevuta);

            stringa_modificata=stringa_ricevuta.toUpperCase();
            System.out.println("risposta dal server al clint...");
            outDalClient.writeBytes(stringa_modificata +'\n');

            System.out.println("fine elaborazione... ad victoriam");
            client.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("errore fatale nel server2");
            System.exit(1);
        }

    }

}