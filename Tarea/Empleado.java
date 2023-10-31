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
    public String getNombre(){
        return this.nombre;
    }
    public boolean getEsCasado(){
        return this.esCasado;
    }



}

public class Empleado {
    private String rif;
    private String nombre;
    private double sueldoBase;
    private double tipoIRPF;
    private int horasExtra; // Horas realizadas en el mes
    private int cantidadHijos;
    private boolean esCasado ;
    static int importeHoraExtra;

    public Empleado(String rif, String nombre, double sueldoBase, double tipoIRPF, int horasExtra, int cantidadHijos, boolean esCasado) {
        this.rif = rif;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.tipoIRPF = tipoIRPF;
        this.horasExtra = horasExtra;
        this.cantidadHijos = cantidadHijos;
        this.esCasado = esCasado;
        
    }

    public Empleado(DNI Dni) {
        this.rif = Dni.getRif();
        this.nombre = Dni.getNombre();
        this.esCasado = Dni.getEsCasado();

    }

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

    public static void main(String[] args) {
        Empleado emp = new Empleado(new DNI("29635222", "Leandro", false));
        System.out.println(emp);
    }

}