# Service-PCS (Professionals, Clients and Services)
Monorepo with microsservices using Java 17 and native compilation with GraalVM

### To run this tutorial, I used the following tools:

- Docker Desktop - 4.15.0 (93002)
https://www.docker.com/products/docker-desktop/

- Docker Engine - 20.10.21 (docker -v) <br />
_Installed along with Docker Desktop_

- Docker Compose - 2.13.0 (docker-compose -v) <br />
_Installed along with Docker Desktop_

- Kubernetes - 1.25.2 (kubectl version)
To enable Kubernetes, just access the Docker Desktop settings and in the Kubernetes tab, check the "Enable Kubernetes" option.
https://docs.docker.com/desktop/kubernetes/#enable-kubernetes

- Kubernetes Dashboard - 2.4.0
https://github.com/kubernetes/dashboard/releases/tag/v2.4.0

### Building and Running application:

- **Traditional mode (JIT compilation)** <br />
**Build:** `$ mvn clean install` <br />
**Run:** from your preferred IDE (STS, Intellij...)
> Result traditional compilation (just in time)
![](/professional-service/src/main/resources/images/professional_service_normal_start.PNG)

- **Native executable (AOT compilation)** <br />
**Build:** `$ mvn clean install -Pnative` <br />
**Run:** inside the target folder, run the .exe (Windows)
> Result native compilation (ahead of time)
![](/professional-service/src/main/resources/images/professional_service_native_start.PNG)

- **Docker Image with native binary** <br />
**Build:** `$ mvn clean install -Pdocker` <br />
**Run:** `$ docker run -p 8080:8080 example-service`
> Result native compilation to docker image
![](/professional-service/src/main/resources/images/professional_service_native_docker_start.PNG)

### When deploying the application, you can verify the deployment and pods through the Kubernetes dashboard. Including expansion and reduction of the service as well:

- To install the kubernetes dashboard (kubernetes-dashboard namespace), run the command: <br />
`$ kubectl apply/delete -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.4.0/aio/deploy/recommended.yaml`

- To create an access account and give permission on the k8s server:
`$ kubectl apply/delete -f k8s-dashboard-admin.yml`

- To create a kubernetes dashboard access token:
`$ kubectl apply/delete -f k8s-dashboard-admin-token.yml`

- To display the access token:
`$ kubectl describe secrets admin-sa-token -n kubernetes-dashboard`

- To launch the dashboard:
`$ kubectl proxy`

- Dashboard access address:
http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/
