    public PersistableBundle getPersistableBundle() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putLong("id", id);
            persistableBundle.putDouble("latitude", latitude);
            persistableBundle.putDouble("longitude", longitude);
            persistableBundle.putInt("orderId", orderId);
            persistableBundle.putString("locale", localeAbbrev);
            persistableBundle.putString("nickname", nickname);
            persistableBundle.putDouble("accuracy", new Double(accuracy));
            persistableBundle.putString("locationSource", locationSource);
            persistableBundle.putLong("lastLocationUpdate", lastLocationUpdate);
            persistableBundle.putPersistableBundle("address", PersistableBundleBuilder.fromAddress(address));
            return persistableBundle;
        } else {
            return null;
        }
    }

