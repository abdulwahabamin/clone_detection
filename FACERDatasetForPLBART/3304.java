        @Override
        public void onReceive(Context context, Intent intent) {
            synchronized(this) {
                SERVICE.PC_CONNECTED=true;
                BLog.e("BriefService - OnPcConnectReceiver","onReceive()");
            }

        }

