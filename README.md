# 🎮 1ª PRUEBA DE EVALUACIÓN  🧮

## 📋 Resumen del Proyecto
Este repositorio contiene tres prácticas de programación en Java:

1. 🔢 **Aproximación de Pi**: Implementación del método de Montecarlo para aproximar el número π
2. 🦠 **Juego de la Vida**: Simulación del famoso autómata celular de Conway
3. 🗺️ **Búsqueda en Grafos**: Implementación de una estructura de datos de grafo con algoritmo de búsqueda de caminos

## 🚀 Características

### Práctica 1: Aproximación de Pi
- 📊 Método de Montecarlo para aproximar π
- 🎯 Generación aleatoria de puntos en un cuadrado
- 📏 Cálculo preciso basado en proporciones de áreas

### Práctica 2: Juego de la Vida
- 🧫 Implementación completa del autómata celular de Conway
- 📄 Carga de estados iniciales desde archivos
- 🎲 Generación aleatoria de estados iniciales
- 👁️ Visualización de la evolución del sistema

### Práctica 3: Grafo y Búsqueda de Caminos
- 📈 Estructura de datos de grafo con lista de adyacencia
- 🧭 Algoritmo de búsqueda de caminos entre vértices
- 🧪 Desarrollo dirigido por pruebas (TDD)

## 💻 Tecnologías y Herramientas

- ☕ Java
- 🧰 Maven
- 🧪 JUnit
- 📝 Javadoc
- 📊 UML (Umbrello)
- 📁 Git

## 🔧 Instalación y Ejecución

### Requisitos
- Java 8 o superior
- Maven (para la práctica 3)

### Compilación
```bash
# Para las prácticas 1 y 2 (con makefile)
make compile

# Para la práctica 3 (con Maven)
mvn compile
```

### Ejecución
```bash
# Práctica 1: Aproximación de Pi (el parámetro es el número de puntos)
java -cp target/classes aplicacion.Principal 1000000

# Práctica 2: Juego de la Vida
java -cp target/classes Principal

# Práctica 3: Pruebas del grafo
mvn test
```

### Generación de Javadoc
```bash
# Para las prácticas 1 y 2
make javadoc

# Para la práctica 3
mvn javadoc:javadoc
```

## 📊 Análisis de Complejidad

### Práctica 1: Aproximación de Pi
- `generarNumeroPi(long pasos)`: O(n) donde n es el número de pasos

### Práctica 2: Juego de la Vida
- `leerEstadoActual()`: O(n²) donde n es la dimensión del tablero
- `generarEstadoActualPorMontecarlo()`: O(n²)
- `transitarAlEstadoSiguiente()`: O(n²)
- `toString()`: O(n²)

### Práctica 3: Grafo
- `addVertex(V v)`: O(1)
- `addEdge(V v1, V v2)`: O(1)
- `obtainAdjacents(V v)`: O(1)
- `containsVertex(V v)`: O(1)
- `onePath(V v1, V v2)`: O(V + E) donde V es el número de vértices y E es el número de aristas

## 📝 Estructura del Proyecto
````
.
├── 📁 .idea/
├── 📄 .gitignore
├── 📄 misc.xml
├── 📄 modules.xml
├── 📄 uiDesigner.xml
├── 📁 src/
│   ├── 📁 aplicacion/
│   │   └── 📄 Principal.java
│   ├── 📁 dominio/
│   │   └── 📄 Tablero.java
│   ├── 📁 mates/
│   │   └── 📄 Matematicas.java
│   └── 📁 pr2/
│       ├── 📄 Graph.java
│       └── 📄 Principal.java
├── 📄 .gitignore
├── 📄 LICENSE
├── 📄 Primera_Prueba_Evaluacion_Con...
└── 📄 README.md
````

## 🔍 Ejemplos

### Aproximación de Pi
```java
// Ejemplo de salida
El número PI es 3.14159265358979
```

### Juego de la Vida
```
x
x x
xx
```

### Grafo
```java
// Ejemplo de búsqueda de camino
Graph<Integer> g = new Graph<>();
g.addEdge(1, 2);
g.addEdge(1, 5);
g.addEdge(5, 6);
g.addEdge(6, 4);

List<Integer> path = g.onePath(1, 4); // Devuelve [1, 5, 6, 4]
```

## 📜 Licencia
```
Copyright 2025 Mario Blanco Heranz

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## 👨‍💻 Autor

Desarrollado con ❤️ por Mario Blanco Herranz

## 🙏 Agradecimientos
- 👨‍🏫 Al profesor por el material didáctico
- 🌐 A la comunidad de Java por sus recursos
- 🔥 A Conway por inspirar con su Juego de la Vida
