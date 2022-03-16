    public static BLECentralHelper getInstance(){
        if(instance == null){
            synchronized (BLECentralHelper.class){
                if(instance == null){
                    instance = new BLECentralHelper();
                }
            }
        }
        return instance;
    }

