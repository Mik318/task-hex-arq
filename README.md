# Documentación de Endpoints - TaskService

## Endpoints

### Crear una tarea
**URL:** `/tasks`  
**Método:** `POST`  
**Descripción:** Crea una nueva tarea.  
**Cuerpo de la solicitud:**
```json
{
  "title": "Título de la tarea",
  "description": "Descripción de la tarea"
}
```
**Respuesta exitosa:**  
Código: `201 Created`
```json
{
  "id": 1,
  "title": "Título de la tarea",
  "description": "Descripción de la tarea"
}
```

---

### Obtener una tarea por ID
**URL:** `/tasks/{id}`  
**Método:** `GET`  
**Descripción:** Obtiene los detalles de una tarea específica.  
**Parámetros de ruta:**
- `id`: ID de la tarea.

**Respuesta exitosa:**  
Código: `200 OK`
```json
{
  "id": 1,
  "title": "Título de la tarea",
  "description": "Descripción de la tarea"
}
```

---

### Actualizar una tarea
**URL:** `/tasks/{id}`  
**Método:** `PUT`  
**Descripción:** Actualiza los detalles de una tarea existente.  
**Parámetros de ruta:**
- `id`: ID de la tarea.

**Cuerpo de la solicitud:**
```json
{
  "title": "Nuevo título",
  "description": "Nueva descripción"
}
```

**Respuesta exitosa:**  
Código: `200 OK`
```json
{
  "id": 1,
  "title": "Nuevo título",
  "description": "Nueva descripción"
}
```

---

### Eliminar una tarea
**URL:** `/tasks/{id}`  
**Método:** `DELETE`  
**Descripción:** Elimina una tarea específica.  
**Parámetros de ruta:**
- `id`: ID de la tarea.

**Respuesta exitosa:**  
Código: `204 No Content`

---

### Obtener todas las tareas
**URL:** `/tasks`  
**Método:** `GET`  
**Descripción:** Obtiene una lista de todas las tareas.

**Respuesta exitosa:**  
Código: `200 OK`
```json
[
  {
    "id": 1,
    "title": "Título de la tarea",
    "description": "Descripción de la tarea"
  },
  {
    "id": 2,
    "title": "Otra tarea",
    "description": "Otra descripción"
  }
]
```

---

### Obtener información adicional de una tarea
**URL:** `/tasks/{id}/additional-info`  
**Método:** `GET`  
**Descripción:** Obtiene información adicional de una tarea específica.  
**Parámetros de ruta:**
- `id`: ID de la tarea.

**Respuesta exitosa:**  
Código: `200 OK`
```json
{
  "id": 1,
  "additionalInfo": "Información adicional de la tarea"
}
```

---

## Notas

- Todos los endpoints devuelven errores con códigos estándar como `400 Bad Request`, `404 Not Found`, etc., en caso de fallos.
- Asegúrate de enviar los datos en formato JSON cuando sea necesario.
