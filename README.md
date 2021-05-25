# hunza
FROM amazoncorretto:11
RUN echo $' \
public class Hello { \
public static void main(String[] args) { \
System.out.println("Welcome to Amazon Corretto!"); \
} \
}' > Hello.java
RUN javac Hello.java
CMD ["java", "Hello"] 

docker build -t hello-app .

docker run hello-app



========

GroupId: learnk8s.io
Name: knote-java

to 

	<groupId>com.hunza.test</groupId>
	<artifactId>hunza</artifactId>
	
	8080 to 8081

========

mvn package -DskipTests -X

docker build -t hunza .

docker run hunza


docker network create khunza


docker run \
  --name=mongo \
  --rm \
  --network=khunza mongo
  
  
docker stop mongo khunza
docker rm mongo khunza


docker login


docker tag hunza saadkhan371/hunza:1.0.0
docker push saadkhan371/hunza:1.0.0


docker run \
  --name=mongo \
  --rm \
  --network=hunza \
  mongo
docker run \
  --name=hunza \
  --rm \
  --network=hunza \
  -p 8080:8080 \
  -e MONGO_URL=mongodb://mongo:27017/dev \
  saadkhan371/hunza:1.0.0
  
  
  
docker stop mongo hunza
docker rm mongo hunza


kubectl apply -f kube


kubectl get pods -l app=hunza --watch
