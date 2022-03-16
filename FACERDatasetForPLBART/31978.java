    public static android.location.Location toLocation(PersistableBundle persistableBundle) {
        if (persistableBundle == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String provider = persistableBundle.getString("provider");
            android.location.Location location = new android.location.Location(provider);
            location.setLatitude(persistableBundle.getDouble("latitude"));
            location.setLongitude(persistableBundle.getDouble("longitude"));
            location.setAccuracy(new Double(persistableBundle.getDouble("accuracy")).floatValue());
            return location;
        } else {
            return null;
        }
    }

