# language: es
  Característica: Realizar compra de tickets en Cineplanet
    @buy-product
    Esquema del escenario: Comprar entradas online en la pagina de cineplanet
      Dado que el usuario ingresa a la pagina principal del cine <caso>
      Cuando inicia sesion con sus usuario y constrasena <caso>
      Y selecciona la pelicula <caso>
      Entonces elige el horario de su preferencia
      Y selecciona los asientos de la funcion
      Entonces confirma su compra

      Ejemplos:
      |caso |
      |  1  |