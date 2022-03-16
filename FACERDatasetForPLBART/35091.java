    public static CityRepository getInstance(){
        if (sInstance == null) {
            sInstance = new CityRepository();
        }
        return sInstance;
    }

