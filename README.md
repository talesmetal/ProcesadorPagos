# ProcesadorPagos
Procesador de Pagos, ATDD y JUnit 

* **Requerimientos Cupones**
  * Crear cupones de descuento
    * El código de cupón no puede ser vacío ni null
    * El código de cupón no se puede duplicar
    * El descuento debe ser mayor a 0 y menor o igual a 20
  * Buscar cupones por código
    * El campo de búsqueda no puede ser null ni vacío
  * Eliminar cupones por código
    * El campo de búsqueda no puede ser null ni vacío

* **Requerimientos Procesador de Pagos**
  * El total a pagar debe ser mayor a 0.00
  * El total a pagar no puede ser null
  * El total y totalFinal deben tener el mismo valor al cargar un pago
  * El valor inicial del descuento debe ser 0.00
  * Al cargar un cupón el total - descuento debe almacenarse en la variable totalFinal
  * Al remover un cupón deben establecerse el descuento en 0.00 y el totalFinal debe ser igual al total
  * No se puede volver a cargar un pago hasta que se complete el que está pendiente
  * Debe ser posible modificar el monto del pago y recalcular el descuento en caso de que cuente con un cupón
  * Una vez finalizado el pago, el cupón no puede volver a usarse
