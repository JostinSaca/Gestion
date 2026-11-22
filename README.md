# Evaluación del Progreso – Programación III
# Sistema de Gestión de Películas

## Objetivo

Desarrollar un sistema visual para administrar una colección de películas utilizando **Java Swing**, **ArrayList**, algoritmos de búsqueda, ordenamiento y métodos recursivos.

El sistema permitirá registrar películas, listarlas, buscarlas, ordenarlas y aplicar operaciones recursivas sobre la colección.

---

## Temas evaluados

- ArrayList
- Búsqueda secuencial
- Búsqueda binaria
- Ordenamiento manual
- Métodos recursivos
- Interfaz gráfica con Java Swing
- Integración entre clases

---

## Restricciones

No está permitido utilizar:

```java
Collections.sort()
Collections.binarySearch()
```

Los algoritmos de búsqueda y ordenamiento deben implementarse manualmente.

La lógica principal del sistema debe estar en la clase:

```java
GestionPeliculas
```

No se debe colocar la lógica de negocio directamente en:

```java
Ventana.java
```

---

# Estructura del proyecto

El proyecto debe contener al menos las siguientes clases:

```text
src/main/java/
├── Pelicula.java
├── GestionPeliculas.java
└── Ventana.java
```

---

# Clase Pelicula

La clase `Pelicula` debe representar una película con los siguientes atributos:

```java
private int codigo;
private String titulo;
private String genero;
private double calificacion;
```

## Requisitos

Implementar:

- Constructor
- Getters y setters
- Método `toString()`

El atributo `codigo` debe ser único.

---

# Clase GestionPeliculas

La clase `GestionPeliculas` debe administrar las películas mediante:

```java
private ArrayList<Pelicula> peliculas;
```

Debe precargar mínimo cinco películas.

Ejemplo:

| Código | Título | Género | Calificación |
|--------|--------|--------|--------------:|
| 101 | Interstellar | Ciencia ficción | 9.5 |
| 102 | Coco | Animación | 8.9 |
| 103 | Titanic | Drama | 8.0 |
| 104 | Inception | Acción | 9.2 |
| 105 | Avatar | Ciencia ficción | 8.7 |

---

# Métodos obligatorios

## 1. Agregar película

```java
boolean agregarPelicula(Pelicula pelicula)
```

Debe agregar una película únicamente si el código no existe previamente.

Requisitos:

- Verificar unicidad del código.
- Utilizar búsqueda secuencial para comprobar si el código ya existe.
- Retornar `true` si la película se agrega correctamente.
- Retornar `false` si el código ya existe.

---

## 2. Buscar por título con búsqueda secuencial

```java
Pelicula buscarPorTituloSecuencial(String titulo)
```

Debe buscar una película por su título utilizando búsqueda secuencial.

Requisitos:

- Comparar los títulos sin importar mayúsculas o minúsculas.
- Retornar la película encontrada.
- Retornar `null` si no existe.

---

## 3. Ordenar por calificación descendente

```java
ArrayList<Pelicula> ordenarPorCalificacionDescendente()
```

Debe ordenar las películas por calificación de mayor a menor.

Requisitos:

- Implementar el algoritmo manualmente.
- Puede utilizar burbuja o inserción directa.
- No usar `Collections.sort()`.

---

## 4. Buscar por código con búsqueda binaria

```java
Pelicula buscarPorCodigoBinario(int codigo)
```

Debe buscar una película por código utilizando búsqueda binaria.

Requisitos:

- Ordenar previamente las películas por código.
- Implementar la búsqueda binaria manualmente.
- Retornar la película encontrada.
- Retornar `null` si no existe.

---

# Métodos recursivos

## 5. Buscar película mejor calificada

```java
Pelicula buscarMejorCalificadaRecursivo(int indice)
```

Debe recorrer recursivamente el `ArrayList` y devolver la película con mayor calificación.

Requisitos:

