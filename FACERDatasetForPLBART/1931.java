    public boolean isloggedIn(){
        boolean valid=true;

        if (sharedPrefs.getString(USER_NAME).isEmpty())
        {
            valid=false;
        }

        return valid;
    }

