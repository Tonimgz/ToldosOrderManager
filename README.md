# ToldosOrderManager 🚀

Sistema de gestión de pedidos e instalaciones técnico-comerciales desarrollado en Java para el entorno de ventanas interactivas (`JOptionPane`). 

Este proyecto ha sido modelado basándome en mi experiencia de 20 años en el sector técnico e instalaciones, aplicando los fundamentos de desarrollo backend aprendidos durante el primer año de DAW.

## 🛠️ Conceptos Técnicos Aplicados (1º DAW)
* **Programación Orientada a Objetos (POO):** Uso avanzado de herencia, encapsulamiento estricto y polimorfismo dinámico en el cálculo de costes.
* **Estructuras de Datos:** Gestión de colecciones dinámicas utilizando la interfaz `List` y la implementación `ArrayList`.
* **Control de Excepciones:** Validación rigurosa de flujos de datos en el constructor de entidades mediante `IllegalArgumentException` y control de tipos numéricos.
* **Tipos Enumerados:** Control de flujo y estados lógicos del taller mediante un `Enum` (`EstadoPedido`).
* **Interfaz Dinámica:** Flujo interactivo adaptado mediante diálogos complejos de `JOptionPane` sin mezclar la lógica de negocio con la vista.

## 📁 Estructura del Proyecto
* `modelo`: Entidades del negocio (`Cliente`, `Pedido`, `Producto`, `ToldoMotorizado`, `EstadoPedido`).
* `vista`: Controlador de interfaz de usuario y captura de datos (`AppGestion`).
