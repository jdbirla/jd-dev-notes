# ECO-Techstacks
## Technologies:  Java, SpringBoot, Docker, Kubernetes, solace, flume,  airflow

### Kubernetes



#### **Deployment and Scaling**
1. **Create a Deployment**  
   ```bash
   kubectl create deployment hello-world-rest-api --image=in28min/hello-world-rest-api:0.0.1.RELEASE
   ```  
   **Use Case**: To deploy a new application using a specified container image.

2. **Expose a Deployment**  
   ```bash
   kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080
   ```  
   **Use Case**: To expose your deployment as a service with an external LoadBalancer.

3. **Scale a Deployment**  
   ```bash
   kubectl scale deployment hello-world-rest-api --replicas=3
   ```  
   **Use Case**: To adjust the number of replicas for high availability or load management.

4. **Autoscale a Deployment**  
   ```bash
   kubectl autoscale deployment hello-world-rest-api --max=10 --cpu-percent=70
   ```  
   **Use Case**: To automatically scale the deployment based on CPU usage.

5. **Set a New Image**  
   ```bash
   kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hello-world-rest-api:0.0.2.RELEASE
   ```  
   **Use Case**: To update the container image for a deployment.

6. **Edit a Deployment**  
   ```bash
   kubectl edit deployment hello-world-rest-api
   ```  
   **Use Case**: To modify the deployment's configuration (e.g., `minReadySeconds`).

---

#### **Debugging and Logs**
7. **Delete a Pod**  
   ```bash
   kubectl delete pod hello-world-rest-api-58ff5dd898-62l9d
   ```  
   **Use Case**: To delete a problematic pod for troubleshooting or rolling replacement.

8. **Describe a Pod**  
   ```bash
   kubectl describe pod hello-world-rest-api-58ff5dd898-9trh2
   ```  
   **Use Case**: To get detailed information about a specific pod, such as events and resource usage.

9. **View Pod Logs**  
   ```bash
   kubectl logs hello-world-rest-api-67c79fd44f-d6q9z -f
   ```  
   **Use Case**: To monitor logs from a specific pod for debugging purposes.

---

#### **Resource Information**
10. **Get Pods**  
    ```bash
    kubectl get pods
    ```  
    **Use Case**: To list all pods in the current namespace.

11. **Get Pods with Details**  
    ```bash
    kubectl get pods -o wide
    ```  
    **Use Case**: To view detailed pod information, such as node assignment and IP.

12. **Get Services**  
    ```bash
    kubectl get svc
    ```  
    **Use Case**: To list all services in the current namespace.

13. **Get Events**  
    ```bash
    kubectl get events --sort-by=.metadata.creationTimestamp
    ```  
    **Use Case**: To view events sorted by creation time for troubleshooting.

14. **Get ReplicaSets**  
    ```bash
    kubectl get rs
    ```  
    **Use Case**: To list all ReplicaSets in the current namespace.

15. **Get Component Statuses**  
    ```bash
    kubectl get componentstatuses
    ```  
    **Use Case**: To check the status of cluster components.

16. **Get Nodes**  
    ```bash
    kubectl get nodes
    ```  
    **Use Case**: To view all nodes in the cluster.

---

#### **File-Based Operations**
17. **Export Deployment to YAML**  
    ```bash
    kubectl get deployment hello-world-rest-api -o yaml > deployment.yaml
    ```  
    **Use Case**: To export a deployment's configuration for versioning or reuse.

18. **Apply Configuration from a File**  
    ```bash
    kubectl apply -f deployment.yaml
    ```  
    **Use Case**: To apply changes or create resources defined in a YAML file.

19. **Delete Resources by Label**  
    ```bash
    kubectl delete all -l app=hello-world-rest-api
    ```  
    **Use Case**: To delete all resources associated with a specific label.

---

#### **Cluster and Namespace Management**
20. **Cluster Info**  
    ```bash
    kubectl cluster-info
    ```  
    **Use Case**: To display cluster information, such as master and DNS endpoints.

21. **List Namespaces**  
    ```bash
    kubectl get ns
    ```  
    **Use Case**: To view all namespaces in the cluster.

