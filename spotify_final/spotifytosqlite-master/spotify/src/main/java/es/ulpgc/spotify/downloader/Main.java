package es.ulpgc.spotify.downloader;
import es.ulpgc.spotify.downloader.controller.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
public static void main(String[] args) throws Exception {
        Map<String, String> artists = new HashMap<>();
        artists.put("52iwsT98xCoGgiGntTiR7K", "Quevedo");
        artists.put("2T3D6kBjXg7ofm7GXBaDQU", "Dudi");
        artists.put("4x3Vb1a9yggcqEuRljiLeB", "El vega");
        artists.put("5M9Bb4adKAgrOFOhc05Y50", "Pablo Alborán");
        artists.put("1nwjHzOUQZsNYX8xoWiGVC", "Funzo");
        while (true) {
            System.out.println("SPOTIFY DATABASE");
            System.out.println("Introduce:");
            System.out.println("1: Si quieres añadir un artista específico a la lista.");
            System.out.println("2: Si quieres introducir los artistas ya definidos.");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            if (num == 1) {
                System.out.println("Introduce el id del artista deseado:");
                String id = scanner.next();
                artists.put(id, "");
            }
            if (num == 2) {
                break;
            }
        }
            Controller controller = new Controller();
            controller.control(artists);

    }
}
