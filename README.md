# Calculadora Básica

Proyecto de andamiaje para la introducción a las **pruebas automáticas con JUnit** en IntelliJ IDEA.

El código es deliberadamente sencillo: no hay interfaz gráfica, no hay persistencia, no hay dependencias externas. El objetivo no es la calculadora en sí, sino disponer de un dominio lo suficientemente claro y acotado como para que el alumno pueda centrarse en aprender a escribir, organizar y ejecutar tests sin distracciones.

---

## Descripción del dominio

La clase `Calculadora` modela el comportamiento de una **calculadora clásica de memoria secuencial**: el usuario introduce un número, elige una operación, introduce un segundo número y obtiene un resultado que queda almacenado en la memoria interna de la calculadora —el equivalente al display físico de una calculadora de bolsillo.

El ciclo básico de uso es:

```
ingresarNumero(a)          → el número queda en memoria (display)
seleccionarOperacion(op)   → se guarda el primer operando y la operación pendiente
ingresarNumero(b)          → se introduce el segundo operando
calcular()                 → se ejecuta la operación; el resultado queda en memoria
getMemoria()               → devuelve el valor actual del display
```

La calculadora soporta las cuatro operaciones aritméticas básicas (suma, resta, multiplicación y división), así como operaciones auxiliares: valor absoluto, comprobación de paridad y redondeo por defecto.

---

## Propósito didáctico

Este proyecto sirve como punto de partida para explicar:

- Cómo configurar JUnit en un proyecto Gradle dentro de IntelliJ IDEA.
- La estructura de una clase de test: `@Test`, `@BeforeEach`, aserciones con `assertEquals`, `assertTrue`, etc.
- Cómo testear objetos con **estado interno** (la memoria de la calculadora), es decir, verificar el comportamiento de una secuencia de llamadas a métodos, no solo el resultado de una llamada aislada.
- Casos límite: división entre cero, números negativos, operaciones encadenadas.

---

## Tecnologías

- Java 17+
- Gradle (Kotlin DSL)
- JUnit 5

---

## Licencia

[MIT](LICENSE)
