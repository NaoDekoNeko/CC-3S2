# Curso de desarrollo de software 

Actividad individual: responde las siguientes preguntas: 


## Introducción a la entrega continua 

**¿Cuáles son las tres fases del proceso de entrega tradicional?**
  
Las tres fases del proceso de entrega tradicional son: desarrollo, pruebas y despliegue.

**¿Cuáles son las tres etapas principales de un pipeline de CD?**
 
Las tres etapas principales de un pipeline de CD (Entrega Continua) son: integración continua, entrega continua y despliegue continuo.

**Menciona al menos tres beneficios de usar CD.**

Algunos beneficios de usar CD son: acelerar el tiempo de lanzamiento al mercado, mejorar la calidad del software al detectar y corregir errores más rápidamente, y aumentar la eficiencia del equipo al automatizar tareas repetitivas.

**¿Cuáles son los tipos de pruebas que deben automatizarse como parte del pipeline de CD?**

Los tipos de pruebas que deben automatizarse como parte del pipeline de CD incluyen pruebas unitarias, pruebas de integración, pruebas funcionales y pruebas de aceptación.

**¿Deberíamos tener más pruebas de integración o unitarias?**

Explicar por qué. No hay una respuesta única a esta pregunta ya que depende del contexto y del proyecto en particular. Las pruebas unitarias son útiles para verificar el comportamiento de pequeñas unidades de código, mientras que las pruebas de integración verifican cómo interactúan diferentes unidades entre sí. Ambos tipos de pruebas son importantes y deben ser utilizados en conjunto para garantizar la calidad del software.

**¿Qué significa el término DevOps?**

DevOps es una práctica que combina el desarrollo de software (Dev) con las operaciones de TI (Ops) para mejorar la colaboración y la comunicación entre los equipos y acelerar el proceso de entrega de software.

## Docker 

**¿Cuál es la principal diferencia entre la creación de contenedores (como con Docker) y la virtualización (como con VirtualBox)?**

La principal diferencia entre la creación de contenedores y la virtualización es que los contenedores comparten el mismo kernel del sistema operativo del host, mientras que la virtualización emula completamente un sistema operativo invitado en hardware virtualizado. Esto hace que los contenedores sean más ligeros y rápidos en comparación con la virtualización.

**¿Cuáles son los beneficios de proporcionar una aplicación como una imagen de Docker? Nombra al menos dos.**

Algunos beneficios de proporcionar una aplicación como una imagen de Docker son: portabilidad, ya que las imágenes de Docker pueden ejecutarse en cualquier sistema que tenga Docker instalado; y consistencia, ya que las imágenes de Docker empaquetan todas las dependencias necesarias para ejecutar la aplicación, lo que garantiza que se comportará de la misma manera en cualquier entorno.

**¿Se puede ejecutar el demonio Docker de forma nativa en Windows y macOS?**

No, el demonio Docker no se puede ejecutar de forma nativa en Windows ni en macOS debido a que utiliza características específicas del kernel de Linux. Sin embargo, se puede utilizar Docker en estos sistemas operativos a través de una máquina virtual Linux.

**¿Cuál es la diferencia entre una imagen Docker y un contenedor Docker?**

Una imagen Docker es una plantilla de solo lectura que define un contenedor. Contiene el código que se ejecutará, incluyendo cualquier definición para cualquier biblioteca o dependencia que el código necesite. Un contenedor Docker es una instancia en ejecución de una imagen Docker.

**¿Qué significa cuando se dice que las imágenes de Docker tienen capas?**

Las imágenes de Docker están compuestas por capas, cada capa representa un cambio importante en el sistema de archivos del contenedor y estas a su vez pueden ser compartidas entre distintas imágenes. Esto permite reutilizar capas comunes entre diferentes imágenes y acelerar el proceso de construcción y distribución de imágenes.


## Pipelines 

**¿Qué es un pipeline?**

Un pipeline es una secuencia de pasos automatizados que permiten llevar a cabo un proceso de manera eficiente y repetible. En el contexto del desarrollo de software, un pipeline puede referirse a un pipeline de integración continua (CI) o entrega continua (CD), que automatiza el proceso de construcción, prueba y despliegue del código.

**¿Cuál es la diferencia entre un stage y un step en el pipeline?**

Un stage (etapa) en un pipeline representa una fase lógica del proceso, mientras que un step (paso) representa una tarea específica dentro de una etapa. Por ejemplo, en un pipeline de CI/CD, una etapa podría ser "Pruebas" y dentro de esa etapa podrían haber varios pasos como "Ejecutar pruebas unitarias" y "Ejecutar pruebas de integración".

**¿Qué es la sección post en el pipeline de Jenkins?**

La sección post en un pipeline de Jenkins permite definir acciones que se ejecutarán después de que se complete una etapa o todo el pipeline. Por ejemplo, se pueden enviar notificaciones, archivar artefactos o limpiar recursos.

**¿Cuáles son las tres etapas más fundamentales del commit pipeline?**

Las tres etapas más fundamentales del commit pipeline son: construcción, pruebas y análisis estático. En la etapa de construcción se compila el código y se crean los artefactos necesarios para su ejecución. En la etapa de pruebas se ejecutan pruebas automatizadas para verificar el correcto funcionamiento del código. En la etapa de análisis estático se analiza el código en busca de posibles errores o problemas.

**¿Cuál es el propósito de la etapa de cobertura de código?**

El propósito de la etapa de cobertura de código es medir qué porcentaje del código fuente está cubierto por pruebas automatizadas. Esto permite identificar áreas del código que no están siendo probadas y mejorar la calidad del software al aumentar la cobertura de pruebas.

## Kubernetes 

**¿Qué es un clúster de servidores?**

Un clúster de servidores es un conjunto de servidores que trabajan juntos para proporcionar una mayor disponibilidad, escalabilidad y confiabilidad que un solo servidor. Los servidores en un clúster están conectados entre sí y pueden compartir recursos y balancear la carga de trabajo.

**¿Cuál es la diferencia entre un plano de control de Kubernetes y un nodo de Kubernetes?**

El plano de control de Kubernetes es responsable de tomar decisiones globales sobre el clúster y detectar y responder a eventos del clúster. Un nodo de Kubernetes es una máquina en el clúster que ejecuta aplicaciones en contenedores.

**Menciona al menos tres plataformas en la nube que proporcionen un entorno de Kubernetes listo para usar.**

Algunas plataformas en la nube que proporcionan un entorno de Kubernetes listo para usar son Google Kubernetes Engine (GKE), Amazon Elastic Kubernetes Service (EKS) y Microsoft Azure Kubernetes Service (AKS).

**¿Cuál es el comando de Kubernetes para escalar implementaciones?**

El comando `kubectl scale` se utiliza para escalar implementaciones en Kubernetes. Por ejemplo, para escalar una implementación llamada `my-deployment` a 5 réplicas, se utilizaría el siguiente comando: `kubectl scale --replicas=5 deployment/my-deployment`.

**Nombre al menos dos sistemas de administración de clústeres que no sean Kubernetes.**

Algunos sistemas de administración de clústeres que no son Kubernetes son Docker Swarm y Apache Mesos.
