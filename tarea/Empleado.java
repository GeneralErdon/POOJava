package tarea;
/*
Crear una clase Empleado que tenga los siguientes atributos privados:
- Rif
- Nombre
- Sueldo base
- Horas extra realizadas en el mes
- Tipo de IRPF (%)
- Casado o no
- Número de hijos.

También debe contar con:
1. Importe de la hora extra. Este será un atributo static o atributo de clase.
2. Los objetos Empleado se podrán crear con un constructor por defecto o con un constructor de un solo parámetro correspondiente al DNI.
3. Además de los métodos getter/setter, la clase empleado tendrá estos métodos:
    - Método para el calculo del complemento correspondiente a las horas extra realizadas.
    - Método para calcular el sueldo bruto (sueldo base + coomplemento por horas extra)
    - Método para calcular las retenciones por IRPF. el porcentaje del IRPF se aplica sobre el sueldo bruto, teniendo en cuenta que el porcentaje que hay que aplicar es el tipo menos 2 puntos si el empleado está casado y menos 1 punto adicional por cada hijo que tenga.

Una vez creada la clase empleado, la utilizaremos en un programa que Lea empleados y los guarde en un Array estático.
El número total de empleados se pide por teclado. el número máximo de empleados es 20.

Después de leer los datos de los empleados se pedirá que se introduzca el importe correspondiente al pago por hora extra asignándoselo al atributo estatico de la clase.

A continuación el programa mostrará por consola:
-   El empleado que más cobra y el que menos.
-   El empleado que cobra más por horas extra y el que menos.
-   Todos los empleados ordenados por salario de menor a mayor.

*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

class DNI {
    private String rif;
    private String nombre;
    private boolean esCasado;

    public DNI(String rif, String nombre, boolean esCasado) {
        this.rif = rif;
        this.nombre = nombre;
        this.esCasado = esCasado;
    }

    public String getRif(){
        return this.rif;
    }
    public void setRif(String rif){
        this.rif = rif;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public boolean getEsCasado(){
        return this.esCasado;
    }



}

public class Empleado implements Comparable<Empleado> {
    private String rif;
    private String nombre;
    private double sueldoBase;
    private double tipoIRPF;
    private int horasExtra; // Horas realizadas en el mes
    private int cantidadHijos;
    private boolean esCasado ;

    public static double importeHoraExtra;

    /**
     * Constructor por defecto de un empleado
     */
    public Empleado() {
    }

    /**
     * Constructor De empleado que utiliza una Clase llamada DNI, que contiene 
     * identificacion, nombre y estado civil
     * @param Dni
     */
    public Empleado(DNI Dni) {
        this.rif = Dni.getRif();
        this.nombre = Dni.getNombre();
        this.esCasado = Dni.getEsCasado();
    }

    /**
     * Método compareTo, que se implementa desde la Clase Comparable.
     * Permite comparar con la Clase actual, para de esta forma
     * poder realizar ordenamientos con instancias de Empleado.
     * @param otroEmpleado
     * @return Valor comparable
     */
    @Override
    public int compareTo(Empleado otroEmpleado){
        // Ordenar por salario (primero salarios luego nombres por si son iguales)
        int comparacionSalario = Double.compare(this.calcularSueldoBruto(), otroEmpleado.calcularSueldoBruto());
        if (comparacionSalario != 0){
            return comparacionSalario;
        }
        return this.nombre.compareTo(otroEmpleado.nombre);
    }

    //! Getters y Setters
    public String getRif() {
        return this.rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBase() {
        return this.sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getTipoIRPF() {
        return this.tipoIRPF;
    }

    public void setTipoIRPF(double tipoIRPF) {
        this.tipoIRPF = tipoIRPF;
    }

    public int getHorasExtra() {
        return this.horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public int getCantidadHijos() {
        return this.cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }

    public boolean getEsCasado() {
        return this.esCasado;
    }

    public void setEsCasado(boolean esCasado) {
        this.esCasado = esCasado;
    }

    // Métodos adicionales

    /**
     * Método para el calculo de complemento de horas extra
     * @return Complemento de horas extra
     */
    public double calculoComplementoHorasExtra(){
        return this.horasExtra * importeHoraExtra;
    }

    /**
     * Método para calcular el sueldo bruto
     * @return
     */
    public double calcularSueldoBruto(){
        return this.sueldoBase + this.calculoComplementoHorasExtra();
    }

    /**
     * Funcion para calcular la retencion del IRPF
     * teniendo en cuenta que si el IRPF está en % como indica el enunciado
     * debe retornar aplicando el tipo aplicable * el sueldo bruto.
     * @return Retención IRPF
     */
    public double calcularRetencionIRPF(){
        double tipoAplicable = this.tipoIRPF;

        if (this.esCasado){
            tipoAplicable -= 2.0;
        }
        tipoAplicable -= this.cantidadHijos;
        return this.calcularSueldoBruto() * tipoAplicable / 100.0;
    }


    /**
     * Método de toString reescrito para poder representar los Empleados
     * con un formato más legible
     */
    @Override
    public String toString(){
        String result;
        String identification = String.format("%s %s \n", this.rif, this.nombre);
        String sueldo = String.format("Sueldo Base: %.2f \n", this.sueldoBase);
        String horasExtra = String.format("Horas extra: %d \n", this.horasExtra);
        String irpf = String.format("Tipo IRPF: %.2f \n", this.tipoIRPF);
        String casado = String.format("Casado: %s \n", (this.esCasado ? "S" : "N"));
        String nhijos = String.format("Número de hijos %d \n", this.cantidadHijos);

        result = identification + sueldo + horasExtra + irpf + casado + nhijos;
        return result;
    }

    /**
     * Método Main, que ejecuta un pequeño programa para poner a prueba el funcionamiento
     * de la Clase Empleado.
     * @param args
     */
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