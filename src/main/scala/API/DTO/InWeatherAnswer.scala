package API.DTO



  case class Clouds (
                      all: Int
                    )

  case class Coord (
                     lat: Double,
                     lon: Double
                   )

  case class List (
                    id: Int,
                    name: String,
                    coord: Coord,
                    main: Main,
                    dt: Int,
                    wind: Wind,
                    sys: Sys,
                    rain: String,
                    snow: String,
                    clouds: Clouds,
                    weather: Seq[Weather]
                  )

  case class Main (
                    temp: Double,
                    feels_like: Double,
                    temp_min: Double,
                    temp_max: Double,
                    pressure: Int,
                    humidity: Int,
                    sea_level: Int,
                    grnd_level: Int
                  )

  case class RootInterface (
                             message: String,
                             cod: String,
                             count: Int,
                             list: Seq[List]
                           )

  case class Sys (
                   country: String
                 )

  case class Weather (
                       id: Int,
                       main: String,
                       description: String,
                       icon: String
                     )

  case class Wind (
                    speed: Double,
                    deg: Int
                  )



