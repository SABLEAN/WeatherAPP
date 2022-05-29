package API.DTO




final case class FinalyResult(temperatureCelsius: Int, description: String, humidity: Int, wind: EnakinWindWoker)

final case class EnakinWindWoker(speedInMeters: Float, direction: String )