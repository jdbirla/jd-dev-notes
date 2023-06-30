# FSP Deployment Steps
- Elastic Beans talk, ECS, EC2, RDS
- ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/51c0753e-0ecf-414a-80cc-17ab82758942)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/f1fda7e6-8768-4155-990e-7fb79382b55b)



## EC2 Generate New Key Pair 
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/db148d3a-fbae-4f80-aa98-9ad6d8a773e2)
- Download .pem file [private key]

##  Getting Started With Elastic Beanstalk 
### Create application deploy manually
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/ba5777d9-701b-4057-8e90-65e4c67d3215)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/e8c5f487-5780-4cf6-b793-d8e57de8d3b4)
- https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/create_deploy_docker_ecs.html
- Dockerrun.aws.json
```json
{
  "AWSEBDockerrunVersion": 2,
  "containerDefinitions": [
    {
      "name": "amigoscode-api",
      "image": "amigoscode/amigoscode-api:latest",
      "essential": true,
      "memory": 512,
      "portMappings": [
        {
          "hostPort": 80,
          "containerPort": 8080
        }
      ],
      "environment": [
        {
          "name": "SPRING_DATASOURCE_URL",
          "value": "jdbc:postgresql://TODO:5432/customer"
        }
      ]
    }
  ]
}
```
- uplaod the Dockerrun.aws.json 
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/1d41c6ca-bfb6-47b2-8852-a8d3b4fbf192)
- follow other steps to create application
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/0d6ad88b-a1fc-49d3-9a27-fdeb47fd9ca8)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3ff26c05-6784-4e00-9b0a-8eb0b0ab03ff)
![image](https://github.com/jdbirla/JD_FSP/assets/69948118/8d7c899f-ff69-43df-9490-70d12b02d888)
![image](https://github.com/jdbirla/JD_FSP/assets/69948118/59bf6736-4ff8-4bba-8ecf-10a6cc02e6c8)

- Application will be created
- Resource will be created: EBS, ECS, EC2, RDS
- As of now  DB won't connect becasue we didn't provide the correct host for DB
### Change the DB host
- update DB host into Dockerrun.aws.json
- upload and deploy updated Dockerrun.aws.json 
- We are getting error database "customer" doesn't exists
  
### Create Customer DB
- SSH into EC2 machine and using ec2 maching we will connect postgress db and create customer db
`ssh -i your-private-key.pem ec2-user@instance-public-ip-address`
- ssh "permissions are too open" 🤔

The error message "permissions are too open" occurs when the permissions on your SSH key files are too permissive, meaning they allow read or write access to users who should not have access. This can happen when the file permissions are set to 777 or similar values.
To fix this error, you can change the permissions on the SSH key files using the following command in your terminal:
```
chmod 600 <path-to-ssh-key>
```

This command sets the permissions on the SSH key file to 600, which means that only the owner of the file has read and write access, and no one else can read or write to the file.
If you still get the error message after changing the file permissions, you may also need to check the permissions on the directory that contains the SSH key files. The directory should have permissions set to 700, which means that only the owner can read, write, and access the directory.
```
chmod 700 <path-to-directory>
```

After changing the permissions on both the SSH key files and the directory that contains them, try connecting to your SSH server again. The error message should no longer appear.

- Windows Users

- To SSH to an EC2 instance on Windows, you can follow these steps:

    Download and install PuTTY, a free and open-source SSH client for Windows.
    Open PuTTY and enter the public DNS or IP address of your EC2 instance in the "Host Name (or IP address)" field.
    Under the "Connection" tab, select "SSH" and "Auth".
    Under "Auth", click "Browse" and select the private key file (.pem) for your EC2 instance.
    Go back to the "Session" tab, and give your session a name under "Saved Sessions", and click "Save".
    Click "Open" to start the SSH connection.
    If this is your first time connecting to the instance, you may see a security alert. Click "Yes" to continue.
    You should now be connected to your EC2 instance via SSH and can run commands in the terminal.

Alternatively, you can use the Windows Subsystem for Linux (WSL) to SSH to your EC2 instance. WSL provides a Linux-compatible kernel interface to Windows, allowing you to run Linux commands natively on Windows. You can follow these steps:

    Install WSL on your Windows machine.
    Install an SSH client on your WSL distribution. For example, you can install OpenSSH by running the command sudo apt-get install openssh-client.
    Follow the steps above to SSH to your EC2 instance, but use the SSH client installed in your WSL distribution instead of PuTTY.

Let me know if you get stuck
- We will connect using mobaxtream and SSH into EC2
- SSH into ec2 for postgresql connection
```sh
sudo -i
docker run --rm -it postgres:alpine bash
psql -U amigoscode -h host -d postgres 
or
psql -U amigoscode -h host -d ebdb
create database customer;
docker ps
docker logs -f container-id
```
- JD Practice
- **As We need to connect postgress DB we need `psql` client there are two way for this either we can install psql in EC2 using
  `sudo apt update
sudo apt install postgresql-client` or we can run docker image of postgress DB and bash into enter into psql**


```sh

[ec2-user@ip-172-31-14-241 ~]$ sudo -i
[root@ip-172-31-14-241 ~]# docker ps


docker run --rm -it postgres:alpine bash
Unable to find image 'postgres:alpine' locally
alpine: Pulling from library/postgres
08409d417260: Pull complete
6450d4e89514: Pull complete
fb127fe040bf: Pull complete
e07c05a5a317: Pull complete
14a4a63fb0e0: Pull complete
fd170937e677: Pull complete
3597d3193ab4: Pull complete
09ed13dfda56: Pull complete
Digest: sha256:bb2769783686897b370c061b4ad1aac5a819bccec7945d03c3b45a9b077bcea0
Status: Downloaded newer image for postgres:alpine
855e40190f4c:/# psql -U amigoscode -d postgres \
> -h awseb-e-3jehispapr-stack-awsebrdsdatabase-yfimkboo5dgu.creha7e2qzbs.ap-south-1.rds.amazonaws.com
Password for user amigoscode:
psql (15.3)
SSL connection (protocol: TLSv1.2, cipher: ECDHE-RSA-AES256-GCM-SHA384, compression: off)
Type "help" for help.

postgres=> \l
                                                    List of databases
   Name    |   Owner    | Encoding |   Collate   |    Ctype    | ICU Locale | Locale Provider |     Access privileges
-----------+------------+----------+-------------+-------------+------------+-----------------+---------------------------
 ebdb      | amigoscode | UTF8     | en_US.UTF-8 | en_US.UTF-8 |            | libc            |
 postgres  | amigoscode | UTF8     | en_US.UTF-8 | en_US.UTF-8 |            | libc            |
 rdsadmin  | rdsadmin   | UTF8     | en_US.UTF-8 | en_US.UTF-8 |            | libc            | rdsadmin=CTc/rdsadmin    +
           |            |          |             |             |            |                 | rdstopmgr=Tc/rdsadmin
 template0 | rdsadmin   | UTF8     | en_US.UTF-8 | en_US.UTF-8 |            | libc            | =c/rdsadmin              +
           |            |          |             |             |            |                 | rdsadmin=CTc/rdsadmin
 template1 | amigoscode | UTF8     | en_US.UTF-8 | en_US.UTF-8 |            | libc            | =c/amigoscode            +
           |            |          |             |             |            |                 | amigoscode=CTc/amigoscode
(5 rows)

ostgres=> create database customer;
CREATE DATABASE
postgres=> \l
                                                    List of databases
   Name    |   Owner    | Encoding |   Collate   |    Ctype    | ICU Locale | Locale Provider |     Access privileges
-----------+------------+----------+-------------+-------------+------------+-----------------+---------------------------
 customer  | amigoscode | UTF8     | en_US.UTF-8 | en_US.UTF-8 |            | libc            |
 ebdb      | amigoscode | UTF8     | en_US.UTF-8 | en_US.UTF-8 |            | libc            |
 postgres  | amigoscode | UTF8     | en_US.UTF-8 | en_US.UTF-8 |            | libc            |
 rdsadmin  | rdsadmin   | UTF8     | en_US.UTF-8 | en_US.UTF-8 |            | libc            | rdsadmin=CTc/rdsadmin    +
           |            |          |             |             |            |                 | rdstopmgr=Tc/rdsadmin
 template0 | rdsadmin   | UTF8     | en_US.UTF-8 | en_US.UTF-8 |            | libc            | =c/rdsadmin              +
           |            |          |             |             |            |                 | rdsadmin=CTc/rdsadmin
 template1 | amigoscode | UTF8     | en_US.UTF-8 | en_US.UTF-8 |            | libc            | =c/amigoscode            +
           |            |          |             |             |            |                 | amigoscode=CTc/amigoscode
(6 rows)

postgres=> ^D\q  (ctrl +d)
855e40190f4c:/#

[root@ip-172-31-14-241 ~]# docker ps
CONTAINER ID   IMAGE                            COMMAND                  CREATED          STATUS                    PORTS                                   NAMES
a735406e0163   jbirla/spring-boot-api:latest    "java -cp @/app/jib-…"   24 seconds ago   Up 23 seconds             0.0.0.0:80->8080/tcp, :::80->8080/tcp   ecs-awseb-Jdbirla-backend-env-3jehispapr-2-jdbirla-api-e48383e4a5a69bd96800
6f472f69f2fa   amazon/amazon-ecs-agent:latest   "/agent"                 36 minutes ago   Up 36 minutes (healthy)                                           ecs-agent
[root@ip-172-31-14-241 ~]#

02ba955c4fa9:/# psql -U amigoscode -d customer -h awseb-e-3jehispapr-stack-awsebrdsdatabase-yfimkboo5dgu.creha7e2qzbs.ap-south-1.rds.amazonaws.com
Password for user amigoscode:
psql (15.3)
SSL connection (protocol: TLSv1.2, cipher: ECDHE-RSA-AES256-GCM-SHA384, compression: off)
Type "help" for help.

customer=> select * from customer;
 id |       name       |              email              | age
----+------------------+---------------------------------+-----
  1 | Kelsie Abernathy | kelsie.abernathy@amigoscode.com |  23
(1 row)

```

## Deploy Automatically using Github Actions
### CI
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/7c9687a9-96fc-4576-941e-dd3d9cff550a)
- create folder  `.github\workflows` in repo
- Create `backend-ci.yml` file
- JD
```yml
name: CI - Build Backend

on:
  pull_request:
    branches:
      - master
    paths:
      - spring-boot-example/**

jobs:
  build:
    runs-on: ubuntu-latest
    services:
      # Label used to access the service container
      postgres:
        # Docker Hub image
        image: postgres:15.3
        # Provide the password for postgres
        env:
          POSTGRES_USER: amigoscode
          POSTGRES_PASSWORD: password
          POSTGRES_DB: customer
        ports:
          - 5332:5432
          # Set health checks to wait until postgres has started
        options: >-
          --health-cmd pg_isready
          --health-interval 10s
          --health-timeout 5s
          --health-retries 5
    defaults:
      run:
        working-directory: ./spring-boot-example
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'
      - name : Build and run Unit/Integration Test with Maven
        run: mvn -ntp -B verify
```
- Commit and push this workflow into github
- Create new branch `git checkout -b testing-ci-build-workflow`
- Now commit this changes into this new branch and push
- create pull request from new branch to master branch
 ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3c62bb80-57b0-4122-a87e-4503637ff9db)