22. **Get All Resources**  
    ```bash
    kubectl get all
    ```  
    **Use Case**: To list all resources in the current namespace.

---

#### **Advanced Operations**
23. **Rollout History**  
    ```bash
    kubectl rollout history deployment hello-world-rest-api
    ```  
    **Use Case**: To view the deployment's rollout history.

24. **Rollout Undo**  
    ```bash
    kubectl rollout undo deployment hello-world-rest-api --to-revision=3
    ```  
    **Use Case**: To roll back to a previous deployment revision.

25. **Edit ConfigMap**  
    ```bash
    kubectl edit configmap todo-web-application-config
    ```  
    **Use Case**: To update a ConfigMap directly.

---

#### **External Tools**
26. **Authenticate with GCP**  
    ```bash
    gcloud auth login
    ```  
    **Use Case**: To authenticate with Google Cloud Platform.

27. **Get GCP Cluster Credentials**  
    ```bash
    gcloud container clusters get-credentials in28minutes-cluster --zone us-central1-a --project solid-course-258105
    ```  
    **Use Case**: To fetch credentials for accessing a GCP Kubernetes cluster.




#### Kubectl commands
```sh

docker run -p 8080:8080 jdrepo/hello-world-rest-api:0.0.1.RELEASE

kubectl create deployment hello-world-rest-api --image=jdrepo/hello-world-rest-api:0.0.1.RELEASE
kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080
kubectl scale deployment hello-world-rest-api --replicas=3
kubectl delete pod hello-world-rest-api-58ff5dd898-62l9d
kubectl autoscale deployment hello-world-rest-api --max=10 --cpu-percent=70
kubectl edit deployment hello-world-rest-api #minReadySeconds: 15
kubectl set image deployment hello-world-rest-api hello-world-rest-api=jdrepo/hello-world-rest-api:0.0.2.RELEASE

gcloud container clusters get-credentials jdrepoutes-cluster --zone us-central1-a --project solid-course-258105
kubectl create deployment hello-world-rest-api --image=jdrepo/hello-world-rest-api:0.0.1.RELEASE
kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080
kubectl set image deployment hello-world-rest-api hello-world-rest-api=DUMMY_IMAGE:TEST
kubectl get events --sort-by=.metadata.creationTimestamp
kubectl set image deployment hello-world-rest-api hello-world-rest-api=jdrepo/hello-world-rest-api:0.0.2.RELEASE
kubectl get events --sort-by=.metadata.creationTimestamp
kubectl get componentstatuses
kubectl get pods --all-namespaces

kubectl get events
kubectl get pods
kubectl get replicaset
kubectl get deployment
kubectl get service

kubectl get pods -o wide

kubectl explain pods
kubectl get pods -o wide

kubectl describe pod hello-world-rest-api-58ff5dd898-9trh2

kubectl get replicasets
kubectl get replicaset

kubectl scale deployment hello-world-rest-api --replicas=3
kubectl get pods
kubectl get replicaset
kubectl get events
kubectl get events --sort.by=.metadata.creationTimestamp

kubectl get rs
kubectl get rs -o wide
kubectl set image deployment hello-world-rest-api hello-world-rest-api=DUMMY_IMAGE:TEST
kubectl get rs -o wide
kubectl get pods
kubectl describe pod hello-world-rest-api-85995ddd5c-msjsm
kubectl get events --sort-by=.metadata.creationTimestamp

kubectl set image deployment hello-world-rest-api hello-world-rest-api=jdrepo/hello-world-rest-api:0.0.2.RELEASE
kubectl get events --sort-by=.metadata.creationTimestamp
kubectl get pods -o wide
kubectl delete pod hello-world-rest-api-67c79fd44f-n6c7l
kubectl get pods -o wide
kubectl delete pod hello-world-rest-api-67c79fd44f-8bhdt

kubectl get componentstatuses
kubectl get pods --all-namespaces

gcloud auth login
kubectl version
gcloud container clusters get-credentials jdrepoutes-cluster --zone us-central1-a --project solid-course-258105

kubectl set image deployment hello-world-rest-api hello-world-rest-api=jdrepo/hello-world-rest-api:0.0.4-SNAPSHOT

kubectl rollout history deployment hello-world-rest-api
kubectl set image deployment hello-world-rest-api hello-world-rest-api=jdrepo/hello-world-rest-api:0.0.4-SNAPSHOT --record

kubectl rollout history deployment hello-world-rest-api
kubectl rollout status deployment hello-world-rest-api
kubectl rollout undo deployment hello-world-rest-api --to-revision=3
kubectl rollout status deployment hello-world-rest-api
kubectl rollout undo deployment hello-world-rest-api --to-revision=3
kubectl rollout status deployment hello-world-rest-api
kubectl rollout history deployment hello-world-rest-api
kubectl get pods
kubectl logs hello-world-rest-api-67c79fd44f-d6q9z
kubectl logs hello-world-rest-api-67c79fd44f-d6q9z -f

kubectl get deployment hello-world-rest-api
kubectl get deployment hello-world-rest-api -o wide
kubectl get deployment hello-world-rest-api -o yaml
kubectl get deployment hello-world-rest-api -o yaml > deployment.yaml
kubectl get service hello-world-rest-api -o yaml
kubectl get service hello-world-rest-api -o yaml > service.yaml

kubectl delete all -l app=hello-world-rest-api
kubectl get all
kubectl apply -f deployment.yaml
kubectl get all

kubectl diff -f deployment.yaml 
kubectl apply -f deployment.yaml 
kubectl delete all -l app=hello-world-rest-api
kubectl get all -o wide

mvn clean install
docker push jdrepo/todo-web-application-h2:0.0.1-SNAPSHOT
kubectl delete all -l app=hello-world-rest-api

kubectl get pods
kubectl get pods --all-namespaces
kubectl get pods -l app=todo-web-application-h2
kubectl get pods -l app=todo-web-application-h2 --all-namespaces
kubectl get services --all-namespaces
kubectl get services --all-namespaces --sort-by=.spec.type
kubectl get services --all-namespaces --sort-by=.metadata.name
kubectl cluster-info
kubectl top node
kubectl top pod

kubectl get services
kubectl get svc
kubectl get ev
kubectl get rs

kubectl get ns
kubectl get nodes
kubectl get no
kubectl get po

docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:5.7
docker run -p 8080:8080 jdrepo/todo-web-application-mysql:0.0.1-SNAPSHOT
docker run -p 8080:8080 --link=mysql --env RDS_HOSTNAME=mysql jdrepo/todo-web-application-mysql:0.0.1-SNAPSHOT

docker-compose --version
docker-compose up

brew install kompose
kompose convert

kubectl delete all -l app=todo-web-application-h2

kubectl apply -f mysql-database-data-volume-persistentvolumeclaim.yaml,mysql-deployment.yaml,mysql-service.yaml
kubectl get svc
kubectl apply -f todo-web-application-deployment.yaml,todo-web-application-service.yaml
docker push jdrepo/todo-web-application-mysql:0.0.1-SNAPSHOT
kubectl logs todo-web-application-b65cc44d9-7h9pr -f

kubectl apply -f mysql-service.yaml
kubectl get pv
kubectl get pvc
kubectl describe pod/mysql-5ccbbbdcd8-5zjqg 

kubectl create configmap todo-web-application-config --from-literal=RDS_DB_NAME=todos
kubectl get configmap todo-web-application-config
kubectl describe configmap/todo-web-application-config

kubectl edit configmap/todo-web-application-config
kubectl scale deployment todo-web-application --replicas=0
kubectl scale deployment todo-web-application --replicas=1

kubectl edit configmap/todo-web-application-config
kubectl apply -f todo-web-application-deployment.yaml 
kubectl edit configmap todo-web-application-config
kubectl scale deployment todo-web-application --replicas=0
kubectl scale deployment todo-web-application --replicas=1

kubectl create secret generic todo-web-application-secrets --from-literal=RDS_PASSWORD=dummytodos
kubectl get secret/todo-web-application-secrets
kubectl describe secret/todo-web-application-secrets
kubectl apply -f todo-web-application-deployment.yaml 

kubectl delete -f mysql-database-data-volume-persistentvolumeclaim.yaml,mysql-deployment.yaml,mysql-service.yaml,todo-web-application-deployment.yaml,todo-web-application-service.yaml

apiVersion: v1
data:
  RDS_DB_NAME: todos
  RDS_HOSTNAME: mysql
  RDS_PORT: "3306"
  RDS_USERNAME: todos-user
kind: ConfigMap
metadata:
  name: todo-web-application-config
  namespace: default

cd /jdrepoutes/git/kubernetes-crash-course/04-currency-exchange-microservice-basic 
mvn clean install
docker push jdrepo/currency-exchange:0.0.1-RELEASE
kubectl apply -f deployment.yaml
curl 34.67.103.178:8000/currency-exchange/from/USD/to/INR

kubectl create configmap currency-conversion --from-literal=YOUR_PROPERTY=value --from-literal=YOUR_PROPERTY_2=value2

kubectl autoscale deployment currency-exchange --min=1 --max=3 --cpu-percent=10 
kubectl get events
kubectl get hpa
kubectl get hpa -o yaml
kubectl get hpa -o yaml > 01-hpa.yaml
kubectl get hpa currency-exchange -o yaml > 01-hpa.yaml

kubectl set image deployment hello-world-rest-api --image=jdrepo/hello-world-rest-api:0.0.4-SNAPSHOT
kubectl apply -f ingress.yaml
kubectl get ingress
kubectl describe gateway-ingress
kubectl describe gateway gateway-ingress
kubectl describe ingress gateway-ingress
kubectl apply -f rbac.yml
 
docker push jdrepo/currency-conversion:0.0.5-RELEASE

kubectl create configmap currency-conversion --from-literal=YOUR_PROPERTY=value --from-literal=YOUR_PROPERTY_2=value2

kubectl describe configmap/currency-conversion


kubectl label namespace default istio-injection=enabled

kubectl get svc --namespace istio-system
kubectl apply -f 01-helloworld-deployment.yaml 
kubectl apply -f 02-creating-http-gateway.yaml 
kubectl apply -f 03-creating-virtualservice-external.yaml 
kubectl get svc --namespace istio-system
kubectl get svc istio-ingressgateway --namespace istio-system
kubectl scale deployment hello-world-rest-api --replicas=4
kubectl delete all -l app=hello-world-rest-api
kubectl apply -f 04-helloworld-multiple-deployments.yaml 
kubectl apply -f 05-helloworld-mirroring.yaml 
kubectl apply -f 06-helloworld-canary.yaml 
watch -n 0.1 curl 35.223.25.220/hello-world

gcloud container clusters get-credentials jdrepoutes-cluster-istio --zone us-central1-a --project solid-course-258105
kubectl create namespace istio-system
curl -L https://git.io/getLatestIstio | ISTIO_VERSION=1.2.2 sh -
ls istio-1.2.2
ls istio-1.2.2/install/kubernetes/helm/istio-init/files/crd*yaml
cd istio-1.2.2
for i in install/kubernetes/helm/istio-init/files/crd*yaml; do kubectl apply -f $i; done
helm template install/kubernetes/helm/istio --name istio --set global.mtls.enabled=false --set tracing.enabled=true --set kiali.enabled=true --set grafana.enabled=true --namespace istio-system > istio.yaml
kubectl apply -f istio.yaml
kubectl get pods --namespace istio-system
kubectl get services --namespace istio-system


docker push jdrepo/currency-exchange:3.0.0-RELEASE
kubectl apply -f deployment.yaml 
kubectl apply -f 11-istio-scripts-and-configuration/07-hw-virtualservice-all-services.yaml 
kubectl get secret -n istio-system kiali
kubectl create secret generic kiali -n istio-system --from-literal=username=admin --from-literal=passphrase=admin
kubectl get svc --namespace istio-system


gcloud container clusters get-credentials helm-cluster --zone us-central1-a --project solid-course-258105
helm init
kubectl get deploy,svc tiller-deploy -n kube-system
clear
unzip 12-helm.zip
ls helm-tiller.sh
chmod +x helm-tiller.sh

gcloud container clusters get-credentials helm-cluster --zone us-central1-a --project solid-course-258105
./helm-tiller.sh
cat helm-tiller.sh 
kubectl get deploy,svc tiller-deploy -n kube-system
helm install ./currency-exchange/ --name=currency-services
helm install ./currency-conversion/ --name=currency-services-1
helm install ./currency-conversion/ --name=currency-services-3 --debug --dry-run
helm history currency-services-1
helm upgrade currency-services-1 ./currency-conversion/
helm rollback currency-services-1 1
helm upgrade currency-services-1 ./currency-conversion/ --debug --dry-run
helm upgrade currency-services-1 ./currency-conversion/
helm history currency-services-1

```

