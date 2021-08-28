# reverse-geocoding

## 🤖 Information
Программа имитирует работу клиента, а также ответ от сервера.

Клиент посылает гет-запрос с координатами точки _latitude_ и _longitude_:
``` java
http://localhost:8080/api/address/get?lat=54.741646&lon=48.734

```
Имитация клиента расположена в `inforest/reversegeocoding/client`

Код сервера расположен в `inforest/reversegeocoding/server`

### ☝ Со стороны клиента
Получает данные о товарах с сайта и сохраняет их в формате _.csv_

Сохраняет данные с сайта _Aliexpress_: `https://flashdeals.aliexpress.com/en.htm?`

### ☝ Сколько товаров парсит?
По дефолту программа получает данные о первых 100 товаров.

Если нужно другое количество, просто измените значение переменной в классе _Main.java_:
``` java
private final static int PRODUCT_COUNT = 100;
```
### ☝ Какой формат .csv?
Все поля и значения разделены через `,`

Если нужен другой разделитель, просто измените значение переменной в классе _Main.java_:
``` java
private final static String CSV_SEPARATOR = ",";
```
## 📝 How to run
Для получения данных, склонируйте репозиторий к себе и запустите _Main.java_

По умолчанию файл будет сохранен в _./csv/products-data.csv_