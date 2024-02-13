package co.edu.eam.client;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AppCliente {

    public static void main(String[] args) {

        //Se crea la comunicación con el servidor en el puerto 9999
        try (Socket socket = new Socket("localhost", 9999)){

            //Se imprime un mensaje para saber que la comunicación con el servidor se ha creado
            System.out.println("Se crea la comunicación con el servidor");

            //Se crean los flujos de entrada y salida
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            //Se lee el nombre del cliente y se envía al servidor
            String nombreCliente = JOptionPane.showInputDialog(null, "Escriba su nombre: ");
            oos.writeObject(nombreCliente);

            //Se lee un mensaje del cliente y se envía al servidor
            String mensaje = JOptionPane.showInputDialog(null, "Escriba un mensaje: ");
            oos.writeObject(mensaje);

            //Se imprime el mensaje que envía el servidor
            System.out.println( ois.readObject() );

            //Se cierran los flujos y el socket
            oos.close();
            ois.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