- The work flow will start automatically

 ### CD
 ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/9c62cc4a-1010-44b6-aae7-c0a3f8d53f47)
- create file into workflow `backend-cd.yaml`
- Follow these steps and create Dockerhub access token https://docs.docker.com/docker-hub/access-tokens/
- Then add the following as Secrets in Github. Follow steps here https://docs.github.com/en/actions/security-guides/encrypted-secrets#creating-encrypted-secrets-for-a-repository
```
    DOCKERHUB_USERNAME = your username
    DOCKERHUB_ACCESS_TOKEN = you access token from step 1
```
```
date '+%d.%m.%Y.%H.%M.%S'
```
- Creating new users for deployment
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/121a3208-4f49-483a-8ad0-d17a20405eaf)
- Create a group and attache permission to group
- AWS Permissions
- It should be enough for your AWS user to have the policies AWSElasticBeanstalkWebTier and AWSElasticBeanstalkManagedUpdatesCustomerRolePolicy attached to be able to deploy your project.
![image](https://github.com/jdbirla/JD_FSP/assets/69948118/021fc460-3efa-4065-91b4-58ecc73ebfa3)
![image](https://github.com/jdbirla/JD_FSP/assets/69948118/d7b115e7-de7b-4b87-af73-68c22dce178e)
- download access key and secrek key
- Create github secrets
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/60ab6550-9e94-45b5-b515-fbff4c3c8aa9)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/dfc867ca-51fd-4675-8184-2ae37c9e75e1)
- Add secrets for EB_APPLICATION_NAME , EB_ENVIRONMENT_NAME and EB_REGION
- Commit some change in master and push
- CD job will start automatically



