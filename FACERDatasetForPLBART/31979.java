    public static PersistableBundle fromLocation(android.location.Location location) {
        if (location == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putDouble("latitude", location.getLatitude());
            persistableBundle.putDouble("latitude", location.getLatitude());
            persistableBundle.putDouble("accuracy", location.getAccuracy());
            persistableBundle.putString("provider", location.getProvider());
            return persistableBundle;
        } else {
            return null;
        }
    }

