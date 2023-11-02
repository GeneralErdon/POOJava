import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import tarea.Empleado;


class MainEmpleado{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MAX_EMPLEADOS = 20;
        Empleado[] empleados;

        System.out.println("Introduce el número total de empleados:");
        int numEmpleados = 0;
        while(true){

            try {
                numEmpleados = scanner.nextInt();
                if (numEmpleados > MAX_EMPLEADOS) {
                    System.out.println("El número máximo de empleados es " + MAX_EMPLEADOS);
                    scanner.reset();
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.nextLine(); // limpia el bbuffer
                continue;
            }
            break;
        }

        empleados = new Empleado[numEmpleados];

        for (int i = 0; i < numEmpleados; i++) {
            scanner.nextLine(); // Limpiar el buffer del scanner
            System.out.println("Introduce los datos del empleado " + (i + 1) + ":");

            Empleado empleado = new Empleado();

            System.out.println("RIF:");
            empleado.setRif(scanner.nextLine());

            System.out.println("Nombre:");
            empleado.setNombre(scanner.nextLine());

            System.out.println("Sueldo base:");
            while(true){
                try {
                    empleado.setSueldoBase(scanner.nextDouble());
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, introduce un número válido.");
                    scanner.nextLine();
                    continue;
                }
                break;
            }

            System.out.println("Horas extra:");
            while(true){
                try {
                    empleado.setHorasExtra(scanner.nextInt());
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, introduce un número válido.");
                    scanner.nextLine();
                    continue;
                }
                break;
            }

            System.out.println("Tipo de IRPF (%):");
            while(true){

                try {
                    empleado.setTipoIRPF(scanner.nextDouble());
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, introduce un número válido.");
                    scanner.nextLine();
                    continue;
                }
                break;
            }

            System.out.println("¿Está casado? (sí/no):");
            String casado = scanner.next();
            empleado.setEsCasado(casado.equalsIgnoreCase("sí"));

            System.out.println("Número de hijos:");
            while (true) {
                try {
                    empleado.setCantidadHijos(scanner.nextInt());
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, introduce un número válido.");
                    scanner.nextLine();
                    continue;
                }
                
                break;
            }

            empleados[i] = empleado;
        }

        System.out.println("Introduce el importe correspondiente al pago por hora extra:");
        while (true) {
            try {
                Empleado.importeHoraExtra = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.nextLine();
                continue;
            }
            break;
        }

        // Aquí puedes llamar a los métodos para mostrar la información requerida...
        Arrays.sort(empleados); // los ordena por salario
        Empleado masCobra = empleados[empleados.length -1];
        Empleado menosCobra = empleados[0];

        // Calcular empleado que cobra más por hora y el que menos
        Arrays.sort(empleados, Comparator.comparingInt(Empleado::getHorasExtra));
        Empleado masCobraHorasExtra = empleados[empleados.length - 1];
        Empleado menosCobraHorasExtra = empleados[0];

        System.out.println("Empleado que más cobra: " + masCobra);
        System.out.println("Empleado que menos cobra: " + menosCobra);
        System.out.println("Empleado que cobra más por horas extra: " + masCobraHorasExtra);
        System.out.println("Empleado que cobra menos por horas extra: " + menosCobraHorasExtra);

        System.out.println("\nEmpleados ordenados por salario:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }

        scanner.close();
    }
}