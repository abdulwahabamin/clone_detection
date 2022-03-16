        public void run(){
            showProgressBar();
            try {
                Thread.sleep(2000);
                sendViaEvent();
                //sendViaLoop();
            }catch (InterruptedException ex){
                mBLEChatEvents.onConnectionError("Interrupted while sleeping!!!");
            }finally {
                hideProgressBar();
            }
        }

