# ECO-Techstacks
## Technologies:  Java, SpringBoot, Docker, Kubernetes, solace, flume,  airflow

### Kubernetes

- https://kubernetes.io/docs/reference/kubectl/quick-reference/
  

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
###  Your application runs in Kubernetes, but users report they cannot access it. What do you do?”
#### Step 1: Check Pod Health and Logs
- The first step in troubleshooting any Kubernetes issue is to confirm that the pod is running and behaving as expected.

- What I Look For in a Candidate’s Answer:

- Good candidates will immediately check the pod status using Kubectl commands and review the logs for errors.

- Commands to Check Pod Health:
![image](https://github.com/user-attachments/assets/44279745-4277-4c81-becd-607f2b675069)
- What to Look For in Logs:
- Application errors.
- Connection timeout or database-related issues.
![image](https://github.com/user-attachments/assets/fbacbee2-1283-4024-9c8a-cc5d322bee20)
#### Step 2: Verify Service Configuration

- Ignorance of Kubernetes Services is the problem — most candidates fail even to consider them a potential source of issues. A misconfigured service will prevent the traffic from reaching the pods.

- The best candidates will mention checking the service type (ClusterIP, NodePort, LoadBalancer, etc.) and ensuring it’s properly configured to direct the traffic to the pods
![image](https://github.com/user-attachments/assets/e752cdd4-ba7f-4099-8cce-6a33e7405b0b)

- Things to Check:

![image](https://github.com/user-attachments/assets/fa1ee221-8134-476a-bf45-3706aaca678e)

  - Is the correct port exposed?
  - Is the service selector matching the pod labels?

![image](https://github.com/user-attachments/assets/e6aa291f-8182-4b36-a3ff-11a06d830c27)

#### Step 3: Examine Network Policies
- Knowing this, candidates with experience will know that network policies may block the traffic to the pods, especially in environments with high-security compliance.

- What I Look for in a Candidate’s Response:

- Experience candidates should acknowledge the network policies that may limit the traffic flow and recognize them as a part of the system architecture.

![image](https://github.com/user-attachments/assets/da09ece4-364e-4ec0-8910-111b4a7c7aae)
- Ensure the policies allow traffic to the application port from the expected sources.
![image](https://github.com/user-attachments/assets/6b9459bc-2820-42f3-a778-00f783d7b7f1)

#### Step 4: Investigate Ingress and DNS
- For domain name-based applications, the Ingress controllers or DNS can cause connectivity issues. Candidates who mention Ingress and DNS for troubleshooting will stand out among candidates.
- What I Look For in a Candidate’s Answer:

- I appreciate candidates asking whether an Ingress resource is being used and whether DNS records are correctly configured.
![image](https://github.com/user-attachments/assets/c4fc55da-8c86-4535-86ca-dd4a5a75643a)

- Verify that:

- The Ingress resource points to the correct service.
- SSL/TLS certificates are valid (if applicable).
- DNS Troubleshooting:
- Use tools like nslookup or dig to confirm that the domain resolves to the correct IP address.
![image](https://github.com/user-attachments/assets/53eaa87a-6597-4634-9d3e-915fdb51e51f)
#### Step 5: Validate Node and Cluster Health
- The problem can sometimes be with nodes or cluster configuration. Some candidates with deep Kubernetes experience will also check the health of nodes and the cluster.
- What I Look For in a Candidate’s Answer:
- Checking the node and cluster status using Kubectl and cloud provider dashboards (AWS, GCP) should be mentioned by candidates.
![image](https://github.com/user-attachments/assets/71f31f14-7eef-4c07-8b4b-33df79e9f33b)

- Things to Look For:

  - Resource constraints (CPU, memory).
  - Node taints and tolerations.
#### Step 6: Debug with Port Forwarding
- As a last resort, I appreciate the candidates who know how to debug competent Kubectl in port-forward troubleshooting. This bypasses Ingress and Services to connect directly to the pod.

-  What I Look For in a Candidate’s Answer:
-  I value candidates who suggest port forwarding as a quick way to isolate whether the issue lies with the application or the Kubernetes configuration.
![image](https://github.com/user-attachments/assets/3bb08770-871e-42a5-9ca2-0cdf180cfd65)

#### Step 7: Monitor with Tools
- To find the best candidates, I would recommend asking them about the tools they have used to gather information about the state of a cluster, such as Prometheus, Grafana or the Kubernetes dashboard.

- What I Look For in a Candidate’s Answer:
- I look for candidates who suggest using dashboards and alerts to stay proactive.

- Tools to Monitor Scaling:

  - Prometheus/Grafana: For detailed metrics and visualizations.
  - Kubernetes Dashboard: For real-time insights.
  - Cloud Provider Monitoring Tools: AWS CloudWatch, GCP Monitoring, etc.
![image](https://github.com/user-attachments/assets/6347c4ca-5ba2-4cf8-a2b0-e09a5cf77797)
![image](https://github.com/user-attachments/assets/b6917599-3f70-4a47-aee4-106767170f5e)
![image](https://github.com/user-attachments/assets/79773acd-7317-4cb7-b126-e198ffc4b694)

#### Closing Thought
- When I ask candidates how they would troubleshoot connectivity issues in Kubernetes, I am not looking for technical knowledge alone. I am looking for methodical thinking, real-world experience, and a good understanding of Kubernetes fundamentals.

-  These steps will help you stand out when interviewing or developing your Kubernetes skills. The next time someone asks, ‘Why can’t users access your Kubernetes application?’ you will be ready with the perfect answer.


---
### Explanation of AMQP, JMS, MQTT, OpenMAMA, and REST Protocol

#### **1. Advanced Message Queuing Protocol (AMQP)**
- **Description**: AMQP is an open standard application-layer protocol for message-oriented middleware. It facilitates reliable, asynchronous, and decoupled communication between systems.
- **Use Case**: Used in financial services, IoT systems, and messaging platforms where reliability, guaranteed delivery, and security are crucial.
- **Example**: RabbitMQ and Apache Qpid implement AMQP.



#### **2. Java Message Service (JMS)**
- **Description**: JMS is a Java API specification for message-oriented middleware. It defines a standard for sending and receiving messages within Java applications.
- **Use Case**: Suitable for Java-based applications in enterprise environments, often in combination with application servers (e.g., WebLogic, JBoss).
- **Example**: Used in banking systems for transaction notifications or inventory updates in e-commerce platforms.



#### **3. Message Queuing Telemetry Transport (MQTT)**
- **Description**: MQTT is a lightweight, publish-subscribe messaging protocol for small, low-powered devices with low bandwidth requirements.
- **Use Case**: Ideal for IoT applications, smart devices, and mobile messaging where bandwidth and power are constrained.
- **Example**: Smart home systems, telemetry in connected vehicles.



#### **4. Open Middleware Agnostic Messaging API (OpenMAMA)**
- **Description**: OpenMAMA is an open-source messaging API for middleware-agnostic data distribution. It is used to standardize messaging in financial trading systems.
- **Use Case**: High-performance, low-latency messaging in financial services, particularly for trading platforms and market data distribution.
- **Example**: Used by trading firms to integrate multiple middleware solutions with consistent APIs.



#### **5. REST Protocol (Representational State Transfer)**
- **Description**: REST is a lightweight architectural style for designing networked applications using HTTP for communication. It is resource-oriented and stateless.
- **Use Case**: Commonly used in web services, APIs, and microservices for CRUD (Create, Read, Update, Delete) operations.
- **Example**: RESTful APIs in e-commerce platforms, social media apps, or any web-based service.



#### **Comparison of AMQP, JMS, MQTT, OpenMAMA, and REST Protocol**

| **Feature**             | **AMQP**                              | **JMS**                             | **MQTT**                                | **OpenMAMA**                           | **REST Protocol**                      |
|--------------------------|----------------------------------------|--------------------------------------|-----------------------------------------|----------------------------------------|----------------------------------------|
| **Type**                | Open messaging protocol                | Java API specification               | Lightweight messaging protocol          | Middleware-agnostic API                | Architectural style for APIs           |
| **Transport Protocol**  | TCP                                   | TCP                                  | TCP/IP                                 | Middleware-dependent                   | HTTP                                   |
| **Message Model**       | Message queues, pub/sub               | Message queues, pub/sub              | Publish/Subscribe                       | Middleware-based messaging             | Request/Response                       |
| **Message Size**        | Large to medium                       | Large to medium                      | Small                                   | Medium to large                        | Flexible (depends on HTTP payload)     |
| **Reliability**         | High (acknowledgments, durable queues)| High (transactional support)         | Moderate (QoS levels)                   | High (financial-grade reliability)     | Depends on HTTP and server setup       |
| **Security**            | TLS, SASL                             | Application-level security (via JCA) | TLS                                    | Middleware-specific security           | HTTPS, OAuth                          |
| **Programming Language**| Language-agnostic                     | Java only                            | Language-agnostic                       | C/C++ (primary)                        | Language-agnostic                      |
| **Latency**             | Low                                   | Moderate                             | Very low                                | Ultra-low                              | Moderate                               |
| **Scalability**         | High                                  | High                                 | High                                   | High                                   | Moderate to High (via RESTful APIs)    |
| **Use Cases**           | Financial services, IoT, messaging    | Enterprise Java applications         | IoT, mobile apps, telemetry             | Financial market data, trading systems | Web services, APIs, microservices      |
| **Examples**            | RabbitMQ, Apache Qpid                 | ActiveMQ, WebLogic JMS               | HiveMQ, Mosquitto                       | Bloomberg OpenMAMA                     | RESTful APIs for web and mobile apps   |



#### **When to Use Each Protocol**

| **Protocol** | **When to Use**                                                                                                       |
|--------------|---------------------------------------------------------------------------------------------------------------------|
| **AMQP**     | When you need reliable, secure, and asynchronous messaging with features like acknowledgments and routing.           |
| **JMS**      | For Java-based enterprise applications where standard Java APIs and integration with app servers are required.       |
| **MQTT**     | In IoT and mobile applications requiring lightweight messaging and low power consumption.                           |
| **OpenMAMA** | For financial trading platforms needing high-performance, low-latency middleware integration.                       |
| **REST**     | For building stateless APIs in web and microservice architectures with flexible and easy-to-consume endpoints.       |


---

### Solace

[solace](https://jdbirla-dev-notes.netlify.app/rbc/solace/)

----

### Flume
[flume](https://jdbirla-dev-notes.netlify.app/rbc/flume/)

---

### Airflow

[airflow](https://jdbirla-dev-notes.netlify.app/rbc/airflow/)

---

### James

[james](https://jdbirla-dev-notes.netlify.app/rbc/james/)

---

### githubactions
[githubactions](https://jdbirla-dev-notes.netlify.app/rbc/githubactions/)

----
### all
[all-ip](https://jdbirla-dev-notes.netlify.app/rbc/JD_IP_All_Together-master.7z)
[all-ip](https://jdbirla-dev-notes.netlify.app/rbc/myfileq.txt)
[jdfile](https://jdbirla-dev-notes.netlify.app/rbc/jdfile.txt)