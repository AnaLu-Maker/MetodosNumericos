import java.util.Scanner;

public class MetodoBiseccion {
    public static void main(String[] args) {

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("MÉTODO DE BISECCIÓN");
        // Función a evaluar
        System.out.println("La función a evaluar es: f(x) = x^3 - 4x + 1 ");

        // Ingresar intervalos [Xl, Xu]
        System.out.println("Deberás ingresar los intervalos [Xl, Xu]. \nRecuerda que el intervalo inferior debe ser menor que el intervalo superior.");
        double[] intervalos = ingresarIntervalo();
        double xl = intervalos[0];
        double xu = intervalos[1];

        // Mostrar el calculo de las funciones con los intervalos ingresados
        double funcionXl = funcion(xl);
        double funcionXu = funcion(xu);

        System.out.println("El valor de f(Xl) es: " + funcionXl);
        System.out.println("El valor de f(Xu) es: " + funcionXu);

        double xr = calculoXr(xl, xu);

        double producto = calcularProducto(xl, xu);
        System.out.println("El valor de f(Xl) * f(Xu) es: " + producto);
        System.out.println("El valor de Xr es: " + xr);

        double[] nuevosIntervalos = definirPuntoMedio(xl, xu, producto, xr);
        System.out.println("Nuevo Xl: " + nuevosIntervalos[0]);
        System.out.println("Nuevo Xu: " + nuevosIntervalos[1]);
        
        scanner.close();
    }

    // Método que representa la funcion f(x) = x^3 - 4x +1
    public static double funcion(double x) {
        return Math.pow(x, 3) - 4 * x + 1;
    } 

    // Metodo para ingresar el intervalo [Xl, Xu]
    public static double[] ingresarIntervalo() {
        Scanner scanner = new Scanner(System.in);

        // Ingresa el intervalo inferior (Xl)
        System.out.print("Ingresa el intervalo inferior (Xl): ");
        double Xl = scanner.nextDouble();

        // Ingresa el intervalo superior (Xu)
        System.out.print("Ingresa el intervalo superior (Xu): ");
        double Xu = scanner.nextDouble();

        // Verifica que el intervalo inferior sea menor que el intervalo superior
        if (Xl >= Xu) {
            System.out.println("El intervalo inferior debe ser menor que el intervalo superior. Intenta nuevamente.");
            return ingresarIntervalo(); // Llama al método recursivamente para volver a ingresar el intervalo
        }
        
        scanner.close();
        return new double[]{Xl, Xu};
    }

    // Método para calcular Xr (punto medio)
    public static double calculoXr(double Xl, double Xu) {
        return (Xl + Xu) / 2.0;
    }

    // Método para calcular el producto de f(Xl) y f(Xu)
    public static double calcularProducto(double Xl, double Xu) {
        return funcion(Xl) * funcion(Xu);
    }

    // Método para definir si el punto medio se vuelve Xl o Xu
    public static double[] definirPuntoMedio(double Xl, double Xu, double producto, double Xr) {
        if (producto < 0) {
            System.out.println("El producto de f(Xr) es negativo, se actualiza el intervalo superior (Xu) = " + Xu + " -> " + Xr);
            Xu = Xr;
        } else if (producto > 0) {
            System.out.println("El producto de f(Xr) es positivo, se actualiza el intervalo inferior (Xl) = " + Xl + " -> " + Xr);
            Xl = Xr;
        } 
        return new double[]{Xl, Xu};
    }
}