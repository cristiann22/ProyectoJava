import java.util.ArrayList;
import java.util.Scanner;

public class Spotify {
    private static ArrayList<Cancion> biblioteca;

    public static void main(String[] args) {
        biblioteca = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarCancion(scanner);
                    break;
                case 2:
                    buscarCancion(scanner);
                    break;
                case 3:
                    mostrarCanciones();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("=== Menú de Spotify ===");
        System.out.println("1. Agregar Canción");
        System.out.println("2. Buscar Canción");
        System.out.println("3. Mostrar Canciones");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void agregarCancion(Scanner scanner) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.print("Álbum: ");
        String album = scanner.nextLine();
        System.out.print("Duración (segundos): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        Cancion cancion = new Cancion(titulo, artista, album, duracion);
        biblioteca.add(cancion);

        System.out.println("Canción agregada con éxito!");
    }

    private static void buscarCancion(Scanner scanner) {
        System.out.print("Título de la canción a buscar: ");
        String titulo = scanner.nextLine();
        boolean encontrada = false;

        for (Cancion cancion : biblioteca) {
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(cancion);
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Canción no encontrada.");
        }
    }

    private static void mostrarCanciones() {
        if (biblioteca.isEmpty()) {
            System.out.println("No hay canciones en la biblioteca.");
        } else {
            for (Cancion cancion : biblioteca) {
                System.out.println(cancion);
            }
        }
    }
}
