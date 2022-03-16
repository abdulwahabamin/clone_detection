    public Location(PersistableBundle persistentBundle) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            id = persistentBundle.getLong("id");
            latitude = persistentBundle.getDouble("latitude");
            longitude = persistentBundle.getDouble("longitude");
            orderId = persistentBundle.getInt("orderId");
            localeAbbrev = persistentBundle.getString("locale");
            locale = new Locale(localeAbbrev);
            nickname = persistentBundle.getString("nickname");;
            accuracy = new Double(persistentBundle.getDouble("accuracy")).floatValue();
            locationSource = persistentBundle.getString("locationSource");
            lastLocationUpdate = persistentBundle.getLong("lastLocationUpdate");
            address = PersistableBundleBuilder.toAddress(persistentBundle.getPersistableBundle("address"));
        }
    }

