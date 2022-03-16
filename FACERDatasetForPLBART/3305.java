        @Override
        public void onReceive(Context context, Intent intent) {
            synchronized(this) {
                SERVICE.PC_CONNECTED=false;
                BLog.e("BriefService - OnPcDisconnectReceiver","onReceive()");

            }

        }

