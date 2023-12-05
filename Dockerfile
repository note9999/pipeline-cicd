FROM ubuntu:latest
LABEL authors="sangh"

ENTRYPOINT ["top", "-b"]