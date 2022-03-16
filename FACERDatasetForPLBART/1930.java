    public static SharedPrefs getPrefs()
    {
        if(sharedPrefs==null)
        {
            sharedPrefs=new SharedPrefs();
        }
        return sharedPrefs;
    }

