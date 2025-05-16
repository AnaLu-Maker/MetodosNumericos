import java.util.Scanner;

public class MetodoBiseccion {

    public static void main(String[] args) {
        System.out.println("Método de Bisección - Inicio");
        System.out.println("La función utilizada será: f(x) = x^2 - 4");

        // Ingresar el intervalo [Xl, Xu]
        Scanner scanner = new Scanner(System.in);
        double Xl, Xu;

        do {
            System.out.print("Ingresa el intervalo inferior (Xl): ");
            Xl = scanner.nextDouble();
            System.out.print("Ingresa el intervalo superior (Xu): ");
            Xu = scanner.nextDouble();

            if (Xl >= Xu) {
                System.out.println("El intervalo inferior debe ser menor que el intervalo superior. Intenta nuevamente.");
            }
        } while (Xl >= Xu);

        double fXl = funcion(Xl);
        double fXu = funcion(Xu);

        System.out.println("f(Xl) = " + fXl);
        System.out.println("f(Xu) = " + fXu);
    }
    
    // Método que representa la función f(x) = x^2 - 4
    public static double funcion(double x) {
        return x * x - 4;
    }
}