    public static byte[] getAddressAsBytes(Address address) {
        if (address == null) {
            return null;
        }
        final Parcel parcel = Parcel.obtain();
        address.writeToParcel(parcel, 0);
        byte[] addressBytes = parcel.marshall();
        parcel.recycle();
        return addressBytes;
    }

