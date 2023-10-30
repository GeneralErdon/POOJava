class Autor{
    String nombre, apellido;

    public Autor(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // overriding el toString
    @Override
    public String toString(){
        return this.apellido + ", " + this.nombre;
    }
}

public class Libro {
    String titulo;
    Autor autor;
    int num_ejemplares, num_ejemplares_prestados;

    public Libro(String titulo, Autor autor, int num_ejemplares, int num_ejemplares_prestados){
        this.titulo = titulo;
        this.autor = autor;
        this.num_ejemplares = num_ejemplares;
        this.num_ejemplares_prestados = num_ejemplares_prestados;
    }

    public static void main(String[] args){
        Autor leandro = new Autor("Leandro", "Fermín");
        Libro principito = new Libro("principito", leandro, 10, 5);
        System.out.println();

    }

    
}