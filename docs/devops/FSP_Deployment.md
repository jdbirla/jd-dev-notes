# FSP Deployment Steps
- Elastic Beans talk, ECS, EC2, RDS
![image](https://github.com/jdbirla/JD_FSP/assets/69948118/021fc460-3efa-4065-91b4-58ecc73ebfa3)
![image](https://github.com/jdbirla/JD_FSP/assets/69948118/d7b115e7-de7b-4b87-af73-68c22dce178e)

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
