# reverse-geocoding

## 💾 Information 
This service receives the coordinates of a point, and if it is not in the database, adds it there.

The address is requested through interaction with the _DaData API_.

When re-requesting this point, the service takes the address from the database.

It turns out some kind of data caching.

### ❓ How to send request?
Request sends on address with _**lat**_ and _**lon**_ path parameters:
```
http://localhost:8080/api/address/get
```

Example curl request:
```
curl "http://localhost:8080/api/address/get?lat=54.741646&lon=48.734"
```

### ❓ What does the server do?
The server receives a get request from our client and first checks the existence of this point in the database.

- If it finds it, it returns:
    ```
    LAT: 54.741646, LON: 48.734
    Address: Found from Database: Респ Татарстан, Тетюшский р-н, поселок Пищемар, ул Пищемар
    ```
- If there is no given point in the database, the server makes a get request to the DaData API, saves the data into the database and returns:
    ```
    LAT: 54.741646, LON: 48.734
    Address: Not found from Database, saved: Респ Татарстан, Тетюшский р-н, поселок Пищемар, ул Пищемар
    ```

## 📝 How to run
### Main dependencies
- Java - 11
- Maven - 4.0.0
### Building
For building the project, write this command in terminal into the root directory of your project.
```
mvn clean install
```
### Running
For running the assembled project, write this command in terminal into the root
directory of your project.
```
mvn exec:java
```
