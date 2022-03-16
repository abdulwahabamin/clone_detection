    private Location(Parcel in) {
        id = in.readLong();
        latitude = in.readDouble();
        longitude = in.readDouble();
        orderId = in.readInt();
        localeAbbrev = in.readString();
        nickname = in.readString();
        accuracy = in.readFloat();
        locationSource = in.readString();
        lastLocationUpdate = in.readLong();
        address = in.readParcelable(Address.class.getClassLoader());
        locale = new Locale(localeAbbrev);
    }

