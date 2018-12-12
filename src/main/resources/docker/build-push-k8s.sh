#!/bin/bash
docker build -t gcr.io/fabled-cooler-211307/quote-engine:v1 .
gcloud docker -- push gcr.io/fabled-cooler-211307/quote-engine:v1
