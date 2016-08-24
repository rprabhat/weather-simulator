# Weather Simulator

Design is inspired by property based testing concept. ( [`Chapter #8 Funtional Programming In Scala`] (https://www.manning.com/books/functional-programming-in-scala) and [`scalacheck`] (https://www.scalacheck.org/)
Dependency between different mesurements is represented by flatMap between generators.
Most of measurement range value is hard coded in config file. It can modified easily to read it dynamically from any api endpoint

## Simulator flow
 * Generate random value within  given range for location measure ( latitude, longitude, elevation )
 * Generate random timestamp ( year, month, day, time )
 * Generate random atmospheric measure ( humidity, pressure, temperature) based om time and location
 * * humidity <- temp  or pressure change
 * * pressure <- elevation
 * * temperature <- month, time, longitude, latitude, elevlation
 * Derive condition based on atmospheric measure.
 * * Rain: Temperature: (10 - 25 C ), Humidity: (80 - 100), Pressure: < 900
 * * Snow: Temperature: (-25 - 2 C ), Humidity: (50 - 80 ), Pressure: < 1000
 * * Sunny: default


## Run
```
sbt clean; sbt compile; sbt run
```

## TODO


