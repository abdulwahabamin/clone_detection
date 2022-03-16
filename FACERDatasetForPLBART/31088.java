        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.date);
            dest.writeString(this.sunriseTime);
            dest.writeString(this.sunsetTime);
            dest.writeString(this.maxTemperature);
            dest.writeString(this.minTemperature);
            dest.writeString(this.windSpeed);
            dest.writeString(this.windScale);
            dest.writeString(this.windDirection);
            dest.writeString(this.weatherCodeDaytime);
            dest.writeString(this.weatherDescriptionDaytime);
            dest.writeString(this.weatherCodeNight);
            dest.writeString(this.weatherDescriptionNight);
            dest.writeString(this.rainfall);
            dest.writeString(this.rainProbability);
            dest.writeString(this.humidity);
            dest.writeString(this.airPressure);
            dest.writeString(this.visibility);
        }