---
### Solace
#### **What is Solace?**

Solace is a messaging platform that facilitates event-driven architecture and real-time data transfer. It provides advanced message brokering capabilities, enabling systems to exchange information reliably and efficiently. Solace primarily uses **PubSub+**, its event-streaming platform, to manage and distribute data across hybrid and multi-cloud environments, microservices, IoT devices, and legacy applications.

#### **Key Features of Solace:**
1. **Event Broker:** Solace PubSub+ acts as a central event broker for publishing and subscribing to messages, supporting multiple protocols such as MQTT, AMQP, JMS, REST, and WebSocket.
2. **Hybrid Cloud Support:** It works seamlessly across on-premises, cloud, and edge environments.
3. **High Throughput and Low Latency:** Ideal for high-volume data transfer scenarios such as financial markets or IoT.
4. **Dynamic Message Routing:** Enables efficient routing based on topics or attributes.
5. **Advanced Features:** Includes replay, message persistence, guaranteed delivery, and message filtering.
6. **Developer-Friendly:** Solace provides rich APIs, SDKs, and tools for various programming languages and frameworks.


#### **Use Cases for Solace:**
1. **Event-Driven Microservices:**
   - Facilitates asynchronous communication between microservices.
   - Handles real-time events for scalable and decoupled architectures.

