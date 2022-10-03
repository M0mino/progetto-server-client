package it.fi.itsmeucci;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        server serverProva = new server();
        for(;;){
            serverProva.attendi();
            serverProva.comunica();

        }
        

    } 
}
