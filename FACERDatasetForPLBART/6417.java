    public static <D extends Durable> D readFromParcel(Parcel parcel, D d) {
        try {
            return readFromArray(parcel.createByteArray(), d);
        } catch (IOException e) {
            throw new BadParcelableException(e);
        }
    }

