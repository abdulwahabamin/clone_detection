    public static void log(String tag,String k)
    {
        if (BuildConfig.DEBUG)
        {
            Log.d(tag,k.toString());
        }
    }

