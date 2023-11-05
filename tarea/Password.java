package tarea;
/*
Crear una clase Password que tenga como atributo un String que representa una contraseña

La clase password contendrá los sigueintes constructores:

1. Constructor por defecto que genera una contraseña de longitud 8.
2. Constructor con un parametro de tipo int. este parámetro indica la longitud de la contraseña que se va a crear.
3. Las contraseñas en ambos casos se generan al azar y contendrán letras mayúsculas, minúsculas, dígitos y los caracteres "."(punto) y "_" (Guion bajo).
4. La longitud es como mínimo de 8 caracteres.
5. Contiene como mínimo dos letras mayúsculas, dos letras minúsculas, un digito y al menos un punto o guion bajo.
6. Tendrá un método llamado esFuerte() que devuelve un boolean indicando si la contraseña es fuerte o no.
7. La clase tgendrá un método modificarContraseña() para cambiar una contraseña ya existente, pide por teclado un String que contenga una nueva contraseña
Si la contraseña introducida es fuerte, se modifica la contraseña actual. si no es fuerte entonces deja la contraseña sin modificar. el Método devuelve True si se ha modificado y False de lo contrario.
8. el valor de la contraseña solo se podrá modificar mediante modificarContraseña().
9. una vez creada la clase Password escribe un programa para probar el funcionamiento de la clase.

 */
import java.util.Random;
import java.util.Scanner;

public class Password{
    private String password;

    // Constructores de la clase
    public Password(){
        this.password = generatePassword(8);
    }
    public Password(int length){
        if(length >= 8){
            this.password = generatePassword(length);
        }else{
            throw new RuntimeException("La contraseña debe tener 8 digitos");
        }
    }

    /**
     * Método para generación aleatoria de Contraseña.
     * Se asegura que la contraseña siempre tenga por lo menos
     * 2 mayusculas, 2 minusculas, 1 digito y 1 caracter especial
     *  
     * @param length
     * @return Contraseña aleatoria
     */
    private String generatePassword(int length){
        String mayusChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusChars = mayusChars.toLowerCase();
        String digits = "0123456789";
        String specials = "._";

        
        StringBuilder password = new StringBuilder();
        Random rnd = new Random();

        // Append de mayusculas (2)
        password.append(mayusChars.charAt(rnd.nextInt(mayusChars.length())));
        password.append(mayusChars.charAt(rnd.nextInt(mayusChars.length())));
        // append de minusculas (2)
        password.append(minusChars.charAt(rnd.nextInt(minusChars.length())));
        password.append(minusChars.charAt(rnd.nextInt(minusChars.length())));
        // append de digito (1)
        password.append(digits.charAt(rnd.nextInt(digits.length())));
        // append especiales (1)
        password.append(specials.charAt(rnd.nextInt(specials.length())));


        String chars = mayusChars + minusChars + digits + specials;
        // Completa la longitud de la contraseña
        while (password.length() < length) { 
            int index = (int) (rnd.nextFloat() * chars.length());
            password.append(chars.charAt(index));
        }
        // Sorting de toda la contraseña para que no empiece siempre con mayusculas y hacerla más aleatoria
        return password.toString().chars().mapToObj(c -> (char) c) // convierte a cadena de Chars
                .sorted((o1, o2) -> rnd.nextBoolean() ? -1 : 1) // ordena de forma aleatoria
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append) // Recolecta los caracteres del flujo en un nuevo Stringbuilder, añadiendo cada caracter el final
                .toString(); // Lo vuelve a convertir a String
    }

    /**
     * método que verifica si la contraseña actual es fuerte
     * basandose en los criterios de mayusculas, minusculas, digito y caracter especial
     * @return
     */
    public boolean esFuerte() {
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;

        for (char c : this.password.toCharArray()) {
            if (Character.isUpperCase(c)) upperCaseCount++;
            if (Character.isLowerCase(c)) lowerCaseCount++;
            if (Character.isDigit(c)) digitCount++;
            if (c == '.' || c == '_') specialCharCount++;
        }

        return upperCaseCount >= 2 && lowerCaseCount >= 2 && digitCount >= 1 && specialCharCount >= 1 && this.password.length() >= 8;
    }

    public String getPassword(){
        return this.password;
    }

    /**
     * Método para modificar la contraseña
     * Si no es fuerte la nueva contraseña, no la modifica
     * @return True si la modificó, False caso contrario
     */
    public boolean modificarContraseña(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una nueva contraseña: ");
        String newPassword = scanner.nextLine();

        Password tempPassword = new Password();
        tempPassword.password = newPassword;

        //scan.close();
        if (tempPassword.esFuerte()){
            this.password = newPassword;
            return true;
        }
        return false;

    }
    
    /**
     * Método Estático de Main, si se ejecuta esta clase de Java
     * entonces se ejecutará la siguiente prueba de que funciona la clase Password.
     * @param args
     */
    public static void main(String[] args){
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