    public static Weather getWeatherFromBytes(byte[] addressBytes) {
        final Parcel parcel = Parcel.obtain();
        parcel.unmarshall(addressBytes, 0, addressBytes.length);
        parcel.setDataPosition(0);
        Weather weather = Weather.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        return weather;
    }

