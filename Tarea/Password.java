import java.util.Random;

public class Password{
    private String value; // Atributo que representa la contraseña

    public Password(int length){ // Constructor con parámetro de longitud de contraseña
        this.value = generarPassword(length);
    }
    public Password(){ // Constructor en caso que la instancia no ingrese longitud
        this.value = generarPassword(8);
    }

    private String generarPassword(int longitud) { // Función para generar contraseña aleatoria
        // Caracteres posibles para la contraseña
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789._";
        // Objeto para generar números aleatorios
        Random random = new Random();
        // StringBuilder para construir la contraseña
        StringBuilder sb = new StringBuilder();
        // Bucle que añade caracteres aleatorios hasta alcanzar la longitud deseada
        for (int i = 0; i < longitud; i++) {

            // Generar un índice aleatorio entre 0 y la longitud de la cadena de caracteres
            int indice = random.nextInt(caracteres.length());
            // Añadir el caracter correspondiente al índice generado al StringBuilder
            sb.append(caracteres.charAt(indice));
        }
        // Devolver el String construido
        return sb.toString();
    }


    public boolean esFuerte(){
        int mayusculas = 0;
        int minusculas = 0;
        int digitos = 0;
        int especiales = 0;

        for(int i = 0; i <= this.value.length(); i++){
            
            

        }

        return mayusculas >= 2 && especiales >= 2 && minusculas >= 2 && digitos >= 2 && this.value.length() >= 8;
    }


    public static void main(String[] args){
        System.out.println("Test");
    }
}