# Bill Splitter Server
Server part for ReactJS-based web-app for fast bill splitting between friends

Provides REST API

## Demo-site
http://zavedyaev.ru/bill-splitter

## License
<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">
    <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" />
</a>

Bill-Splitter-Server app is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.


## Requirements

1. mysql
2. docker

## Installation on server
1. Create a database and user
    <pre>
    create database bill_splitter;
    create user 'bill_splitter'@'%' identified by 'bill_splitter';
    grant all on bill_splitter.* to 'bill_splitter'@'%';
    </pre>
2. build docker image and push it
    <pre>
    ./gradlew bootBuildImage
    docker tag docker.io/library/bill-splitter-server:0.0.1-SNAPSHOT zavedyaev/bill-splitter-server:0.0.1-SNAPSHOT
    docker push zavedyaev/bill-splitter-server:0.0.1-SNAPSHOT
    </pre>
    or
    <pre>
    ./gradlew bootJar
    docker build -t docker.io/library/bill-splitter-server:0.0.1-SNAPSHOT .
    docker tag docker.io/library/bill-splitter-server:0.0.1-SNAPSHOT zavedyaev/bill-splitter-server:0.0.1-SNAPSHOT
    docker push zavedyaev/bill-splitter-server:0.0.1-SNAPSHOT
    </pre>

3. pull and run it on server
    <pre>
    docker pull zavedyaev/bill-splitter-server:0.0.1-SNAPSHOT
    docker run -p 8081:8081 --add-host=dockerhost:172.17.0.1 -d -m 314572800 --memory-swap 100000000 --restart always zavedyaev/bill-splitter-server:0.0.3-SNAPSHOT
    </pre>