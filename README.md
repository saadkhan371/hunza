# hunza
mvn package -DskipTests -X

--

docker login --username saadkhan371

--

docker build -t docker.io/saadkhan371/hunza:1.0.0 .
docker push docker.io/saadkhan371/hunza:1.0.0

--
cd kube/

--

kompose convert

--

docker run hunza

--

kubectl apply -f kube

--

kubectl get pods
