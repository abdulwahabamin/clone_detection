    private void startThread(int threadMode) {

        if (threadMode==MODE_ACCEPT)
        {
            thread=new AcceptThread(macAddress_other);

        }else
        {
            thread=new ConnectThread(device_other);
        }
        thread.start();
    }

