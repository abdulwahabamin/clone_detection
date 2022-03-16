    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
    	if(SERVICE==null) {
    		SERVICE=this;
    	//doFirstTimeCheck();
    		


            BLog.e("SERVICE", "BrowseService started");

            //runner = new BrowseServiceRunner();
            //runner.i    intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
            ensureStartups(getBaseContext());

            IntentFilter ubfilter = new IntentFilter(Intent.ACTION_USER_PRESENT);
            ubreceiver=new OnUserPresentReceiver();
            registerReceiver(ubreceiver, ubfilter);

            //IntentFilter ubackfilter = new IntentFilter(Intent.ACTION_USER_BACKGROUND);
            //ubackreceiver=new OnUserPresentReceiver();
            //registerReceiver(ubackreceiver, ubackfilter);

            //IntentFilter uforefilter = new IntentFilter(Intent.ACTION_USER_FOREGROUND);
            //uforereceiver=new OnUserPresentReceiver();
            //registerReceiver(uforereceiver, uforefilter);


            IntentFilter pconfilter = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
            pconreceiver = new OnPcConnectReceiver();
            registerReceiver(pconreceiver, pconfilter);

            IntentFilter pdisconfilter = new IntentFilter(Intent.ACTION_POWER_DISCONNECTED);
            pdisconreceiver = new OnPcDisconnectReceiver();
            registerReceiver(pdisconreceiver, pdisconfilter);


            String fobp = Environment.getExternalStorageDirectory().toString();//Environment.getExternalStorageDirectory().toString()+File.separator+"Pictures";
            fileObserver = new FileObserver(fobp) { // set up a file observer to watch this directory on sd card

                @Override
                public void onEvent(int event, String file) {

                    if(file!=null && !file.endsWith(".os")) {

                        switch (event) {
                            case FileObserver.DELETE:
                            case FileObserver.DELETE_SELF:
                                BLog.e("FO", "Delete self ["+event+" : " +Environment.getExternalStorageDirectory().toString()+File.separator+ file + "]");
                                Indexer.removeFileFromIndex(new FileItem(Environment.getExternalStorageDirectory().toString() + File.separator + file));
                                break;
                            case FileObserver.MODIFY:
                                BLog.e("MODIFY event: " + event + "-" + file);
                            case FileObserver.CREATE:
                                //BLog.e("event: " + event + "-" + file);
                                SERVICE.eventReceived(Environment.getExternalStorageDirectory().toString()+File.separator+ file, Cal.getUnixTime());
                                break;
                            case FileObserver.OPEN:
                                SERVICE.recentlyOpenedFiles(Environment.getExternalStorageDirectory().toString()+File.separator+ file, Cal.getUnixTime());
                                break;

                        }

                        /*
                        switch (event) {
                            case FileObserver.DELETE_SELF:
                                BLog.e("FO", "Delete self ["+event+" : " +Environment.getExternalStorageDirectory().toString()+File.separator+ file + "]");
                                Indexer.removeFileFromIndex(new FileItem(Environment.getExternalStorageDirectory().toString() + File.separator + file));
                                break;
                            case FileObserver.MODIFY:
                            case FileObserver.CREATE:
                            case FileObserver.DELETE:
                            case FileObserver.OPEN:
                                BLog.e("FO", "File MODIFY, OPEN,  CREATE, DELETE [" + event + " : " + Environment.getExternalStorageDirectory().toString() + File.separator + file + "]");
                                Indexer.indexFile(new FileItem(Environment.getExternalStorageDirectory().toString() + File.separator + file));
                                break;

                        }
*/
                        //File f = new File(Environment.getExternalStorageDirectory().toString()+File.separator+ file);
                        //Indexer.refresh(SERVICE,Environment.getExternalStorageDirectory().toString()+File.separator+ file);
                    }


                }
            };
            fileObserver.startWatching();

            if(runIndexTask==null && Device.isMediaMounted()) {
                runIndexTask=new RunIndexingTask();
                runIndexTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);
            }

    	}

    	return START_STICKY;
    }