2. **IoT Applications:**
   - Collects, processes, and streams real-time IoT data.
   - Ensures reliable communication between devices and applications.

3. **Financial Services:**
   - Enables high-speed messaging for trading platforms, risk analytics, and market data distribution.

4. **E-commerce and Retail:**
   - Real-time inventory updates, order tracking, and personalized recommendations.

5. **Transportation and Logistics:**
   - Streams real-time data for fleet management, route optimization, and cargo tracking.

6. **Telecommunications:**
   - Handles signaling and event distribution for telecom systems.

Here is a detailed comparison between **Solace** and **Apache Kafka**, covering their key aspects and use cases to help you decide which one to use for specific scenarios.

#### Solace vs Kafka

##### **1. Overview**
- **Solace**: 
  - Enterprise-grade event broker designed for real-time, event-driven architectures.
  - Provides support for multiple messaging protocols (JMS, AMQP, MQTT, REST, WebSocket).
  - Focuses on dynamic message routing, hybrid cloud integration, and ease of use.

- **Apache Kafka**: 
  - Distributed event streaming platform.
  - Handles high-throughput, fault-tolerant data pipelines and event storage.
  - Built for large-scale applications requiring stream processing and durable event logs.



##### **2. Architecture**
- **Solace**:
  - Centralized architecture with brokers acting as a messaging backbone.
  - Implements dynamic message routing with topics and message attributes.
  - Focuses on real-time, low-latency communication.

