public class EGrau2 {
    public double a, b, c;

    public EGrau2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double delta(){
        return (b*b) - (4*a*c);
    }

    public double calculaX1(double delta){
        return (-b + Math.sqrt(delta))/(2*a);
    }

    public double calculaX2(double delta){
        return (-b - Math.sqrt(delta))/(2*a);
    }
}
