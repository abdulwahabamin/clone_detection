    public static PersistableBundle fromAddress(android.location.Address address) {
        if (address == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("country", address.getLocale().getCountry());
            persistableBundle.putString("language", address.getLocale().getLanguage());
            persistableBundle.putString("variant", address.getLocale().getVariant());
            persistableBundle.putString("locality", address.getLocality());
            persistableBundle.putString("subLocality", address.getSubLocality());
            persistableBundle.putString("adminArea", address.getAdminArea());
            persistableBundle.putString("subAdminArea", address.getSubAdminArea());
            persistableBundle.putString("countryName", address.getCountryName());
            return persistableBundle;
        } else {
            return null;
        }
    }

