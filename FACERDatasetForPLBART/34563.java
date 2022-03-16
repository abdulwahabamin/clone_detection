    public boolean isNetWorkAccess(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info =  cm.getActiveNetworkInfo();
        if(info != null){
            if(info.isAvailable()){
                return true;
            }
        }
        return false ;
    }

