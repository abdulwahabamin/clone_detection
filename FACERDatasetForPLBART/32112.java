    public CompleteWeatherForecast getCompleteWeatherForecastFromBytes(byte[] addressBytes) {
        if ((addressBytes == null) || (addressBytes.length == 0)) {
            return null;
        }
        final Parcel parcel = Parcel.obtain();
        parcel.unmarshall(addressBytes, 0, addressBytes.length);
        parcel.setDataPosition(0);
        CompleteWeatherForecast completeWeatherForecast = null;
        try {
            completeWeatherForecast = CompleteWeatherForecast.CREATOR.createFromParcel(parcel);
        } catch (Exception e) {
            appendLog(context, TAG, e);
        }
        parcel.recycle();
        return completeWeatherForecast;
    }

