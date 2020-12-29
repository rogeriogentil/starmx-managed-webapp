# starmx-managed-webapp

A simple web application Java EE 6-based managed by StarMX framework. 

**OBS:** Currently, the adaptation can be observed only via console (JBoss Application Server log).

## Framework

StarMX[1] is an architecture-based framework for Self-Adaptive Systems (SAS).

## Execute with Docker

A Docker image is available to simplify the web application execution. Thus, run the following command: 

```shell
docker run --name starmx-managed-webapp -p 8080:8080 rogeriogentil/starmx-managed-webapp:latest
```

## Build

To build a Docker image, it's necessary a Jboss EAP compressed file in the root folder (the current `Dockerfile` uses a `.tgz` file). The [hasalex/eap-build](https://github.com/hasalex/eap-build) project was and can be used to compile a version of JBoss EAP 6. So, just execute (on Linux):

```shell
./docker-build.sh
```

## References

[1] ASADOLLAHI, R.; SALEHIE , M.; TAHVILDARI , L. StarMX: A framework for Developing Self-Managing Java-based Systems. In: _2009 ICSE Workshop on Software
Engineering for Adaptive and Self-Managing Systems_, p. 58–67, 2009.



