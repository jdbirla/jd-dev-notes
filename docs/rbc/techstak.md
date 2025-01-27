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

----
### Flume

---

### Airflow

