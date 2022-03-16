    protected WeatherEntity(Parcel in) {
        this.cityId = in.readString();
        this.cityName = in.readString();
        this.dataUpdateTime = in.readString();
        this.airQulityIndex = in.readString();
        this.pm25 = in.readString();
        this.pm10 = in.readString();
        this.so2 = in.readString();
        this.no2 = in.readString();
        this.co = in.readString();
        this.o3 = in.readString();
        this.airQulityType = in.readString();
        this.weatherCode = in.readString();
        this.weatherDescription = in.readString();
        this.currentTemperature = in.readString();
        this.feltTemperature = in.readString();
        this.rainfall = in.readString();
        this.humidity = in.readString();
        this.airPressure = in.readString();
        this.visibility = in.readString();
        this.windSpeed = in.readString();
        this.windScale = in.readString();
        this.windDirection = in.readString();
        this.dressBrief = in.readString();
        this.dressDescription = in.readString();
        this.uvBrief = in.readString();
        this.uvDescription = in.readString();
        this.carWashBrief = in.readString();
        this.carWashDescription = in.readString();
        this.travelBrief = in.readString();
        this.travelDescription = in.readString();
        this.fluBrief = in.readString();
        this.fluDescription = in.readString();
        this.sportBrief = in.readString();
        this.sportDescription = in.readString();
        this.forecasts = in.createTypedArrayList(Forecast.CREATOR);
    }

