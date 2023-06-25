# FSP Deployment Steps
- Elastic Beans talk, ECS, EC2, RDS
![image](https://github.com/jdbirla/JD_FSP/assets/69948118/021fc460-3efa-4065-91b4-58ecc73ebfa3)
![image](https://github.com/jdbirla/JD_FSP/assets/69948118/d7b115e7-de7b-4b87-af73-68c22dce178e)

## EC2 Generate New Key Pair 
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/db148d3a-fbae-4f80-aa98-9ad6d8a773e2)
- Download .pem file [private key]

##  Getting Started With Elastic Beanstalk 
### Create application
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
- As We need to connect postgress DB we need `psql` client there are two way for this either we can install psql in EC2 using
  `sudo apt update
sudo apt install postgresql-client` or we can run docke image of postgress DB which will default provid the psql client
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






sudo -i
docker run --rm -it postgres:alpine bash
psql -U amigoscode -h host -d postgres 
or
psql -U amigoscode -h host -d ebdb
create database customer;
docker ps
docker logs -f container-id
```
