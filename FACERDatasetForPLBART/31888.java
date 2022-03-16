    public byte[] getWeatherAsBytes(Weather weather) {
        final Parcel parcel = Parcel.obtain();
        weather.writeToParcel(parcel, 0);
        byte[] weatherBytes = parcel.marshall();
        parcel.recycle();
        return weatherBytes;
    }

