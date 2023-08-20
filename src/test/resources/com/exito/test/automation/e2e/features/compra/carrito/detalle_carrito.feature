# El "#languaje" No es un comentario representa el tipo de lenguaje utilizado en la estructura de Gherkin
#language: es

# @Todos            # Etiqueta para todos los escenarios
# @{Funcionalidad}  # Palabra clave representativa de la funcionalidad

@Todos
@DetalleCarrito
Característica: Detalle Carrito de Compra
  Yo como usuario del portal exito
  Necesito consultar el detalle de articulos agregados a mi carrito de compra
  Para revisarlos antes de proceder con la compra

  # @HP            # Tipo de prueba [Happy Path | Altern Path]
  # @Regresion     # Aplica para regresion
  # @Smoke         # Aplica para prueba de humo
  # @C######       # ID CP en la herramienta de gestion de pruebas (TestRail / XRay ...)
  # @Actual        # Escenario que se esta automatizando/trabajando actualmente


  @HP
  @Regresion
  @CP-003 # Ir al detalle del carrito de compras, con articulos previamente seleccionados
  Escenario: Ver detalle de los articulos agregados al carrito de compra
      # R/ ¿Donde se encuentra el actor? --> ubicación / contexto
      # R/ ¿Que acabó de realizar el actor? --> previamente, en tiempo pasado
    Dado que "el usuario" se encuentra iniciando su proceso de compra en Exito.com
      | categoria_menu | subcategoria_menu | cantidad_productos_pedido |
      | Dormitorio     | Cabeceros         | 5                         |
      # R/ ¿Que esta haciendo el actor? --> en tiempo presente, comportamiento sujeto de prueba
    Cuando da inicio a su proceso de compra
      | email_compra       |
      | hcuenca8@gmail.com |
      # R/ ¿Que se espera? --> en tiempo futuro, validación / verificación
      # R/ ¿Cual es la consecuencia de sus actos? --> en tiempo futuro, lo que sucederá
    Entonces deberían verse listados los productos que fueron agregados al carrito
    Y deberian conservarse los precios de los productos de cuando fueron elegidos
    Y deberian verse las cantidades de cada producto que fueron elegidas
