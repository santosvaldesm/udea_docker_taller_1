FROM node:6-alpine
LABEL maintainer="santosvaldesm@gmail.com"
RUN apk update
RUN apk upgrade
RUN apk add --no-cache tini
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY package.json /usr/src/app
RUN npm install
RUN npm cache clean --force
COPY . /usr/src/app
EXPOSE 80
ENTRYPOINT ["/sbin/tini", "--", "./bin/www"]