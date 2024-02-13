package co.edu.eam.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConexionHilo implements Runnable {

    private final Socket cliente;

    public ConexionHilo(Socket cliente){
        this.cliente = cliente;
    }

    @Override
    public void run() {

        try {

            //Se crean los flujos de entrada y salida
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

            //Se lee el nombre del cliente
            Object nombreCliente = ois.readObject();
            System.out.println("Se ha conectado: "+nombreCliente);

            //Se lee el mensaje del cliente
            Object mensaje = ois.readObject();
            System.out.println(nombreCliente+" dice: "+mensaje);

            //Se le envía un mensaje al cliente
            oos.writeObject("Se ha leído su mensaje!");

            //Se cierran los flujos y el socket
            ois.close();
            oos.close();
            cliente.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
