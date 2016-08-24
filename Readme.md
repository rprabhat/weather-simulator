# Weather Simulator

Design is inspired by property based testing concept. ( [`Chapter #8 Funtional Programming In Scala`] (https://www.manning.com/books/functional-programming-in-scala) and [`scalacheck`] (https://www.scalacheck.org/))
Dependency between different mesurements is represented by flatMap on generators.
Measurement range value is hard coded in [`config file`] (https://github.com/rprabhat/weather-simulator/blob/master/src/main/resources/application.conf). It can modified easily to read it dynamically from any api endpoint

## Simulator flow
 * Generate random value within  given range for location measure ( latitude, longitude, elevation )
 * Generate random timestamp ( year, month, day, time )
 * Generate random atmospheric measure ( humidity, pressure, temperature) based on timestamp and location
   * humidity <- temp  or pressure change
   * pressure <- elevation
   * temperature <- month, time, longitude, latitude, elevlation
 * Derive condition based on atmospheric measure.
   * Rain: Temperature: (10 - 25 C ), Humidity: (80 - 100)
   * Snow: Temperature: (-25 - 2 C )
   * Sunny: default


## Run
```
sbt clean; sbt compile; sbt run
```

## Improvements
 * More unit tests
 * More dependency between generators to  make it realistic
 * Generate data validation ( eg timstamp validation ) 


