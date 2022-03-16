    public static boolean isNetworkAvailable(Context context) {
        if (null == context)
            throw new IllegalArgumentException("isNetworkAvailable argument cannot be null");

        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null)
                return networkInfo.isAvailable();
        }

        return false;
    }

