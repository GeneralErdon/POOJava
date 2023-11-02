import java.util.Scanner;

import tarea.Password;

public class MainPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Password p1;

        System.out.println("¿Desea elegir la longitud de la contraseña? (Y/N)");
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                System.out.println("Ingrese la longitud de la contraseña:");
                while (true) {
                    try {
                        int length = Integer.parseInt(scanner.nextLine().trim());
                        p1 = new Password(length);

                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, ingrese un número válido para la longitud de la contraseña:");
                    } catch (RuntimeException err){
                        System.out.println("La contraseña debe tener 8 o más caracteres");
                    }
                }
                break;
            } else if (input.equals("N")) {
                p1 = new Password();
                break;
            } else {
                System.out.println("Por favor, ingrese Y o N:");
            }
        }

        System.out.println("La contraseña es: " + p1.getPassword());
        System.out.println("La contraseña es fuerte? " + p1.esFuerte());

        System.out.println("¿Desea cambiar la contraseña? (Y/N)");
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                boolean result = p1.modificarContraseña();
                if (result) {
                    System.out.println("La contraseña ha sido modificada exitosamente.");
                    System.out.println("La nueva contraseña es: " + p1.getPassword());
                    System.out.println("La nueva contraseña es fuerte? " + p1.esFuerte());                    
                    System.out.println("Desea cambiarla nuevamente? Y/N");

                } else {
                    System.out.println("La contraseña NO ha sido modificada porque no es fuerte.");
                    System.out.println("Desea cambiarla realmente? Y/N");
                }
            } else if (input.equals("N")) {
                break;
            } else {
                System.out.println("Por favor, ingrese Y o N:");
            }
        }

        scanner.close();
    }
}