### JD Slack Integration
- JD slack integration CD
```yml
name: CD - Deploy Backend

on:
  workflow_dispatch:
  push:
    branches:
      - master
    paths:
      - spring-boot-example/**

jobs:
  build:
    runs-on: ubuntu-latest
    services:
      # Label used to access the service container
      postgres:
        # Docker Hub image
        image: postgres:15.3
        # Provide the password for postgres
        env:
          POSTGRES_USER: amigoscode
          POSTGRES_PASSWORD: password
          POSTGRES_DB: customer
        ports:
          - 5332:5432
          # Set health checks to wait until postgres has started
        options: >-
          --health-cmd pg_isready
          --health-interval 10s
          --health-timeout 5s
          --health-retries 5
    defaults:
      run:
        working-directory: ./spring-boot-example
    steps:
      - uses: actions/checkout@v3
      - name: Slack commit message and sha
        run: >
            curl -X POST -H 'Content-type: application/json'
            --data '{"text":":github: https://github.com/amigoscode/spring-boot-full-stack/commit/${{ github.sha }} - ${{ github.event.head_commit.message }}"}' 
            ${{ secrets.SLACK_WEBHOOK_URL }}
      - name: Send Slack Message
        run: >
            curl -X POST -H 'Content-type: application/json'
            --data '{"text":"Deployment started :progress_bar: :fingerscrossed:"}' 
            ${{ secrets.SLACK_WEBHOOK_URL }}
      - uses: actions/setup-java@v3
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'
      - name: Login to Docker Hub
        uses: docker/login-action@v2
        with:
          username: ${{secrets.DOCKERHUB_USERNAME }}
          password: ${{secrets.DOCKERHUB_ACCESS_TOKEN }}
      - name: Set Build Number
        id: build-number
        run: echo "BUILD_NUMBER=$(date '+%d.%m.%Y.%H.%M.%S')" >> $GITHUB_OUTPUT
      - name: Send Slack Message
        run: >
            curl -X POST -H 'Content-type: application/json' 
            --data '{"text":":maven: Building with Maven"}' 
            ${{ secrets.SLACK_WEBHOOK_URL }}
      - name: Build Package Push with Maven
        run: mvn -ntp -B verify -Ddocker.image.tag=${{steps.build-number.outputs.BUILD_NUMBER}} jib:build
      - name: Send Slack Message
        run: >
             curl -X POST -H 'Content-type: application/json' 
             --data '{"text":":docker: Image tag:${{steps.build-number.outputs.BUILD_NUMBER}} pushed to https://hub.docker.com/repository/docker/amigoscode/amigoscode-api"}' 
             ${{ secrets.SLACK_WEBHOOK_URL }}
      - name: Update Dockerrun.aws.json api image tag with new build number
        run: |
            echo "Dockerrun.aws.json before updating tag"
            cat Dockerrun.aws.json
            sed -i -E 's_(jbirla/spring-boot-api:)([^"]*)_\1'${{steps.build-number.outputs.BUILD_NUMBER}}'_' Dockerrun.aws.json
            echo "Dockerrun.aws.json after updating tag"
            cat Dockerrun.aws.json
      - name: Send Slack Message
        run: >
            curl -X POST -H 'Content-type: application/json' 
            --data '{"text":":aws: Starting deployment to Elastic Beanstalk"}' 
            ${{ secrets.SLACK_WEBHOOK_URL }}
      - name: Deploy to Elastic Bean
        uses: einaregilsson/beanstalk-deploy@v21
        with:
            aws_access_key: ${{ secrets.AWS_ACCESS_KEY_ID }}
            aws_secret_key: ${{ secrets.AWS_SECRET_ACCESS_KEY }}
            application_name: ${{ secrets.EB_APPLICATION_NAME }}
            environment_name: ${{ secrets.EB_ENVIRONMENT_NAME }}
            version_label: ${{ steps.build-number.outputs.BUILD_NUMBER }}
            version_description: ${{github.SHA}}
            region: ${{ secrets.EB_REGION }}
            deployment_package: spring-boot-example/Dockerrun.aws.json
      - name: Send Slack Message
        run: >
            curl -X POST -H 'Content-type: application/json' 
            --data '{"text":":githubloading: Committing to repo https://github.com/amigoscode/spring-boot-full-stack/"}' 
            ${{ secrets.SLACK_WEBHOOK_URL }}
      - name: Commit and Push Dockerrun.aws.json
        run: |
          git config user.name github-actions
          git config user.email github-actions@github.com
          git add Dockerrun.aws.json
          git commit -m "Update Dockerrun.aws.json docker image with new tag ${{ steps.build-number.outputs.BUILD_NUMBER }}"
          git push
        env:
          GITHUB_TOKEN: ${{ secrets.YOUR_ACCESS_TOKEN }}
      - name: Send Slack Message
        run: >
            curl -X POST -H 'Content-type: application/json' 
            --data '{"text":"Deployment and commit completed :github-check-mark: :party_blob: - http://amigoscodeapi-env.eba-ymxutmev.eu-west-1.elasticbeanstalk.com/"}' 
            ${{ secrets.SLACK_WEBHOOK_URL }}
      - name: Send Slack Message
        if: always()
        run: >
              curl -X POST -H 'Content-type: application/json' 
              --data '{"text":"Job Status ${{ job.status }}"}' 
              ${{ secrets.SLACK_WEBHOOK_URL }}
```

