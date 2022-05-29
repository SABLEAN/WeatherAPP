package DATA

import API.DTO.{EnakinWindWoker, ErrorMassegeDto, FinalyResult, RootInterface, Wind}
import cats.{Applicative, Monad}
import Service.WeatherS
import cats.effect.Sync
import sttp.tapir._
import sttp.tapir.client.sttp.SttpClientInterpreter
import sttp.client3._
import sttp.tapir.json.circe.jsonBody
import io.circe.generic.auto._
import sttp.tapir.generic.auto._
import cats.syntax.all._

class WeatherSs[F[_]](backend: SttpBackend[F, Any])(implicit A: Sync[F]) extends WeatherS[F] {
  private val end = endpoint.get
    .in("data" / "2.5" / "find")
    .in(query[String]("q"))
    .in(query[String]("type"))
    .in(query[String]("appid"))
    .out(jsonBody[RootInterface])


  override def GetWeather(City: String): F[Either[ErrorMassegeDto, FinalyResult]] = {

    SttpClientInterpreter()

      .toRequestThrowDecodeFailures(end, Some(uri"http://api.openweathermap.org/"))
      .apply(("Petersburg"), ("like"), ("dfd944127a1e1fe3f7d01e020f1b64e0"))
      .send(backend)
      .map { resp => resp.body }
      .map { Fr =>
        Fr.leftMap { _ => ErrorMassegeDto("Proizoshla dyshnina") }
          .flatMap { uneitherFr =>
            val fineResult = uneitherFr.list.headOption
            if (fineResult.isEmpty) {
              Left(ErrorMassegeDto.apply("Proizoshla dyshnina"))
            }
            else {
              val getFineResult = fineResult.get
              val syperWind:EnakinWindWoker = new EnakinWindWoker(getFineResult.wind.speed.toFloat,getFineResult.wind.deg.toString )
              Right(FinalyResult(getFineResult.main.temp.toInt, getFineResult.weather.map(des => des.description).head, getFineResult.main.humidity, syperWind))
            }
          }
      }


  }

}

//q=Petersburg&type=like&appid=dfd944127a1e1fe3f7d01e020f1b64e0//