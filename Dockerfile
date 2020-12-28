FROM maven:3.6-openjdk-8-slim AS build
RUN mkdir /tmp/project
COPY . /tmp/project
WORKDIR /tmp/project
RUN mvn -B clean package 

FROM openjdk:8-jre-alpine
RUN addgroup --system jboss && adduser --system --shell /bin/false --ingroup jboss jboss && mkdir /srv/jboss
ADD jboss-eap-6.4.23.tgz /srv/jboss
COPY --from=build /tmp/project/target/starmx-managed-webapp.war /srv/jboss/standalone/deployments
RUN chown -R jboss:jboss /srv/jboss
EXPOSE 4447 8080 8787 9990 9999
USER jboss
WORKDIR /srv/jboss/bin
CMD ["/srv/jboss/bin/standalone.sh", "-b", "0.0.0.0"]
