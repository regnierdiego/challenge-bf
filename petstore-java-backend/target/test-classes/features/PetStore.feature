Feature: Leads

  @petstore-001 @all
  Scenario: Agregar una mascota en PetStore
    Given Se realiza un POST a PetStore
    When Obtiene la respuesta esperada del POST
    Then El status code del POST se muestra correctamente

  @petstore-002 @all
  Scenario: Consultar una mascota en PetStore
    Given Se realiza un GET a PetStore
    When Obtiene la respuesta esperada del GET
    Then El status code del GET se muestra correctamente

  @petstore-003 @all
  Scenario: Modificar los datos de una mascota en PetStore
    Given Se realiza un PUT a PetStore
    When Obtiene la respuesta esperada del PUT
    Then El status code del PUT se muestra correctamente