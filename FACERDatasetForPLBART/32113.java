    public byte[] getCompleteWeatherForecastAsBytes(CompleteWeatherForecast completeWeatherForecast) {
        final Parcel parcel = Parcel.obtain();
        completeWeatherForecast.writeToParcel(parcel, 0);
        byte[] completeWeatherForecastBytes = parcel.marshall();
        parcel.recycle();
        return completeWeatherForecastBytes;
    }

