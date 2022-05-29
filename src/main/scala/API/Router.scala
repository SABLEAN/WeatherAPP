package API

import Service.WeatherS
import cats.effect.IO
import org.http4s.HttpRoutes
import sttp.tapir.server.http4s.Http4sServerInterpreter

class Router(Weather: WeatherS[IO]) {


  def getRoute: HttpRoutes[IO] = {
    Http4sServerInterpreter[IO].toRoutes(Endpoints.getWeather.serverLogic(City => Weather.GetWeather(City)))
  }



}
