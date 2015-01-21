# springAMQP

Spring boot AMQP client, which communicates with rabbitmq.


# Setup

## Prerequisites

* [Download](http://www.rabbitmq.com/download.html) and install rabbitmq
* [For WINDOWS] Activate rabbitmq management plugin by executing the following commands under `%PROGRAMFILES%\RabbitMQ Server\rabbitmq_server_3.4.3\sbin`

    ```
    rabbitmq-plugins.bat enable rabbitmq_management
    rabbitmq-service.bat stop
    rabbitmq-service.bat install
    rabbitmq-service.bat start
    ```

* The rabbitmq-management is now accesible under [http://localhost:15672/](http://localhost:15672/)

