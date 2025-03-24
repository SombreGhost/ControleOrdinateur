import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        int port = 5000; // Port d'écoute
        System.out.println("Serveur en attente de connexions sur le port " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouveau client connecté : " + clientSocket.getInetAddress().getHostAddress());

                // On gère le client dans un thread séparé
                ClientHandler handler = new ClientHandler(clientSocket);
                new Thread(handler).start();
            }

        } catch (IOException e) {
            System.out.println("Erreur du serveur : " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {

    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            writer.println("Bienvenue sur le serveur ! Tapez 'exit' pour quitter.");

            String command;

            while ((command = reader.readLine()) != null) {

                if (command.equalsIgnoreCase("exit")) {
                    writer.println("Déconnexion..."); // réponse au client
                    break; // sort de la boucle -> ferme la connexion proprement
                }

                System.out.println("Commande reçue du client : " + command);

                // Exécution de la commande système
                String result = executeCommand(command);

                // Envoi du résultat au client
                writer.println(result);

                // On envoie une ligne vide pour indiquer que c'est la fin de la réponse
                writer.println("---END---");
            }

            System.out.println("Client déconnecté : " + clientSocket.getInetAddress().getHostAddress());
            clientSocket.close();

        } catch (IOException e) {
            // Gérer une déconnexion brutale ou un client qui ferme mal
            System.out.println("Le client s'est déconnecté : " + e.getMessage());
        }
    }

    private String executeCommand(String command) {
        StringBuilder output = new StringBuilder();

        try {
            ProcessBuilder builder = new ProcessBuilder();

            // Choix du shell en fonction de l'OS
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                builder.command("cmd.exe", "/c", command);
            } else {
                builder.command("bash", "-c", command);
            }

            Process process = builder.start();

            // Lire la sortie standard
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Lire les erreurs
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                output.append("ERR: ").append(line).append("\n");
            }

            int exitCode = process.waitFor();
            output.append("\nProcessus terminé avec le code : ").append(exitCode);

        } catch (IOException | InterruptedException e) {
            output.append("Erreur d'exécution : ").append(e.getMessage());
        }

        return output.toString();
    }
}