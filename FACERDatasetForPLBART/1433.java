        @Override
        public void onStreamSent(int status){
            if(status == BLEChatEvents.SENT_SUCCEED){
                mStreamThread.nextMessage();
            }else{
                mStreamThread.end();
                showInfo("Error sending data!!");
            }
        }

