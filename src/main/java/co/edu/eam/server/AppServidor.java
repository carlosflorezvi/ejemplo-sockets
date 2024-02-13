package co.edu.eam.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class AppServidor {

    public static void main(String[] args) {

        //Se crea un servidor que escucha en el puerto 9999
        try(ServerSocket servidor = new ServerSocket(9999)) {

            //Se imprime un mensaje para saber que el servidor está en ejecución
            System.out.println("El servidor está en ejecución");

            //Se crea un ciclo infinito para que el servidor siempre esté escuchando
            while (true) {

                //Se acepta la conexión de un cliente
                Socket cliente = servidor.accept();

                //Se imprime un mensaje para saber que un cliente se ha conectado
                System.out.println("Se ha conectado un cliente");

                //Se crea un hilo para manejar la conexión con el cliente
                new Thread( new ConexionHilo(cliente) ).start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
