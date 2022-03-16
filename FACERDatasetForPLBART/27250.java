    public static boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException | InterruptedException e)
        {
            if (BuildConfig.DEBUG) Log.e("Network", "Internet Connection Not Available");
            e.printStackTrace();
        }
        return false;
    }

