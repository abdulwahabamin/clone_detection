        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MESSAGE_DOWNLOAD) {
                Z z = (Z) msg.obj;
                mThreadData.get().resultFromServer(z);
                Log.d(TAG, "handleMessage: " + z.toString());
            }
        }

