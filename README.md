# Método de Bisección en Java

Este proyecto implementa el **método numérico de bisección** en el lenguaje de programación Java. Es parte de la **Evidencia 3** del curso de **Métodos Numéricos**.

## Descripción del proyecto

El programa permite encontrar una raíz aproximada de la función **f(x) = x³ - 4x + 1** utilizando el **Método de bisección**, el cual consiste en iterar sobre un intervalo `[Xl, Xu]` donde se conoce un cambio de signo en la función, hasta reducir el error relativo porcentual a un valor menor al 3%.

## Método numérico implementado: Bisección

El **Método de bisección** es una técnica para encontrar raíces de funciones continuas en un intervalo cerrado `[a, b]`. Requiere que la función cambie de signo entre `a` y `b`, es decir, `f(a) * f(b) < 0`.

Pasos del algoritmo:
1. Calcular el punto medio `xr = (Xl + Xu) / 2`.
2. Evaluar `f(Xl)`, `f(Xu)`, y `f(Xr)`.
3. Determinar el nuevo intervalo reemplazando `Xl` o `Xu` según el signo del producto `f(Xl)*f(Xr)`.
4. Repetir hasta que el error relativo porcentual sea menor o igual al 3%.

## ▶ Instrucciones de uso
1. Asegúrate de tener Java instalado.
2. Compila el archivo:

   ```bash
   javac MetodoBiseccion.java
