        @Override
        public void onReceive(Context context, Intent intent) {
            synchronized(this) {
                BLog.e("onReceive() ");
                BriefSettings settings = State.getSettings();
                if(intent.getAction().equals(Intent.ACTION_USER_BACKGROUND)) {
                    BLog.e("ACTION_USER_BACKGROUND ");
                } else if(intent.getAction().equals(Intent.ACTION_USER_FOREGROUND)) {
                    BLog.e("ACTION_USER_FOREGROUND ");
                } else {
                    BLog.e("ACTION_USER_PRESENT ");

                }
                //BLog.e("BriefService - OnUserPresentReceiver","onReceive()");

// TODO

            }

        }

