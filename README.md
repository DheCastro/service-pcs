# service-pcs
Monorepo with microsservices using Java 17 and native compilation with GraalVM

To run this tutorial, I used the following tools:

Docker Desktop - 4.15.0 (93002)
https://www.docker.com/products/docker-desktop/

Docker Engine - 20.10.21 (docker -v)
Installed along with Docker Desktop

Docker Compose - 2.13.0 (docker-compose -v)
Installed along with Docker Desktop

Kubernetes - 1.25.2 (kubectl version)
To enable Kubernetes, just access the Docker Desktop settings and in the Kubernetes tab, check the "Enable Kubernetes" option.
https://docs.docker.com/desktop/kubernetes/#enable-kubernetes

Kubernetes Dashboard - 2.4.0
https://github.com/kubernetes/dashboard/releases/tag/v2.4.0

To install the kubernetes dashboard (kubernetes-dashboard namespace), run the command:
kubectl apply/delete -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.4.0/aio/deploy/recommended.yaml

To create an access account and give permission on the k8s server:
kubectl apply/delete -f k8s-dashboard-admin.yml

To create a kubernetes dashboard access token:
kubectl apply/delete -f k8s-dashboard-admin-token.yml

To display the access token:
kubectl describe secrets admin-sa-token -n kubernetes-dashboard

To launch the dashboard:
kubectl proxy

Dashboard access address:
http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/
