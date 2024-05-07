#!/usr/bin/env bash

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -u user:password -X GET --insecure https://localhost:8080/api/example/all  &

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -u user:password -X GET --insecure https://localhost:8080/api/relations/many/many/all &

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -u user:password -X GET --insecure https://localhost:8080/api/relations/one/many/all &

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -u user:password -X GET --insecure https://localhost:8080/api/relations/one/one/all &

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -u user:password -X GET --insecure https://localhost:8080/api/relations/many/one/all &