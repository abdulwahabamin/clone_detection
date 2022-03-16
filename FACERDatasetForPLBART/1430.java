        @Override
        public void onConnectRfcommSocket(){
            synchronized (mLock){
                showInfo("RFCOMM: Client connected");
            }
        }

