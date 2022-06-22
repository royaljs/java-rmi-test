# java-rmi-test
A test project for implementing Java RMI application.

## Running Test

### 1. Build and Run Server

```
javac -d build src/dev/jiwonlee/java/rmi/server/Server.java src/dev/jiwonlee/java/rmi/IService.java // build server

rmic -classpath build -d build dev.jiwonlee.java.rmi.server.Server //generate Server_Stub.class by rmic

java -cp build dev.jiwonlee.java.rmi.server.Server {port} // run server
```

### 2. Build and Run Client

```
javac -d build src/dev/jiwonlee/java/rmi/client/Client.java src/dev/jiwonlee/java/rmi/IService.java // build client

java -cp build dev.jiwonlee.java.rmi.client.Client {host} {port} //run client
```

### Result Log
Server
```
[Server] Starting...
[RMI Registry] Starting with port 3333 ...
[RMI Registry] Created.
[Server] Started.
[Client] client: How are you?
[Server] server: I'm fine.
```

Client
```
I: How are you?
Server: I'm fine.
```
