# Refactorización de pruebas funcionales manuales

## Ejecución
Desde la raíz del proyecto:
- `./mvnw test` (o `mvnw.cmd test` en Windows) compila el proyecto y las pruebas de compilación automática.
- Las clases de `functionals_manual` son ejecutores manuales con `main`; se pueden ejecutar individualmente desde el IDE.

## Cambios
- Se eliminaron imports de clases del propio paquete de pruebas, incluidos los imports circulares/autorreferenciales de `ClientManualTestRunner`.
- Cada ejecutor importa exclusivamente clases de producción del dominio que utiliza.
- Se corrigieron los constructores: `Addressc` y `Addressr` reciben calle, ciudad, código postal y país; `Client` recibe los siete argumentos definidos por el dominio, no ocho.
- Los records `Email` y `Phone` se consultan con `email()` y `phone()`, respectivamente.
- Los ejemplos usan direcciones con todos los campos obligatorios y códigos postales de cinco caracteres.
- Las pruebas manuales emplean `try/catch`, `if` y contadores de resultados, sin depender de imports entre tests ni de anotaciones JUnit.
- `Nif`, `Cif` y `Nie` siguen usando las reglas implementadas en producción. En el estado actual de estas clases, la comprobación del identificador legal solo rechaza `null`; no comprueba formato ni dígitos de control. No se han añadido pruebas que afirmen una validación que el dominio todavía no implementa.
