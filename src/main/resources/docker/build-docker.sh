#!/bin/bash
docker build -t rgs-test/traductor-proxy ./
docker save -o traductor-proxy.tar rgs-test/traductor-proxy:latest