### Dockerize the React app and run manually in local
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/70f0cc8a-09c9-44f3-b18f-5bae5abc95cb)
- Here we will use Dockerfile for image generation
- Below Docker file insructions : In summary, this Dockerfile sets up a Node.js environment, installs the application's dependencies, copies the application code into the container, sets an environment variable, exposes a port, and specifies the command to run the application when the container starts.

1. `FROM node:19-alpine`: This line specifies the base image for the Docker image. In this case, it's using the `node:19-alpine` image, which is a lightweight image based on Alpine Linux that includes Node.js.

2. `ARG api_base_url`: This line declares an argument named `api_base_url`. Arguments in Dockerfiles are used to provide values that can be passed at build time.

3. `WORKDIR /app`: This line sets the working directory within the container to `/app`. It means that any subsequent commands will be executed relative to this directory.

4. `COPY package*.json .`: This line copies the `package.json` and `package-lock.json` files from the host machine to the current directory (`.`) in the container. These files are necessary for installing dependencies.

5. `RUN npm i --silent`: This line runs the command `npm i --silent` in the container. It installs the dependencies specified in the `package.json` file. The `--silent` flag is used to suppress verbose output during the installation process.

6. `COPY . .`: This line copies all the files and directories from the host machine's current directory to the current directory (`.`) in the container. It includes the application source code.
Please nota that it won't copy `.dockerignore` file contains
```.dockerignore
node_modules
Dockerfile
.env
.dockerignore
```
8. `RUN echo "VITE_API_BASE_URL = ${api_base_url}" > .env`: This line creates an `.env` file in the container and writes a line with the environment variable `VITE_API_BASE_URL` and its value, which is the value of the `api_base_url` argument passed during the build process.

