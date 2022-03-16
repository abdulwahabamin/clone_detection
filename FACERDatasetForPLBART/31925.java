    public Location(long id,
                    int orderId,
                    String nickname,
                    String localeAbbrev,
                    double longitude,
                    double latitude,
                    float accuracy,
                    String locationSource,
                    long lastLocationUpdate,
                    boolean addressFound,
                    boolean enabled,
                    Address address) {
        this.id = id;
        this.address = address;
        this.orderId = orderId;
        this.nickname = nickname;
        if (localeAbbrev == null) {
            this.locale = Locale.getDefault();
            this.localeAbbrev = this.locale.getLanguage();
        } else {
            this.localeAbbrev = localeAbbrev;
            this.locale = new Locale(localeAbbrev);
        }
        this.longitude = longitude;
        this.latitude = latitude;
        this.accuracy = accuracy;
        this.locationSource = locationSource;
        this.lastLocationUpdate = lastLocationUpdate;
        this.addressFound = addressFound;
        this.enabled = enabled;
    }