- **Kafka**:
  - Distributed architecture with brokers and partitions for horizontal scaling.
  - Stores events in durable logs for replayability and processing.
  - Designed for long-term storage of data streams.


##### **3. Protocol Support**
- **Solace**: 
  - Supports multiple protocols, including MQTT, AMQP, JMS, REST, WebSocket, and proprietary protocols.
  - Suitable for diverse ecosystems and IoT use cases.

- **Kafka**: 
  - Primarily supports Kafka’s proprietary protocol.
  - Integration with external systems often requires Kafka Connect or custom adapters.



##### **4. Message Delivery**
- **Solace**:
  - Offers guaranteed message delivery with persistent queues.
  - Implements message filtering and fan-out using topics or headers.
  - Designed for low-latency, high-reliability messaging.

- **Kafka**:
  - Provides at-least-once, at-most-once, or exactly-once delivery semantics.
  - Focuses on durable event storage, enabling replay of messages.
  - Best suited for high-throughput use cases requiring reliable delivery.



##### **5. Latency**
- **Solace**:
  - Optimized for ultra-low latency in real-time systems.
  - Suitable for financial markets, IoT, and event-driven microservices.

- **Kafka**:
  - Generally higher latency than Solace but optimized for throughput.
  - Ideal for use cases like data pipelines and event streaming.



