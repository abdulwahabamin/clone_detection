    public static String getNetworkErrorText(Throwable t)
    {
        if (t instanceof SocketException)
        {
            return "";
        }

        if (!isNetworkAvailable())
        {
            Utils.log("no internet");
            return "No Internet Connection!";
        }

        if(t instanceof IOException)
        {
            return "";
        }

        return "Failed";
    }

