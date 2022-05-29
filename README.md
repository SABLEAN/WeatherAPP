# Сервис погоды

Сервис должен по запросу `GET /weather/{cityName}` ответить:
- 404, если погода для города `{cityName}` не была получена
- 200, если данные погоды были получены

Ответ в случае 200 должен ответить контентом `application/json`:
```json
{
  "temperatureCelsius": 20,
  "description": "clear sky",
  "humidity": 90,
  "wind": {
    "speedInMeters": 1.5,
    "direction": "NW"
  }
}
```

## API

[openweathermap](https://openweathermap.org/current)

## Библиотеки

- [cats](https://typelevel.org/cats/)
- [tapir](https://tapir.softwaremill.com/en/latest/)
- [circe](https://circe.github.io/circe/)
