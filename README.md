<div class="header" markdown="1" align="center">
</div>
<h1 align="center">KafkaMetrics</h1>
  <p align="center">
  The homework project for <a href="https://t1.ru/internship/item/otkrytaya-shkola-dlya-java-razrabotchikov/">open school JAVA by T1</a>
  <br/><br/>
    <a href="https://github.com/Zazergel/store/issues">Report Bug</a> *
    <a href="https://github.com/Zazergel/store/issues">Request Feature</a>
  </p>
  <div class="header" markdown="1" align="center">
    
  ![Contributors](https://img.shields.io/github/contributors/Zazergel/kafkametrics?color=dark-green) 
  ![Forks](https://img.shields.io/github/forks/Zazergel/kafkametrics?style=social) 
  ![Issues](https://img.shields.io/github/issues/Zazergel/kafkametrics) 
</div>

# Build with

<p align="left">
    <img src="https://skillicons.dev/icons?i=java,maven,spring,postgres,hibernate,docker,kafka" />
</p>

## Описание проекта

**KafkaMetrics** - это распределенная система для сбора и обработки метрик, основанная на Apache Kafka. Проект включает в себя кластер Kafka с тремя брокерами, Zookeeper для координации, а также сервисы Producer и Consumer, которые взаимодействуют с Kafka для публикации и обработки метрик соответственно.

## Архитектура

- **Zookeeper**: используется для управления и координации брокеров Kafka.

- **Kafka**: кластер из трех брокеров (kafka, kafka2, kafka3), обеспечивающий достаточную доступность и отказоустойчивость.

- **Producer Service**: сервис, который собирает метрики и отправляет их в топик Kafka.
  #### API методы
  `POST /metrics`: Создать новую метрику с переданным именем и отправить ее в Kafka.

- **Consumer Service**: сервис, который потребляет метрики из топика Kafka (`{metrics-topic}`) и обрабатывает их.
    #### API методы
  `GET /metrics`: Получение всех метрик.

  `GET /metrics/{id}`: Получение конкретной метрики по id.

- **Postgres**: база данных для хранения обработанных метрик.

## Масштабирование

Для масштабирования кластера Kafka вы можете добавить дополнительные брокеры, обновив файл docker-compose.yml.

### Дополнительно
- Протестировать API продукта можно с помощью POSTMAN-коллекции в директории postman.

## Установка и запуск
Убедитесь, что у вас установлен Docker актуальной версии.
1. Клонируйте репозиторий: `git clone https://github.com/Zazergel/kafkametrics.git`
2. Перейдите в корневой каталог проекта.
3. Запустите приложение с помощью docker-compose.yml файла. 

## Authors

 **[Zazergel](https://github.com/Zazergel/)**
