# billableHours API - compute billable hours that lawyers have worked on projects
### Shot For 100% Code Coverage
### Requirements
> Kotlin V1.3.72+ <br>
> docker V18.09.2+ <br>
> docker-compose v1.23.2+
### Quick Start - Run With Docker
```$xslt
 1. docker-compose build
 2. docker-compose up [Make sure nothing is running on port 8080] <br>
 
```
> You can now access API on http://localhost:8080/billablehours-api
### View Documentation About All Endpoints
[http://localhost:8080/billablehours-api/swagger-ui.html](http://localhost:8080/billablehours-api/swagger-ui.html)
### Run All Tests
```$xslt
./gradlew test
```

### Default Credentials 
```$xslt
Role => Lawyer 
username = lawyer1@gmail.com
password = pass1234

Role => Finance Administrator
username = finance1@gmail.com
password = pass1234

```

### Sample Requests And Responses 
#### Authentication or signin 
> Request
```$xslt
POST http://localhost:8080/billablehours-api/api/v1/auth/signin
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

{
  "username": "lawyer1@gmail.com",
  "password": "pass1234"
}

```

> Response
```$xslt
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsYXd5ZXIxQGdtYWlsLmNvbSIsImlhdCI6MTU5MTU5MDg5NCwiZXhwIjoxNTkyMTk1Njk0fQ.pavyfoIoZW-f-R07UG2aJjszP2ttycQZuFQiJeSJ-N1YMjK18M2_ciS2-sFaA_4OAK-UkySni_gTvAG77wtgJg",
  "id": 1,
  "firstName": "rodney",
  "roleName": "ROLE_LAWYER",
  "surName": "boachie"
}
```

### Create Lawyer Billable Work Log
>Request
```$xslt
POST http://localhost:8080/api/v1/lawyer/1/bill
Accept: */*
Cache-Control: no-cache
Content-Type: application/json
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsYXd5ZXIxQGdtYWlsLmNvbSIsImlhdCI6MTU5MTU1ODg4MywiZXhwIjoxNTkyMTYzNjgzfQ.OKY-SJjgzmKAfKd0HbJyMIxWnJqsgnUayo2M2CDVWdSNzSzldOG8x3rGrrVBBl9K6Rjp_hGQWYFXLNOd2tqtpg

{
  "billableRate": 300,
  "companyID": 1,
  "dateOfDay": "2020-06-07T19:39:52.193+00:00",
  "startTime": "2023-03-07T07:39:52.000+00:00",
  "endTime": "2023-03-07T09:39:52.000+00:00",
  "userID": 1
}

```
>Response
```$xslt
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
Transfer-Encoding: chunked
Date: Mon, 08 Jun 2020 04:41:02 GMT

<Response body is empty>

Response code: 201; Time: 229ms; Content length: 0 bytes
```