- No utilizar ciclos.
- Comparar las calificaciones de forma recursiva.
- Retornar la película mejor calificada.

---

## 6. Contar películas por género

```java
int contarPorGeneroRecursivo(String genero, int indice)
```

Debe contar cuántas películas pertenecen a un género específico utilizando recursividad.

Requisitos:

- No utilizar ciclos.
- Comparar el género sin importar mayúsculas o minúsculas.
- Retornar la cantidad encontrada.

Ejemplo:

```text
Género: Ciencia ficción
Cantidad: 2
```

---

## 7. Sumar calificaciones por género

```java
double sumaCalificacionesPorGeneroRecursiva(String genero, int indice)
```

Debe sumar las calificaciones únicamente de las películas que pertenecen al género indicado.

Requisitos:

- No utilizar ciclos.
- Comparar el género sin importar mayúsculas o minúsculas.
- Retornar la suma total de calificaciones del género indicado.

---

# Interfaz gráfica Swing

Implementar la clase:

```java
Ventana.java
```

La interfaz debe utilizar:

```java
JTabbedPane
```

---

## Pestaña 1: Registro

Debe permitir registrar películas mediante los siguientes componentes:

- `JSpinner` para el código
- `JTextField` para el título
- `JComboBox` para el género
- `JTextField` para la calificación
- `JButton` para agregar
- `JList` para mostrar las películas registradas

Funcionalidades:

- Registrar película.
- Validar códigos duplicados.
- Mostrar mensajes de éxito o error.
- Actualizar el listado de películas.

---

## Pestaña 2: Búsquedas y ordenamiento

Debe incluir opciones para:

- Buscar película por título.
- Buscar película por código.
- Ordenar películas por calificación descendente.

Los resultados pueden mostrarse mediante:

- `JList`
- `JOptionPane`
- `JTextArea`

---

## Pestaña 3: Recursividad

Debe incluir opciones para:

- Mostrar la película mejor calificada.
- Contar películas por género.
- Sumar calificaciones por género.

Los resultados deben obtenerse llamando a los métodos de la clase:

```java
GestionPeliculas
```

---

# Requisitos adicionales

1. Realizar pruebas con mínimo cinco películas nuevas.
2. Agregar capturas de funcionamiento dentro del proyecto.
3. Realizar commits descriptivos.
4. Crear el repositorio con el formato:

```text
apellido_apellido_p3
```

5. Subir el código a GitHub.
6. Entregar el enlace del repositorio y el proyecto comprimido.

---

# Criterios de evaluación

## Implementación de métodos – 6 puntos

| Método | Puntaje |
|--------|--------:|
| `agregarPelicula(Pelicula pelicula)` | 1 |
| `buscarPorTituloSecuencial(String titulo)` | 1 |
| `ordenarPorCalificacionDescendente()` | 1 |
| `buscarPorCodigoBinario(int codigo)` | 1 |
| `buscarMejorCalificadaRecursivo(int indice)` | 0.75 |
| `contarPorGeneroRecursivo(String genero, int indice)` | 0.75 |
| `sumaCalificacionesPorGeneroRecursiva(String genero, int indice)` | 0.50 |

Total: **6 puntos**

---

## Interfaz Swing e integración – 4 puntos

| Criterio | Puntaje |
|----------|--------:|
| Uso correcto de `JTabbedPane` 
| Uso de `JList` para mostrar datos 
| Formulario funcional para registrar películas 
| Integración entre `Ventana` y `GestionPeliculas` 

Total: **4 puntos**

---

# Total de la evaluación

| Sección | Puntaje |
|---------|--------:|
| Implementación de métodos | 6 |
| Interfaz Swing e integración | 4 |

Total: **10 puntos**

---

# Entrega

El estudiante debe entregar:

- Enlace del repositorio en GitHub.
- Proyecto comprimido en formato `.zip`.
- Capturas de funcionamiento.
- Evidencia de commits descriptivos.
