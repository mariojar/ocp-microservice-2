FROM alpine:3.6
RUN apk --update add openjdk8-jre

COPY start-service.sh ./
COPY traductor-proxy-2.0.2.RELEASE.jar ./

EXPOSE 8083
ENTRYPOINT ["./start-service.sh"]