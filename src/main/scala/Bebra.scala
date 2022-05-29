import API.{DTO, Router}
import API.DTO.{FinalyResult, Wind}
import Service.WeatherS
import cats.effect.{IO, IOApp, Resource}
import org.http4s.HttpRoutes
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.server.Server
import DATA.WeatherSs
import sttp.client3.asynchttpclient.cats.AsyncHttpClientCatsBackend


object Bebra extends IOApp.Simple {


  override def run: IO[Unit] = {


    AsyncHttpClientCatsBackend.resource[IO]().flatMap { A =>

      val WeatherService: WeatherS[IO] = new WeatherSs[IO](A)
      val router = new Router(WeatherService)
      webService(router.getRoute)
    }

      .use(_ => IO.never)
  }


  def webService(routes: HttpRoutes[IO]): Resource[IO, Server] =
    BlazeServerBuilder[IO]
      .bindHttp(host = "127.0.0.1", port = 9999)
      .withHttpApp(routes.orNotFound)
      .resource


}
