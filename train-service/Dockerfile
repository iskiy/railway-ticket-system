FROM golang:1.20-alpine AS build-stage

WORKDIR /app

COPY go.mod go.sum ./

RUN go mod download

COPY . .

RUN go build -o main cmd/main.go

FROM alpine:latest

WORKDIR /app

COPY --from=build-stage app/main main

EXPOSE 8081
EXPOSE 8090

RUN addgroup -S appgroup && adduser -S appuser -G appgroup -u 1000 && chown appuser:appgroup /home/appuser
USER appuser:appgroup

ENTRYPOINT ["./main"]