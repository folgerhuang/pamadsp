blog:
https://dzone.com/articles/spring-cloud-stream-with-kafka



kafka:
 start zookeeper:
D:\Utities\kafka_2.11-0.11.0.0\bin\windows\zookeeper-server-start.bat D:\Utities\kafka_2.11-0.11.0.0\config\zookeeper.properties
start kafka:
D:\Utities\kafka_2.11-0.11.0.0\bin\windows\kafka-server-start.bat D:\Utities\kafka_2.11-0.11.0.0\config\server.properties

1PS D:\Utities\kafka_2.11-0.11.0.0\bin\windows> .\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic gr
 eetings --from-beginning
 
 
 
 
 
 
 
 
 
 
 
 
