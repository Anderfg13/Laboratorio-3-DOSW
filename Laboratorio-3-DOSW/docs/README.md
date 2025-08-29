# PREGUNTAS PARTE 1 DEL LABORATORIO 3

## ¿Cuál es la diferencia principal entre una prueba unitaria y una prueba de integración E2E? 

Las pruebas unitarias son un tipo de prueba que cubre una pequeña parte de codigo, como funcionalidades muy basicas o bloques de codigo muy pequeño, esto se hace con el fin de evaluar todo el codigo en situaciones aisladas. Por otro lado, las pruebas E2E (End to End) son aquellas que simulan un proceso completo por todo el codigo para corroborar ese funcionamiento cuando todas las partes del codigo estan conectadas.

## En Scrum ¿Cuál es el propósito de la Sprint Retrospective y porque es crucial para la mejora continua del equipo? 

Scrum es un proceso en el que la finalidad es aplicar buenas practica para el desarrollo y ejecución de la creacion de proyectos, este desarrollo esta dividido en sprints que son ciclos cortos de trabajo de unas cuantas semanas, despues de terminar un sprint, se hace un 'sprint retrospective' que es una reunion entre el equipo de desarrollo con el fin de hablar sobre lo hecho y que falta para los demas sprints, es importante ya que ayuda a mantener las ideas claras de lo que se quiere hacer en el equipo y ver sobre lo que hace falta.

## Explique la diferencia entre una Épica, una Feature y una historia de Usuario. Proporcione un ejemplo de cada una si tenemos un sistema de streaming de video como lo es Netflix. 

'EPICA': Estructuras de alto nivel encaminadas a una gran parte del trabajo, sirve como contenedor para todo el trabajo relacionado, dentro de este hay features.
'FEATURE': Es una parte del trabajo centrada en la funcionalidad, es creada con el fin de que sea corta y no maneje demasiados sprints para su uso (2 a 3 sprints). ademas de agrupar varias historias de usuario.
'HISTORIA DE USUARIO': Es una descripcion de una funcionalidad pero desde vista del usuario.

## ¿Qué es una cobertura de Código (code coverage) y porque una cobertura del 100% no garantiza necesariamente que el software esté libre de errores? 

El 'CodeCoveraje' es un porcentaje que indica la cantidad de codigo cubierto por pruebas automatizadas, con la finalidad de ver que partes aun no estan probadadas. Sin embargo no garantiza que el codigo este libre de errores, ya que aunque las pruebas son automatizadas, hay partes del codigo donde se necesite una prueba especifica y sus excepciones.

## Describa que es un Diagrama de Casos de Uso y que elementos lo componen. ¿Para qué sirve en la fase de análisis de requerimientos?

Es una representacion visual en los cuales podemos ver los actores y sus funcionalidades, la idea es saber como cada actor interactua con las funcionalidades.
La fase de analizis de requerimientos, es un proceso al inicio del desarrollo donde se deja claro cuales son las expectativas y las necesidades del cliente y como van a interactuar.

## ¿Cuál es la diferencia entre el uso de Junit y Jacoco en un proyecto, y como complementa SonarQube este proceso en términos de calidad de software? 

Junit es una parte del codigo que nos ayudan a hacer las pruebas unitarias, mientras que Jacoco es una herramienta que genera reportes sobre que partes del codigo se ejecutan sobre las pruebas hechas en Junit, ya el trabajo de sonarQube es evitar buggs de codigo y hacer una buena practica del clean code.

## ¿Qué ventajas tiene el uso de Planning Poker frente a otros métodos de estimación tradicional y como ayuda a mejorar la transparencia y compromiso del equipo? 

La metododologia del Planning Poker nos permite crear un espacio donde le da mas claridad a la estimacion inicial de los sprints, asi mismo permite que cada equipo de desarrollo sea incluido y considerado respecto a cuanto crea que sea necesario trabajar durante el sprint.

## Menciona los valores de Scrum y explica cual consideras más difícil de aplicar en un equipo. 

Valores Scrum
- Coraje: Afrontar problemas y adentrarse en lo desconocido, ser capaz de ser audaz y tomar decisiones arriesgadas.
- Enfoque: Cada equipo de desarrollo se basa en sus objetivos dentro del sprint.
- Compromiso: Cada miembro se compromete a cumplir y dedicar su tiempo al trabajo.
- Respeto: Generar un ambiente profesional entre desarrolladores, generar espacios de debate para evitar conflictos directos entre integrantes.
- Apertura: Los integrantes deben ser sinceros y transparentes sobre su trabajo en el sprint.

Consideramos que el valor mas complicado seria el coraje, ya que en estos momentos de aprendizaje es dificil tomar decisiones que cambien totalmente el panorama y entrar en el riesgo de llevar el desarrollo por otro que no sea el correcto, ademas por la necesidad de generar buenas practicas y de utilizar bien los elementos proporcionados.