package tarea;

public class Fraccion{
    int numerador, denominador;

    /**
     * Constructor de una Fracción, recibe numerador y denominador
     * @param numerador
     * @param denominador
     */
    public Fraccion(int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;
    }
    /**
     * Constructor, asume que si no ingresas denominador, entonces este será 1
     * @param numerador
     */
    public Fraccion(int numerador){
        this.numerador = numerador;
        this.denominador = 1;
    }

    /**
     * Funcion para obtener el resultado de la instancia de Fraccion
     * numerador / denominador
     * @throws ArithmeticException en caso de division entre cero
     * @return double
     */
    public double getResult(){ 
        if(this.denominador == 0){
            throw new ArithmeticException("No se puede dividir entre zero");
        }
        double numerador = this.numerador;
        double denominador = this.denominador;

        double result =  numerador / denominador;
        return result;
    }

    /**
     * Funcion para sumar una Fraccion con otra
     * aplicando metodo de suma con fracciones  
     * @param 
     * @return new Fraccion
     */
    public static Fraccion suma(Fraccion leftFraccion, Fraccion rightFraccion){
        // Funcion para sumarla con otras fraccion
        
        int newNumerador = (leftFraccion.numerador * rightFraccion.denominador) 
                            + (leftFraccion.denominador * rightFraccion.numerador);
        
        int newDenominador = (leftFraccion.denominador * rightFraccion.denominador);
        return new Fraccion(newNumerador, newDenominador);
    }
    /**
     * Funcion para suma ahora recibiendo varios parametros de tipo Fraccion
     * Reutiliza la primera funcion suma donde hace la suma de uno en uno
     * @param otra_fraccion
     * @return Fraccion
     */
    public static Fraccion suma(Fraccion left_fraccion, Fraccion ...otra_fraccion){
        Fraccion result = left_fraccion;
        for(Fraccion frac:otra_fraccion){
            result = Fraccion.suma(result, frac);
        }
        return result;
    }

    /**
     * Funcion para restar una Fraccion con otra
     * aplicando metodo de resta con fracciones  
     * @param 
     * @return new Fraccion
     */
    public static Fraccion resta(Fraccion leftFraccion, Fraccion rightFraccion){
        
        int newNumerador = (leftFraccion.numerador * rightFraccion.denominador) 
                            - (leftFraccion.denominador * rightFraccion.numerador);
        
        int newDenominador = (leftFraccion.denominador * rightFraccion.denominador);
        return new Fraccion(newNumerador, newDenominador);
    }
    /**
     * Funcion para resta ahora recibiendo varios parametros de tipo Fraccion
     * Reutiliza la primera funcion resta donde hace la resta de uno en uno
     * @param otra_fraccion
     * @return Fraccion
     */
    public static Fraccion resta(Fraccion left_fraccion, Fraccion ...otra_fraccion){
        Fraccion result = left_fraccion;
        for(Fraccion frac:otra_fraccion){
            result = Fraccion.resta(result, frac);
        }
        return result;
    }

    /**
     * Funcion para multiplicarr una Fraccion con otra
     * aplicando metodo de multiplicar con fracciones  
     * @param 
     * @return new Fraccion
     */
    public static Fraccion multiplicar(Fraccion leftFraccion, Fraccion rightFraccion){
        
        int newNumerador = (leftFraccion.numerador * rightFraccion.numerador);
        int newDenominador = (leftFraccion.denominador * rightFraccion.denominador);
        return new Fraccion(newNumerador, newDenominador);
    }
    /**
     * Funcion para multiplicar ahora recibiendo varios parametros de tipo Fraccion
     * Reutiliza la primera funcion multiplicar donde hace la multiplicar de uno en uno
     * @param otra_fraccion
     * @return Fraccion
     */
    public static Fraccion multiplicar(Fraccion left_fraccion, Fraccion ...otra_fraccion){
        Fraccion result = left_fraccion;
        for(Fraccion frac:otra_fraccion){
            result = Fraccion.multiplicar(result, frac);
        }
        return result;
    }

    /**
     * Funcion para dividir una Fraccion con otra
     * aplicando metodo de multiplicar con fracciones  
     * @param 
     * @return new Fraccion
     */
    public static Fraccion dividir(Fraccion leftFraccion, Fraccion rightFraccion){
        
        int newNumerador = (leftFraccion.numerador * rightFraccion.denominador);
        int newDenominador = (leftFraccion.denominador * rightFraccion.numerador);
        return new Fraccion(newNumerador, newDenominador);
    }
    /**
     * Funcion para dividir ahora recibiendo varios parametros de tipo Fraccion
     * Reutiliza la primera funcion dividir donde hace la dividir de uno en uno
     * @param otra_fraccion
     * @return Fraccion
     */
    public static Fraccion dividir(Fraccion left_fraccion, Fraccion ...otra_fraccion){
        Fraccion result = left_fraccion;
        for(Fraccion frac:otra_fraccion){
            result = Fraccion.dividir(result, frac);
        }
        return result;
    }


    /**
     * Sobreescribe el método toString para representar
     * las instancias de Fracciones
     * @return String numerador/denominador
     */
    @Override
    public String toString(){
        return this.numerador + "/" + this.denominador;
    }

    /**
     * Pequeño programa para que puedan verificar el funcionamiento de Fracción
     * como ej enunciado del ejercicio no pide especificamente esto.
     * Acá se puede escribir otro Test que se quiera realizar.
     * @param args
     */
    public static void main(String[] args){
        Fraccion f1 = new Fraccion(10, 2);
        Fraccion f2 = new Fraccion(5, 2);
        Fraccion f3 = new Fraccion(6, 1);

        System.out.println("Suma de fracciones: " + f1 +" + " + f2 + " + " + f3);      
        System.out.println(Fraccion.suma(f1, f2, f3));
        System.out.println("Resta de fracciones: " + f1 +" - " + f2 + " - " + f3);
        System.out.println(Fraccion.resta(f1, f2, f3));
        System.out.println("Multiplicacion de fracciones: " + f1 +" * " + f2 + " * " + f3);
        System.out.println(Fraccion.multiplicar(f1, f2, f3));
        System.out.println("division de fracciones: " + f1 +" / " + f2 + " / " + f3);
        System.out.println(Fraccion.dividir(f1, f2, f3));
        
        //System.out.println(f1.suma(f2,f3));



    }
}