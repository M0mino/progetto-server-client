package it.fi.itsmeucci;

import it.Client;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Client clientProva = new Client();
        clientProva.connetti();
        clientProva.comunica();
    }
}
