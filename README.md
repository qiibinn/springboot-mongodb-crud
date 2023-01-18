Spring Boot crud application using MongoDB

# RESTApi Demo Project
RESTApi application demo


# Build and run demo
## Build application docker image
cd into top directory of the project where the docker-compose.yml is located in and execute:
```
mvn clean install
```

# Start DB and application
```
docker-compose up
```

# Test
Please replace the docker-app-host with the actual exposed ip address. Or add the DNS entry in your system hosts file. See the example below:

```
192.168.9.10   docker-app-host
```

## Create new birds
```
curl -v -X POST docker-app-host:8888/birds -d "{\"name\": \"bird-name1\",\"color\": \"red\",\"weight\": 10,\"height\": 20}" -H "Content-Type:application/json"
curl -v -X POST docker-app-host:8888/birds -d "{\"name\": \"bird-name2\",\"color\": \"red\",\"weight\": 10,\"height\": 20}" -H "Content-Type:application/json"
curl -v -X POST docker-app-host:8888/birds -d "{\"name\": \"bird-name3\",\"color\": \"white\",\"weight\": 10,\"height\": 20}" -H "Content-Type:application/json"
```

## Create new sightings associated with the bird created previously.
```
curl -v -X POST docker-app-host:8888/sightings -d "{\"id\": \"1\",\"birdName\": \"bird-name1\",\"location\": \"location-1\",\"datetime\": \"2022-10-13\"}" -H "Content-Type:application/json"
curl -v -X POST docker-app-host:8888/sightings -d "{\"id\": \"2\",\"birdName\": \"bird-name2\",\"location\": \"location-1\",\"datetime\": \"2022-10-13\"}" -H "Content-Type:application/json"
curl -v -X POST docker-app-host:8888/sightings -d "{\"id\": \"3\",\"birdName\": \"bird-name3\",\"location\": \"location-1\",\"datetime\": \"2022-10-13\"}" -H "Content-Type:application/json"
```

## List all birds:
```
curl -v docker-app-host:8888/birds
```

## Query birds by color:
```
curl -v docker-app-host:8888/birds/color/red
```

## Query birds by name:
```
curl -v docker-app-host:8888/birds/name/bird-name1
```

## Query birds by name and color:
```
curl -v "docker-app-host:8888/birds/name/bird-name1/color/red"
```


## List all sightings:
```
curl -v docker-app-host:8888/sightings
```

## Query sighting by bird name:
```
curl -v docker-app-host:8888/sightings/bird/bird-name1
```

## Query sighting by location:
```
curl -v docker-app-host:8888/sightings/location/location-1
```

## Query sighting by location and bird name:
```
curl -v "docker-app-host:8888/sightings/location/location-1/bird/bird-name1"
```

## Update bird by name:
```
curl -v -X PUT docker-app-host:8888/birds/update/name/bird-name1 -d "{\"name\": \"bird-name1\",\"color\": \"blue\",\"weight\": 10,\"height\": 20}" -H "Content-Type:application/json"
```

## Delete bird by name:
```
curl -v -X DELETE docker-app-host:8888/birds/delete/name/bird-name3
```

## Update sighting by id.
```
curl -v -X PUT docker-app-host:8888/sightings/1 -d "{\"birdName\": \"bird-name3\",\"location\": \"location-3\",\"date\": \"2022-10-13\"}" -H "Content-Type:application/json"
```

## Delete sighting by id:
```
curl -v -X DELETE docker-app-host:8888/sightings/2
```

