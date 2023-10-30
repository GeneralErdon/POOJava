public class Fraccion{
    int numerador, denominador;
    double result;
    
    public Fraccion(int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;
    }


    @Override
    public String toString(){
        return this.numerador + "/" + this.denominador;
    }
}