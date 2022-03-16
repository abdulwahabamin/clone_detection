    public static android.location.Address toAddress(PersistableBundle persistableBundle) {
        if (persistableBundle == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String language = persistableBundle.getString("language");
            String country = persistableBundle.getString("country");
            String variant = persistableBundle.getString("variant");
            Locale addressLocale = new Locale(language, country, variant);
            android.location.Address address = new android.location.Address(addressLocale);
            address.setLocality(persistableBundle.getString("locality"));
            address.setSubLocality(persistableBundle.getString("subLocality"));
            address.setAdminArea(persistableBundle.getString("adminArea"));
            address.setSubAdminArea(persistableBundle.getString("subAdminArea"));
            address.setCountryName(persistableBundle.getString("countryName"));
            return address;
        } else {
            return null;
        }
    }