9. `EXPOSE 5173`: This line exposes port 5173 in the container. It indicates that the container will listen on this port at runtime.

10. `CMD ["npm", "run", "dev"]`: This line specifies the default command to run when the container starts. It runs the command `npm run dev`, which is typically a script defined in the `package.json` file. This command is responsible for starting the application.


- Dockerfile
```Docker
 FROM node:19-alpine
ARG api_base_url
WORKDIR /app
COPY package*.json .
RUN npm i --silent
COPY . .
RUN echo "VITE_API_BASE_URL = ${api_base_url}" > .env
EXPOSE 5173
CMD ["npm", "run", "dev"]
```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/887ceeda-d982-4058-a4de-7df6f016fe86)

- execute below commands for generating image
```
docker build . -t amigoscode/amigoscode-react
docker push amigoscode/amigoscode-react
```
- Look inside the container
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/d859d61c-4dae-4e61-b975-fc3306103d7a)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/d896214f-99be-4061-808b-343391348c01)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/b185e2ea-8777-4c5d-bb4f-c180cb8f9947)

### Create compose file for running all services locally in docker
- docker-compose.yml
```yml
services:
  db:
    container_name: postgres
    image: postgres:15.3
    environment:
      POSTGRES_USER: amigoscode
      POSTGRES_PASSWORD: password
      PGDATA: /data/postgres
    volumes:
      - db:/data/postgres
    ports:
      - "5332:5432"
    networks:
      - db
    restart: unless-stopped
  amigoscode-api:
    container_name: spring-boot-api
    image: jbirla/spring-boot-api:latest
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/customer
    ports:
      - "8088:8080"
    networks:
      - db
    depends_on:
      - db
    restart: unless-stopped

  amigoscode-react:
      container_name: amigoscode-react
      image: jbirla/jbirla-react:latest
      build:
        context: frontend/react
        args:
          api_base_url: http://localhost:8088
      ports:
          - "3000:5173"
      depends_on:
          - amigoscode-api
      restart: unless-stopped


networks:
  db:
    driver: bridge

volumes:
  db:
```

