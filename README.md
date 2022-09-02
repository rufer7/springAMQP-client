___

:warning:**This repository has been archived and is no longer maintained**:warning:
___

# springAMQP 
[![Build Status](https://travis-ci.org/rufer7/springAMQP-client.svg?branch=master)](https://travis-ci.org/rufer7/springAMQP-client)
[![License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://github.com/rufer7/springAMQP-client/blob/master/LICENSE)

Spring boot AMQP client, which communicates with rabbitmq.


# Setup

## Prerequisites

* [Download](http://www.rabbitmq.com/download.html) and install rabbitmq
* [For WINDOWS] Activate rabbitmq management plugin by executing the following commands in the command prompt, which has to be executed as administrator

    ```
    cd %PROGRAMFILES%\RabbitMQ Server\rabbitmq_server_3.4.3\sbin
    rabbitmq-plugins.bat enable rabbitmq_management
    rabbitmq-service.bat stop
    rabbitmq-service.bat install
    rabbitmq-service.bat start
    ```

* The rabbitmq-management is now accessible under [http://localhost:15672/](http://localhost:15672/)


## Configuration

* Adjust the amqp-properties in the applicaiton.properties file


# Default configuration hints

If you use the default exchange and binding you have to provide the queue name as routing key to send a message to a queue. This has to be defined in the template (`template.setRoutingKey(this.queueName)`)
