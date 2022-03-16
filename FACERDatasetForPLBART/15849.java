    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            binder = new ServiceBinder();
            server = new Connection.ListenServer(0);
            p2pManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
            channel = p2pManager.initialize(this, Looper.getMainLooper(), null);
            p2pBroadcastReceiver = new WifiP2pBroadcastReceiver(this, p2pManager, channel);
            handler = new EasyHandler();
            handler.createHandler(THREAD_NETWORK_MANAGER);
            clientMap = new HashMap<>();

            //start listening for requests
            handler.executeAsync(new Runnable() {
                @Override
                public void run() {
                    listenForRequests();
                }
            }, THREAD_CONNECTION_LISTENER);

            File fileDir = new File(Library.FILE_SAVE_LOCATION);
            if( !(fileDir.exists()) ) {
                fileDir.mkdir();
            }
            startForeground(0, null);
        } catch (IOException e) {
            binder = null;
        }

        return super.onStartCommand(intent, flags, startId);
    }

