curl -XPOST -H "Content-Type: application/json" -d "{\"name\": \"Lucy\", \"age\": 11}" "http://localhost:8080/students"
curl -XPUT -H "Content-Type: application/json" -d "{\"name\": \"Lily\", \"age\": 12}" "http://localhost:8080/students/2"
curl -XDELETE "http://localhost:8080/students/3"