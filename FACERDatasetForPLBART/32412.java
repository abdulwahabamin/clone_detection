    private boolean networkIsOffline() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        appendLog(context, TAG, "networkIsOffline, networkInfo=", networkInfo);
        if (networkInfo == null) {
            return true;
        }
        appendLog(context, TAG,
                "networkIsOffline, networkInfo.isConnectedOrConnecting()=",
                networkInfo.isConnectedOrConnecting());
        return !networkInfo.isConnectedOrConnecting();
    }

