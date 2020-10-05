# Victor MQTT Liason
## This project is built as a bridge for the Genetry Solar WiFi boards ( GS Inverters and PJ Inverters with WiFi upgrade). Its job is:
* To act as an MQTT liason, forwarding it to next-in-line brokers (default wifi.genetrysolar.com)
* Log and store telemetry data 
* Run automated test suites against inverters

## It is very much in its infancy with lots to do:
* MQTT is handled via a JMS bridge/adapter. MQTT messages will come in as JMS messages, where we will log as appropriately and determine how to forward.
* REST API is planned to send control events to inverters, display aggregate log data, etc.
* Liquibase handles database schema versioning / upgrades so that as needs/requirements change we don't have to do manual data migrations.
* JUnit will likely handle the automated inverter testing if that turns into something. 