## Deploy React App into EBS manually
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/271e72b2-07ad-4569-982f-566e629342a3)
- Creating Docker app image based on EBS  backend host url using pass api_base_ulr arg
 ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/7c8a7c32-a5dc-42ab-aebe-771a08140dcd)
- Push this image inot dockerhub
- Now up[date Dockerrun.aws.json for react app for deploying manually into EBS
- We are udating the react app host port to 80 for http by default port
```Json
{
  "AWSEBDockerrunVersion": 2,
  "containerDefinitions": [
    {
      "name": "jbirla-react",
      "image": "jbirla/jbirla-react:30.05.2023.11.43.57",
      "essential": true,
      "memory": 256,
      "portMappings": [
        {
          "hostPort": 80,
          "containerPort": 5173
        }
      ]
    },
    {
      "name": "jdbirla-api",
      "image": "jbirla/spring-boot-api:02.06.2023.06.36.17",
      "essential": true,
      "memory": 512,
      "portMappings": [
        {
          "hostPort": 8080,
          "containerPort": 8080
        }
      ],
      "environment": [
        {
          "name": "SPRING_DATASOURCE_URL",
          "value": "EBS RDS URL"
        }
      ]
    }
  ]
}
```
- upload and deploy latest docker.run.json
-  But the frontend can't access backend as now due to security group permission, we have to add inbound rule for 8080
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/6376d77a-2fcc-43b5-9a35-d162922f0fc3)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/8d5c9dc8-3eea-4804-b1e6-70f8b62fa6f8)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/d9117ee8-f896-4f63-a066-57b9434ded42)

### Add Create React App in Github workflow
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/7aefedca-f6a6-4da1-8301-8628632bd69d)

