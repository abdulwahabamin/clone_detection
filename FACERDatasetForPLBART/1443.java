        private void sendViaEvent(){
            int iBytesSent = 0;
            int iMtu = BLECentralHelper.getInstance().getMtu();
            while(!mEnd && iBytesSent < 1024 * 1024) {
                processOutgoingMsg("/transfer");
                iBytesSent += iMtu;
                updateProgressBar(iBytesSent);
                try {
                    mSemaphore.acquire();
                }catch (InterruptedException ex){
                    mBLEChatEvents.onConnectionError("Interrupted while in a semaphore!!");
                }
            }
        }

