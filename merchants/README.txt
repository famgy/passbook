配置 kafka 环境:

启动服务:
bin/zookeeper-server-start.sh config/zookeeper.
bin/kafka-server-start.sh config/server.properties

创建 Topic:
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic merchants-template

查询 Topic:
bin/kafka-topics.sh --list --bootstrap-server localhost:9092

消息接收:
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic merchants-template --from-beginning

消息生产:
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic merchants-template