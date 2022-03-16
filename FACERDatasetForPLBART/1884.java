    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE=getApplicationContext();
        currentWindow="";
        macAdress_my=BlueHelper.getBluetoothAdapter().getAddress();
        addressName=new HashMap<>();
        notify_id=new HashMap<>();
        notify_count=new HashMap<>();
        EventBus.getDefault().register(this);
    }

