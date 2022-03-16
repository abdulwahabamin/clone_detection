    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(temperature);
        parcel.writeFloat(lon);
        parcel.writeFloat(lat);
        parcel.writeFloat(windSpeed);
        parcel.writeFloat(windDirection);
        parcel.writeFloat(pressure);
        parcel.writeInt(humidity);
        parcel.writeInt(clouds);
        parcel.writeLong(sunrise);
        parcel.writeLong(sunset);
        parcel.writeTypedList(currentWeathers);
    }

