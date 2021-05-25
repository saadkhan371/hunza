# hunza
mvn package -DskipTests -X
docker build -t hunza .
docker run hunza
kubectl apply -f kube
kubectl get pods
