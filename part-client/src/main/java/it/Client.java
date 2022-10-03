package it;

import java.io.*;
import java.net.*;

public class Client {
    String nomeServer = "localhost";
    int portaServer = 8080;
    Socket miosocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaRicevutaDaSer;
    DataOutputStream outVersoSer;
    BufferedReader inDalSer;
    
    public Socket connetti() {
        System.out.println("client in esecuzione...");
        try{
            tastiera=new BufferedReader(new InputStreamReader(System.in));
            miosocket=new Socket(nomeServer,portaServer);
            outVersoSer=new DataOutputStream(miosocket.getOutputStream());
            inDalSer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
        }catch(UnknownHostException e){
            System.err.println("non funge un cazo");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante connessione");
            System.exit(1);
        }
        return miosocket;
    }

    public void comunica(){
        try{
        System.out.println("scrivi qualocsa di sensato");
        stringaUtente=tastiera.readLine();

        System.out.println("sto inviando la stringa al server");
        outVersoSer.writeBytes(stringaUtente+'\n');

        stringaRicevutaDaSer=inDalSer.readLine();
        System.out.println("risposta:"+'\n'+stringaRicevutaDaSer);
        
        System.out.println("chiusa canale comunicaione");
        miosocket.close();
        }
    
    catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("Errore durante connessione");
        System.exit(1);
    }
}

}
