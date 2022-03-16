    public static final String getPemKey() {
        if(HOME.pemKey!=null)
            return HOME.pemKey;
        if(Validator.isValidCaller()) {
            //Holder hold=HOME.new Holder();
            //Log.e("CRATEKEY","start................................................................................");
            HOME.pemKey=getUniqueDeviceId(HOME.context)+"Br13fR0ck5"+getAndroidId(HOME.context);
            //Log.e("CRATEKEY",HOME.pemKey);
            return HOME.pemKey;
        }
        return null;
    }

