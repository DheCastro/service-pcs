# Service-PCS (Professionals, Clients and Services)
Monorepo with microsservices using **JAVA 17** and **GraalVM** to native compilation

### To run this tutorial, I used the following tools:

### Basic Setup

+ **GraalVM for JAVA 17:** <br /> 
https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-22.3.0/graalvm-ce-java17-windows-amd64-22.3.0.zip
<br /> Other versions can be found here: https://github.com/graalvm/graalvm-ce-builds/releases

    + Set GraalVM root directory in **_JAVA_HOME_** env var
    + Create **_GRAALVM_HOME_** with the same value as **_JAVA_HOME_** (GraalVM root directory)
    + Add **_%GRAALVM_HOME%\bin_** to the **_PATH_** env
    
Check configuration in terminal with command: `$ java -version`    
> You must see something like this
![](/professional-service/src/main/resources/images/graalvm_config.PNG)

+ **Apache Maven 3:** <br />
https://archive.apache.org/dist/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.zip
<br /> Other versions can be found here: https://archive.apache.org/dist/maven/maven-3/
<br /> **Oficial Page:** https://maven.apache.org/download.cgi

    + Set Maven root directory in **_M2_HOME_** env var
    + Add **_%M2_HOME%\bin_** to the **_PATH_** env

Check configuration in terminal with command: `$ mvn -v`
> You must see something like this
![](/professional-service/src/main/resources/images/maven_config.PNG)

### More Settings (Docker and K8s)

- **Docker Desktop** - v4.15.0: (93002): <br />
https://www.docker.com/products/docker-desktop/

- **Docker Engine** - v20.10.21: (docker -v) <br />
_Installed along with Docker Desktop_

- **Docker Compose** - v2.13.0: (docker-compose -v) <br />
_Installed along with Docker Desktop_

- **Kubernetes** - v1.25.2: (kubectl version)
To enable Kubernetes, just access the Docker Desktop settings and in the Kubernetes tab, check the "Enable Kubernetes" option.
https://docs.docker.com/desktop/kubernetes/#enable-kubernetes

- **Kubernetes Dashboard** - v2.4.0: <br />
https://github.com/kubernetes/dashboard/releases/tag/v2.4.0

### Building and Running application:

- **Traditional mode (JIT compilation)** <br />
**Build:** `$ mvn clean install` <br />
**Run:** from your preferred IDE (STS, Intellij...)
> Result traditional compilation (just in time) - **EXECUTION TIME ~2.4 seconds**
![](/professional-service/src/main/resources/images/professional_service_normal_start.PNG)

- **Native executable (AOT compilation)** <br />
**Build:** `$ mvn clean install -Pnative` <br />
**Run:** inside the target folder, run the .exe (Windows)
> Result native compilation (ahead of time) - **EXECUTION TIME ~0.2 seconds**
![](/professional-service/src/main/resources/images/professional_service_native_start.PNG)

- **Docker Image with native binary** <br />
**Build:** `$ mvn clean install -Pdocker` <br />
**Run:** `$ docker run -p 8080:8080 example-service`
> Result native compilation to docker image - **EXECUTION TIME ~0.1 seconds**
![](/professional-service/src/main/resources/images/professional_service_native_docker_start.PNG)

### When deploying the application, you can verify the deployment and pods through the Kubernetes dashboard. Including expansion and reduction of the service as well:

_Note: in the commands below, use apply to provision resources and delete to remove them_

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
