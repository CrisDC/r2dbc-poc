FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine

WORKDIR /workspace

ENV host="pc1-postgresql-server.postgres.database.azure.com"
ENV port="5432"
ENV database="universidad"
ENV username="cristhiandc"
ENV password="helloWORLD1"

COPY target/r2dbc*.jar app.jar

ENTRYPOINT exec java -jar /workspace/app.jar