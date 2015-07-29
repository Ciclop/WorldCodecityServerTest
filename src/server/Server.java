package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.terasology.codecity.world.structure.CodeRepresentation;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Server Simulator:");
        ObjectOutputStream a = (new ObjectOutputStream(System.out));
        CodeRepresentation result = loadCodeRepresentationFromSocket();
        a.writeObject(result);
    }

    private static CodeRepresentation loadCodeRepresentationFromSocket() throws IOException {
        int portNumber = 25778;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
            return getCodeRepresentation(serverSocket);
        } catch (ClassNotFoundException e) {
            System.out.println("Error decodificando clase");
            return null;
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) { }
        }
    }

    private static CodeRepresentation getCodeRepresentation(ServerSocket serverSocket) throws IOException, ClassNotFoundException {
        Socket clientSocket = serverSocket.accept();
        ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
        return (CodeRepresentation)input.readObject();
    }

}
