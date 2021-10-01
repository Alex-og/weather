# weather
This is a simple program that you can interact with in two modes:<br>

<b>1.The Spring Shell.</b><br>
It connects to the OpenWeather API. For correct operation of the application you need to 
substitute your token from the above-mentioned resource in the API-ID field in the 
application.propertis file.
The city name must be entered according to ISO 3166.

The following commands are provided:
   * 1: Get the forecast for your city for 5 days.
   * 2: Get the forecast for your city for today.
    
The input should be in the following format:
   * 1 kyiv
   * 2 dnipro

<b>2.The WebController.</b><br>
As in the previous mode, it is possible to request weather for a specific
city for one day or for five days
   * /five-days/kyiv
   * /today/kyiv
