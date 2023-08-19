# El "#languaje" No es un comentario representa el tipo de lenguaje utilizado en la estructura de Gherkin
#language: es

# @Todos            # Etiqueta para todos los escenarios
# @{Funcionalidad}  # Palabra clave representativa de la funcionalidad

@Todos
@MenuPortal
Característica: Menu de opciones
  Yo como usuario del portal exito
  Necesito navegar por el menu de opciones
  Para dirigirme a la zona de mi interes

  # @HP            # Tipo de prueba [Happy Path | Altern Path]
  # @Regresion     # Aplica para regresion
  # @Smoke         # Aplica para prueba de humo
  # @C######       # ID CP en la herramienta de gestion de pruebas (TestRail / XRay ...)
  # @Actual        # Escenario que se esta automatizando/trabajando actualmente


  @HP
  @Regresion
  @CP-001 # Ingresar a una subcategoria del menu de opciones
  Escenario: Ver productos relacionados, al ingresar a una subcategoria, desde el menu de opciones
      # R/ ¿Donde se encuentra el actor? --> ubicación / contexto
      # R/ ¿Que acabó de realizar el actor? --> previamente, en tiempo pasado
    Dado que "el usuario" se encuentra sobre el menu de opciones del portal exito.com
      # R/ ¿Que esta haciendo el actor? --> en tiempo presente, comportamiento sujeto de prueba
    Cuando ingresa a una subcategoria
      | categoria_menu | subcategoria_menu |
      | Dormitorio     | Cabeceros         |
      # R/ ¿Que se espera? --> en tiempo futuro, validación / verificación
      # R/ ¿Cual es la consecuencia de sus actos? --> en tiempo futuro, lo que sucederá
    Entonces debería mostrarse en la web: "Cabeceros"
