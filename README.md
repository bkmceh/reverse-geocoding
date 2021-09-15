# reverse-geocoding

## 💾 Information 
This program receives the coordinates of a point, and if it is not in the database, adds it there.

The address is requested through interaction with the _DaData API_

When re-requesting this point, the program takes the address from the database.

It turns out some kind of data caching.

The program simulates the work of the client, as well as the response from the server.

The simulated client is located in `inforest/reversegeocoding/client`

The server code is located in `inforest/reversegeocoding/server`

### ❓ What does the client do?
The client sends a get request with the coordinates of the point **_latitude_** and **_longitude_** to the address:
```
http://localhost:8080/api/address/get?lat=54.741646&lon=48.734
```
To change the coordinates of a point, it is enough to change the values of the variables in the `client/Main.java` class:
``` java
private final static double LAT = 54.741646;
private final static double LON = 48.734;
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
Just clone the repository to yourself
- Run `ReversegeocodingApplication.java`
- Run `client/Main.java`
