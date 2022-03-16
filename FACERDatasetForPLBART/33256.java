	CityWeatherInfo(int cityId, String cityName,
			long lastCurrentWeatherUpdateTime,
			long lastDailyForecastUpdateTime,
			long lastThreeHourlyForecastUpdateTime,
			String cachedCurrentWeatherJson, String cachedDailyForecastJson,
			String cachedThreeHourlyForecastJson) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.lastCurrentWeatherUpdateTime = lastCurrentWeatherUpdateTime;
		this.lastDailyForecastUpdateTime = lastDailyForecastUpdateTime;
		this.lastThreeHourlyForecastUpdateTime = lastThreeHourlyForecastUpdateTime;
		this.cachedCurrentWeatherJson = cachedCurrentWeatherJson;
		this.cachedDailyForecastJson = cachedDailyForecastJson;
		this.cachedThreeHourlyForecastJson = cachedThreeHourlyForecastJson;
	}

