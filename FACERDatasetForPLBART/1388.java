    private synchronized void processOutgoingMsg(String message){
        if(message.startsWith("/")){
            String[] tokens = message.split(" ", 2);
            if(tokens[0].compareTo("/transfertest") == 0){
                // We change the MTU to 512 first
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BLECentralHelper.getInstance().changeMtu(512);
                    }
                }, 2100);
                return;
            }else if(tokens[0].compareTo("/transfer") == 0){
                sendStream();
                return;
            }
        }
        sendMessage(message);
    }