##### **6. Scalability**
- **Solace**:
  - Scales vertically and horizontally but is more centralized.
  - Designed for hybrid-cloud and on-premises environments.

- **Kafka**:
  - Highly scalable with distributed architecture.
  - Ideal for handling large-scale, high-volume event streams.

---

### **7. Storage**
- **Solace**:
  - Does not focus on long-term storage of messages.
  - Messages are typically transient, though persistence is available for short-term storage.

- **Kafka**:
  - Built for durable, long-term event storage.
  - Enables replayability and event sourcing for up to months or years.



##### **8. Ecosystem and Tools**
- **Solace**:
  - Provides PubSub+ Cloud for hybrid environments.
  - Offers developer-friendly APIs and tools for integration.

- **Kafka**:
  - Ecosystem includes Kafka Streams, KSQL, Kafka Connect, and integration with tools like Apache Flink, Spark, etc.
  - Strong community support and wide adoption.



##### **9. Deployment**
- **Solace**:
  - Deployable in hybrid, multi-cloud, on-premises, or edge environments.
  - Managed service available via Solace PubSub+ Cloud.

- **Kafka**:
  - Requires management of brokers, zookeepers, and partitions unless using managed services (e.g., Confluent Cloud, AWS MSK).
  - Focuses on distributed deployment.



##### **10. Ease of Use**
- **Solace**:
  - Easier to configure and use for real-time communication.
  - Provides ready-to-use management dashboards.

- **Kafka**:
  - Steeper learning curve, especially for managing partitions and ensuring fault tolerance.
  - Requires expertise to set up and manage.



##### **11. Pricing**
- **Solace**:
  - Enterprise product with subscription costs.
  - Offers both managed (cloud-based) and self-hosted options.

- **Kafka**:
  - Open-source, but requires infrastructure and maintenance costs.
  - Commercial support available through Confluent.



##### **12. Typical Use Cases**
| **Scenario**                    | **Recommended Tool**                | **Reason**                                           |
|----------------------------------|-------------------------------------|-----------------------------------------------------|
| **High-throughput data pipelines** | Kafka                               | Designed for large-scale event streaming and storage. |
| **Event-driven microservices**    | Solace                              | Optimized for real-time, low-latency communication. |
| **Hybrid or multi-cloud setups**  | Solace                              | Seamless integration with hybrid cloud environments. |
| **Real-time financial systems**   | Solace                              | Offers ultra-low latency, essential for trading systems. |
| **IoT applications**              | Solace                              | Protocol support (MQTT) and low-latency messaging.   |
| **Stream processing**             | Kafka                               | Strong support for data transformations and analytics. |
| **Long-term event storage**       | Kafka                               | Durable log storage with replay capabilities.       |



##### **When to Choose Solace**
- You need **real-time, low-latency messaging** for mission-critical systems.
- You work in a **hybrid cloud or multi-cloud environment**.
- Your use case requires support for **multiple protocols** like MQTT, JMS, or AMQP.
- You're developing applications in **IoT, financial markets, or logistics**.

##### **When to Choose Kafka**
- You require **high-throughput, durable event storage** for data pipelines.
- Your architecture involves **distributed stream processing**.
- You need **event replay** and historical data retention.
- Your system scales to handle **millions of events per second** across a cluster.



##### **Conclusion**
- **Solace** is better suited for **real-time, event-driven architectures** with diverse protocol needs, hybrid environments, and low latency.
- **Kafka** excels in **stream processing**, durable storage, and high-throughput use cases. 



----
### Flume

---

### Airflow

