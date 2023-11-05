package tarea;

public class Libro {
    String titulo;
    String autor;
    private int num_ejemplares, num_ejemplares_prestados;

    /**
     * Constructor del Libro, Arroja una Excepción si 
     * es mayor el numero de ejemplares prestados que el existente.
     * @param titulo
     * @param autor
     * @param num_ejemplares
     * @param num_ejemplares_prestados
     */
    public Libro(String titulo, String autor, int num_ejemplares, int num_ejemplares_prestados){
        this.titulo = titulo;
        this.autor = autor;

        if (num_ejemplares_prestados > num_ejemplares){
            throw new RuntimeException("No puede iniciar con numeros de ejemplares"+
                " prestados mayor al numero de ejemplares existentes");
        }
        this.num_ejemplares = num_ejemplares;
        this.num_ejemplares_prestados = num_ejemplares_prestados;
    }

    /**
     * getter para saber cuantos ejemplares han sido prestados
     * @return num_ejemplares_prestados
     */
    public int getCantidadPrestados(){
        return this.num_ejemplares_prestados;
    }
    /**
     * getter para obtener la cantidad de ejemplares existentes
     * @return num_ejemplares
     */
    public int getCantidadEjemplares(){
        return this.num_ejemplares;
    }
    /**
     * Setter para añadir ejemplares existentes
     * @param cantidad
     */
    public void addEjemplares(int cantidad){
        this.num_ejemplares += cantidad;
    }
    
    /**
     * Funcion para visualizar cuantos ejemplares quedan en inventario
     * Numero de ejemplares existentes - ejemplares prestados
     * @return num_ejemplares - num_ejemplares_prestados
     */
    public int getInventario(){
        return this.num_ejemplares - this.num_ejemplares_prestados;
    }
    /**
     * Funcion para Prestar un nuevo ejemplar
     * agregando a los ejemplares prestados
     * @throws RuntimeException En caso de querer prestar más de los que existen en inventario
     * @param cantidad
     */
    public void prestarEjemplar(int cantidad){
        if(cantidad > this.getInventario()){
            throw new RuntimeException("No puede prestar más ejemplares de los que existen en inventario");
        }
        this.num_ejemplares_prestados += cantidad;
    }
    /**
     * Funcion para devolver un  ejemplar previamente prestado
     * @throws RuntimeException En caso de querer devolver más de los que ya prestaste
     * @param cantidad
     */
    public void devolverEjemplar(int cantidad){
        if(cantidad > this.num_ejemplares_prestados){
            throw new RuntimeException("No puede devolver más que los ejemplares prestados");
        }
        this.num_ejemplares_prestados -= cantidad;
    }


}