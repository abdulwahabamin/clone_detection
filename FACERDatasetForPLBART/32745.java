        public WeatherMaxMinForDay(
                Integer dayOfYear,
                double maxTemp,
                Long maxTempTime,
                double minTemp,
                Long minTempTime,
                double maxWind,
                Long maxWindTime,
                double maxRain,
                Long maxRainTime,
                double maxSnow,
                Long maxSnowTime,
                double windDegree) {
            this.dayOfYear = dayOfYear;
            this.maxTemp = maxTemp;
            this.minTemp = minTemp;
            this.maxWind = maxWind;
            this.maxRain = maxRain;
            this.maxSnow = maxSnow;
            this.windDegree = windDegree;
            this.maxRainTime = maxRainTime;
            this.maxSnowTime = maxSnowTime;
            this.maxTempTime = maxTempTime;
            this.minTempTime = minTempTime;
            this.maxWindTime = maxWindTime;
        }

