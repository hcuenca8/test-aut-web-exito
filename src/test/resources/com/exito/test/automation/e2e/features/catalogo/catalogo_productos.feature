# El "#languaje" No es un comentario representa el tipo de lenguaje utilizado en la estructura de Gherkin
#language: es

# @Todos            # Etiqueta para todos los escenarios
# @{Funcionalidad}  # Palabra clave representativa de la funcionalidad

@Todos
@CatalogoProductos
Característica: Catalogo de Productos
  Yo como usuario del portal exito
  Necesito navegar por el catalogo de productos
  Para ver y seleccionar los productos de mi interes

  # @HP            # Tipo de prueba [Happy Path | Altern Path]
  # @Regresion     # Aplica para regresion
  # @Smoke         # Aplica para prueba de humo
  # @C######       # ID CP en la herramienta de gestion de pruebas (TestRail / XRay ...)
  # @Actual        # Escenario que se esta automatizando/trabajando actualmente


  @HP
  @Regresion
  @CP-002 # Seleccionar productos del catalogo
  Escenario: Resumen del carrito, al seleccionar productos del catalogo para su pedido
      # R/ ¿Donde se encuentra el actor? --> ubicación / contexto
      # R/ ¿Que acabó de realizar el actor? --> previamente, en tiempo pasado
    Dado que "el usuario" se encuentra sobre el catalogo de productos del portal exito.com
      | categoria_menu | subcategoria_menu |
      | Dormitorio     | Cabeceros         |
      # R/ ¿Que esta haciendo el actor? --> en tiempo presente, comportamiento sujeto de prueba
    Cuando selecciona productos del catalogo, para su pedido
      | cantidad_productos_pedido |
      | 5                           |
      # R/ ¿Que se espera? --> en tiempo futuro, validación / verificación
      # R/ ¿Cual es la consecuencia de sus actos? --> en tiempo futuro, lo que sucederá
    Entonces debería indicarse en el resumen del carrito, el total de articulos agregados
