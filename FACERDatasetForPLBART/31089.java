        protected Forecast(Parcel in) {
            this.date = in.readString();
            this.sunriseTime = in.readString();
            this.sunsetTime = in.readString();
            this.maxTemperature = in.readString();
            this.minTemperature = in.readString();
            this.windSpeed = in.readString();
            this.windScale = in.readString();
            this.windDirection = in.readString();
            this.weatherCodeDaytime = in.readString();
            this.weatherDescriptionDaytime = in.readString();
            this.weatherCodeNight = in.readString();
            this.weatherDescriptionNight = in.readString();
            this.rainfall = in.readString();
            this.rainProbability = in.readString();
            this.humidity = in.readString();
            this.airPressure = in.readString();
            this.visibility = in.readString();
        }

