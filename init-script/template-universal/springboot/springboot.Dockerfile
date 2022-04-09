FROM openjdk:11

RUN chsh -s /bin/bash
ENV SHELL=/bin/bash

RUN adduser --gecos '' --disabled-password template

ADD bin /home/template

EXPOSE 8082
USER template
WORKDIR /home/template
ENTRYPOINT [ "java", "-jar", "/home/template/template-universal-1.0.0.jar" ]