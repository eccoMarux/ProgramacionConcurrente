Problema del comedor
Ante la carencia de comederos en la Sociedad Protectora de Animales, la administración ha
decidido que los pocos comederos que están sanos estén en un comedor y sean de uso
mixto: pueden comer tanto gatos como perros, pero con la condición de que
simultáneamente sólo pueda haber animales de la misma especie. Es decir, pueden haber
varios gatos comiendo a la vez, pero no pueden entrar perros. Si hay perros comiendo, no
deberían entrar los gatos.
Implemente la gestión del comedor (cada animal se simula como un hilo que entra y sale
del comedor).
Observación 1: el comedor tiene una capacidad limitada, ya que hay X
cantidad de comederos sanos, luego no pueden entrar a comer más de esa
cantidad de perros/gatos. Probar con:
● cantidad = 2
● cantidad = 5
● cantidad = 20
Observación 2: todos los animales deben poder comer en algún momento de su
día. Proponga una solución que contemple esa condición. (Por ejemplo, si ya
han comido xx perros, y hay gatos esperando, no debería permitirse que sigan
ingresando perros, hasta que algunos gatos puedan comer y a la inversa)
a. Identificar los objetos activos y los recursos compartidos en el escenario presentado.
b. Dar una solución utilizando semáforos que modele el comportamiento explicado.