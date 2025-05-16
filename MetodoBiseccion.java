import java.util.Scanner;

public class MetodoBiseccion {
    public static void main(String[] args) {

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("--- MÉTODO DE BISECCIÓN ---");
        // Función a evaluar
        System.out.println("La función a evaluar es: f(x) = x^3 - 4x + 1 ");

        // Ingresar intervalos [Xl, Xu]
        System.out.println("Deberás ingresar los intervalos [Xl, Xu]. \nRecuerda que el intervalo inferior debe ser menor que el intervalo superior.");
        double[] intervalos = ingresarIntervalo();
        double xl = intervalos[0];
        double xu = intervalos[1];

        // Definir xr viejas y nuevas para los margenes de error por iteracion
        double xrViejo = 0;
        double xr = 0;
        double error = 100;
        int iteracion = 0;
    
        do {
        // Mostrar el calculo de las funciones con los intervalos ingresados
        double funcionXl = funcion(xl);
        double funcionXu = funcion(xu);
        System.out.println("\n------- Iteración " + iteracion + " -------");
        System.out.println("Intervalo actual: [" + xl + ", " + xu + "]");
        System.out.println("El valor de f(Xl) es: " + funcionXl);
        System.out.println("El valor de f(Xu) es: " + funcionXu);

        // Mostrar el valor de Xr
        xr = calculoXr(xl, xu);
        double funcionXr = funcion(xr);
        System.out.println("El valor de Xr es: " + xr);
        System.out.println("El valor de f(Xr) es: " + funcionXr);

        double producto;
        // Calcular el error (excepto en la primera iteración)
        if (iteracion == 0) {
            // Calcular el producto de f(Xl) y f(Xu)
            producto = calcularProducto(xl, xu);
            System.out.println("El producto de las funciones f(Xl) * f(Xu) es: " + producto);

            // Función para verificar si el producto es negativo o positivo
            if (producto < 0) {
                System.out.println("Por lo tanto f(Xl) * f(Xu) < 0. Es posible resolver el método de bisección con estos intervalos.");
            }
            else if (producto > 0) {
                System.out.println("ERROR: El producto de f(Xl) * f(Xu) es positivo. No es posible resolver el método de bisección con estos intervalos.");
                return;
            }
            error = 100;

        } else {
            // Imprimir el error relativo porcentual
            error = calcularError(xr, xrViejo);
            System.out.printf("El error relativo porcentual es: %.2f%%\n", error);

            // Calcular el producto de f(Xl) y f(Xr)
            producto = funcionXl * funcionXr;
            System.out.println("El producto de las funciones f(Xl) * f(Xr) es: " + producto);
        }

        // Actualizar los intervalos
            double[] nuevosIntervalos = definirPuntoMedio(xl, xu, producto, xr);
            xl = nuevosIntervalos[0];
            xu = nuevosIntervalos[1];

        xrViejo = xr;
        iteracion++;
        } while (error > 3);

        System.out.printf("\nLa raíz aproximada es: %.6f con un error de: %.2f%%\n", xr, error);
        
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

    // Método para calcular el error relativo porcentual
    public static double calcularError(double xrNuevo, double xrViejo) {
        return Math.abs((xrNuevo - xrViejo) / xrNuevo) * 100;
    }
}