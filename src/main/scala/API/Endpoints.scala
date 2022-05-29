package API
import sttp.tapir._
import API.DTO.{ErrorMassegeDto, FinalyResult}
import sttp.tapir.json.circe.jsonBody
import sttp.tapir.{Endpoint, endpoint, path}
import io.circe.generic.auto._
import sttp.tapir.generic.auto._

object Endpoints {


  val getWeather: Endpoint[Unit, String, ErrorMassegeDto, FinalyResult, Any] = {
    endpoint
      .get
      .in("City" / path[String]("City"))
      .out(jsonBody[FinalyResult])
      .errorOut(jsonBody[ErrorMassegeDto])
  }

}
