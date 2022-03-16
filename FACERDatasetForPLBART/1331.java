    /**
     *
     * @param data
     */
    private synchronized void send2Rfcomm(byte[] data){
        try {
            OutputStream stream = mSocket.getOutputStream();
            stream.write(data);
        }catch (IOException e){
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mBleChatEvents.onConnectionError("Error sending message to RFCOMM Socket");
                }
            });

        }
    }

