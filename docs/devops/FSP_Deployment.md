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
