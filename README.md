# hunza
mvn package -DskipTests -X

--

docker login

--
docker build -t hunza:1.0.0 .

--

docker run hunza

--

kubectl apply -f kube

--

kubectl get pods
