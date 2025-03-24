import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demande de l'IP serveur à l'utilisateur
        System.out.print("Entrez l'adresse IP du serveur : ");
        String serverIp = scanner.nextLine();

        int port = 5000; // Le port utilisé pour la connexion

        try (
            Socket socket = new Socket(serverIp, port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        ) {
            // Afficher le message de bienvenue du serveur
            String serverMessage = reader.readLine();
            System.out.println(serverMessage);

            String userInput;

            // Boucle pour envoyer des commandes en continu
            while (true) {
                System.out.print("Commande à exécuter (ou 'exit' pour quitter) : ");
                userInput = scanner.nextLine();

                // Envoi de la commande au serveur
                writer.println(userInput);

                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Déconnexion demandée.");
                    break;
                }

                // Lecture de la réponse complète jusqu'à la balise "---END---"
                String responseLine;
                while ((responseLine = reader.readLine()) != null) {
                    if (responseLine.equals("---END---")) {
                        break; // Fin de la réponse, on sort de la boucle de lecture
                    }
                    System.out.println(responseLine); // Affiche chaque ligne de la réponse
                }

                System.out.println("---- Commande terminée ----\n");
            }

            socket.close();
            System.out.println("Déconnecté du serveur.");

        } catch (IOException e) {
            System.out.println("Erreur client : " + e.getMessage());
        }

        scanner.close();
    }
}
