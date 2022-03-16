    /**
     * This method is part of an automatic ping-ping conversation like.
     * @param msg
     */
    private void answerBack(String msg){
        final String mMsg = msg;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "ConversationThread::run()");
                String response = (mMsg.equalsIgnoreCase("PING") ? "PONG" : "PING");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                sendMessage(response);
            }
        }, 2000);
    }

