package com.apple.weatherforecast.solution.rule;

import com.apple.weatherforecast.solution.model.Values;
import com.apple.weatherforecast.solution.model.WeatherForecastDetail;
import com.apple.weatherforecast.solution.model.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class WeatherForecastingRuleService {
    public WeatherForecastDetail applyRules(WeatherResponse response){
        WeatherForecastDetail  weatherForecastDetail = WeatherForecastDetail.builder().build();
        StringBuffer sb = new StringBuffer();

        Values weather = response.getData().getValues();
        if (weather.getTemperature() > 25) {
            sb.append("Please use sunscreen lotion to protect your scene as temperature is high outside "+
                    "Current temperature is " + weather.getTemperature());
            sb.append("\n");
        }

        if (weather.getCloudCover() > 40 && weather.getHumidity() >50) {
            sb.append("Carry umbrella, possibility of rain as there is high humidity and cloud cover outside");
            sb.append("\n");
        }

        if (weather.getWindSpeed() > 60) {
            sb.append("Stay at home,possibility of storm "+ weather.getWindSpeed());
        }
        if(sb.toString().isEmpty()){
            sb.append("Enjoy your day as weather conditions looks good outside - no rain, wind is normal, no cloud cover");
        }

        weatherForecastDetail.setAdvisory(sb.toString());
        weatherForecastDetail.setDate(response.getData().getTime());
        weatherForecastDetail.setCurrentTemp(weather.getTemperature());
        weatherForecastDetail.setLocation(response.getLocation());

        return weatherForecastDetail;
    }
}