- Create forntend-react-cd.yml file for workflow
```yml
name: CD - Deploy React Frontend

on:
  workflow_dispatch:
  push:
   branches:
     - master
   paths:
     - frontend/react/**

jobs:
  deploy:
    ##if: false # put false if you don't want to github action to deploy this as we already configured deployment using amplify else true
    runs-on: ubuntu-latest
    defaults:
      run:
        working-directory: ./frontend/react

    steps:
      - uses: actions/checkout@v3
      - name: Slack commit message and sha
        run: >
          curl -X POST -H 'Content-type: application/json'
          --data '{"text":":github: ${{ github.server_url }}/${{ github.repository }}/commit/${{ github.sha }} - ${{ github.event.head_commit.message }}"}' 
          ${{ secrets.SLACK_WEBHOOK_URL }}
      - name: Send Slack Message
        run: >
          curl -X POST -H 'Content-type: application/json'
          --data '{"text":"Deployment started :progress_bar: :fingerscrossed:"}' 
          ${{ secrets.SLACK_WEBHOOK_URL }}
      - name: Set build number
        id: build-number
        run: echo "BUILD_NUMBER=$(date '+%d.%m.%Y.%H.%M.%S')" >> $GITHUB_OUTPUT
      - name: Login to Docker Hub
        uses: docker/login-action@v2
        with:
          username: ${{ secrets.DOCKERHUB_USERNAME }}
          password: ${{ secrets.DOCKERHUB_ACCESS_TOKEN }}
      - name: Docker Build and push
        run: |
          chmod +x ../../.ci/build-publish.sh
          USERNAME=jbirla \
          REPO=jbirla-react \
          TAG=${{ steps.build-number.outputs.BUILD_NUMBER }} \
          ../../.ci/build-publish.sh . \
            --build-arg api_base_url=http://amigoscode-fsp-prod.ap-south-1.elasticbeanstalk.com:8080
      - name: Send Slack Message
        run: >
          curl -X POST -H 'Content-type: application/json' 
          --data '{"text":":docker: Image tag:${{steps.build-number.outputs.BUILD_NUMBER}} pushed to https://hub.docker.com/repository/docker/amigoscode/amigoscode-react"}' 
          ${{ secrets.SLACK_WEBHOOK_URL }}
      - name: Update Dockerrun.aws.json react image tag with new build number
        run: |
          echo "Dockerrun.aws.json before updating tag"
          cat ../../Dockerrun.aws.json
          sed -i -E 's_(jbirla/jbirla-react:)([^"]*)_\1'${{steps.build-number.outputs.BUILD_NUMBER}}'_' ../../Dockerrun.aws.json
          echo "Dockerrun.aws.json after updating tag"
          cat ../../Dockerrun.aws.json
      - name: Send Slack Message
        run: >
          curl -X POST -H 'Content-type: application/json' 
          --data '{"text":":aws: Starting deployment to Elastic Beanstalk"}' 
          ${{ secrets.SLACK_WEBHOOK_URL }}
      - name: Deploy to Elastic Beanstalk
        uses: einaregilsson/beanstalk-deploy@v21
        with:
          aws_access_key: ${{ secrets.AWS_ACCESS_KEY_ID }}
          aws_secret_key: ${{ secrets.AWS_SECRET_ACCESS_KEY }}
          application_name: ${{ secrets.EB_APPLICATION_NAME }}
          environment_name: ${{ secrets.EB_ENVIRONMENT_NAME }}
          version_label: ${{ steps.build-number.outputs.BUILD_NUMBER }}
          version_description: ${{ github.SHA }}
          region: ${{ secrets.EB_REGION }}
          deployment_package: Dockerrun.aws.json
          wait_for_environment_recovery: 60
      - name: Send Slack Message
        run: >
          curl -X POST -H 'Content-type: application/json' 
          --data '{"text":":githubloading: Committing to repo https://github.com/amigoscode/spring-boot-full-stack/"}' 
          ${{ secrets.SLACK_WEBHOOK_URL }}
      - name: Commit and push Dockerrun.aws.json
        run: |
          git config user.name github-actions
          git config user.email github-actions@github.com
          git add ../../Dockerrun.aws.json
          git commit -m "Update Dockerrun.aws.json docker image with new tag ${{ steps.build-number.outputs.BUILD_NUMBER }}"
          git push
        env:
          GITHUB_TOKEN: ${{ secrets.YOUR_ACCESS_TOKEN }}
      - name: Send Slack Message
        run: >
          curl -X POST -H 'Content-type: application/json' 
          --data '{"text":"Deployment and commit completed :github-check-mark: :party_blob: - http://amigoscodeapi-env.eba-ymxutmev.eu-west-1.elasticbeanstalk.com/"}' 
          ${{ secrets.SLACK_WEBHOOK_URL }}
      - name: Send Slack Message
        if: always()
        run: >
          curl -X POST -H 'Content-type: application/json' 
          --data '{"text":"Job Status ${{ job.status }}"}' 
          ${{ secrets.SLACK_WEBHOOK_URL }}
```
- build-publish.sh
```sh
: "${USERNAME:?USERNAME not set or empty}"
: "${REPO:?REPO not set or empty}"
: "${TAG:?TAG not set or empty}"

docker buildx create --use

docker buildx build \
    --platform=linux/amd64,linux/arm64 \
    -t "${USERNAME}/${REPO}:${TAG}" \
    -t "${USERNAME}/${REPO}:latest" \
    "${@:2}" \
    --push \
    "$1"
```
## AWS Loadbalancer, Auto scaling, Route 53, SSL
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/1c97e704-26ca-48ba-bcc8-3ebb0d16516e)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/7306ec29-44c9-4f6f-ba36-1db7c6a1343c)
- Create new env
- Load balancer will be in public subnet
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/6f10f377-b54c-4d15-b284-5504eaa31506)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/23818355-ed83-4c71-9861-341b5653f4c9)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/02eb403a-8079-48fd-a2f0-eb768a0276c9)

