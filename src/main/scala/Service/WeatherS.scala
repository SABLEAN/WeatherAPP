package Service

import API.DTO._

trait WeatherS[F[_]] {

  def GetWeather(City:String): F[Either[ErrorMassegeDto, FinalyResult]]
}
