    private Weather(Parcel in) {
        temperature = in.readFloat();
        lon = in.readFloat();
        lat = in.readFloat();
        windSpeed = in.readFloat();
        windDirection = in.readFloat();
        pressure = in.readFloat();
        humidity = in.readInt();
        clouds = in.readInt();
        sunrise = in.readLong();
        sunset = in.readLong();
        in.readTypedList(currentWeathers, CurrentWeather.CREATOR);
    }