- aws.json
- We removed the react container defination becasue will deploy react using aws amplify and chnage tithe port aws well
```json
{
  "AWSEBDockerrunVersion": 2,
  "containerDefinitions": [
{
      "name": "jdbirla-api",
      "image": "jbirla/spring-boot-api:30.05.2023.11.38.43",
      "essential": true,
      "memory": 512,
      "portMappings": [
        {
          "hostPort": 80,
          "containerPort": 8080
        }
      ],
      "environment": [
        {
        "name": "SPRING_DATASOURCE_URL",
          "value": "EBS RDS URL"
        }
      ]
    }
  ]
}
```

-  upload this file
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/675efc09-ec16-47e2-8e0e-1d01795859b3)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/2b902539-bb5e-4242-8fa2-f44d3d859176)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/247343a0-69c0-4e09-b678-1dc0a529f7a2)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/324fa11c-98b7-4978-863c-9da0b0be147d)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/8135bea9-ee5b-4f4d-af2f-31d62e866e8b)
- Autoscaling triggers
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/7dd44de3-54f2-4180-aa45-659dbfb16ca4)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/e1b41070-6820-4dd0-a00a-a164d83f9e8f)

- change RDS host in aws json and redeploy
- We will face health check issue for solving this issue we have exposed `info and health` actuator in applicaiton
- We need to requestpermission into securityfilterchainconfig
- Update github secrets for new env
- Github action willl deploy after commit
- Change health check path
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/ad933c37-df9f-4ccb-8b38-ce37e0b36de8)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/8331e158-8750-474c-bfb8-0c4fb9690c18)

- Route 53 take a domain
- Create a record
- ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/613ee714-a541-4f8b-a1ae-1850acb20cd3)
- SSL TSL using certificate manager
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/3b659123-cbdf-41d9-b2ce-60ba3e1944ab)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/7f7fba92-5aa0-4431-a5e0-3c16014be1ea)
- create a reacord in certificayte
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/da2e9e91-3a69-43db-8a47-a33922d9dc87)
- add listern for load balanser for hhtps
 ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/6bb5b479-581d-4560-9bfc-00685cfe593d)
- HTTP to HTTPs redirect

## AWS Amplify
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/aaea80b7-f62a-4a35-ac7d-ed4380394ecd)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/681e2e8c-3477-4823-b679-9cc03c64b744)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/bda9edce-f56c-42fa-91d3-134345403441)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/c60b1e96-e140-4f3c-9f52-623c9ed10c49)


```yml
version: 1
applications:
  - frontend:
      phases:
        preBuild:
          commands:
            - nvm use ${VERSION_NODE_17}
            - npm ci
        build:
          commands:
            - nvm use ${VERSION_NODE_17}
            - echo "VITE_API_BASE_URL=$VITE_API_BASE_URL" > .env.production
            - npm run build
      artifacts:
        baseDirectory: /dist
        files:
          - '**/*'
      cache:
        paths:
          - node_modules/**/*
    appRoot: frontend/react
```
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/b50855b5-f68b-44ce-b802-b755b7bddb7b)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/2b1dade2-16f0-4856-a1e9-4a8959745a97)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/cc5852f8-627b-451f-a2b9-bddb6241d651)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/2244d624-e9b6-44bf-af7c-3dc41e1df714)
- custom domain a free SSL certificate
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/0c2958b6-d5ad-460c-a419-a2f9ff9f70e1)

- Preview and CICD
- We can disable React-workflow using a condition
`if: false`
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/24aba092-fced-4a93-82ec-3164196c99a7)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/bfd575d0-137c-4b22-88e8-a5d74a5c5e42)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/2fb462a2-a3cd-4a8e-85b5-a21b2161a6ea)

### Secrets Manager
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/cdd1eb96-7f2c-4355-8d01-d1522cf8c196)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/245ef67b-0349-425a-acca-130c9478132c)
- We have granted permission to the EC2 role for access secrets manager
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/fdc9eb9a-f81b-437c-8bb1-7ae4d000359c)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/fd76f8f2-31e5-424d-8d5d-beb397342eb7)

```yml
spring:
  datasource:
    url: jdbc-secretsmanager:postgresql://awseb-e-ezjnxfjb44-stack-awsebrdsdatabase-f2ocmocryc5g.celswdmxhcr1.eu-west-1.rds.amazonaws.com:5432/ebdb
    username: test/full-stack/postgres
    driver-class-name: com.amazonaws.secretsmanager.sql.AWSSecretsManagerPostgreSQLDriver
```



