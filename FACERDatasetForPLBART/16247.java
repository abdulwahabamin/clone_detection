        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            //用绑定方法�?�动service，就是从这里绑定并得到service，然�?�就�?�以�?作service了
            mService = ((MusicService.LocalBinder) service).getService();
            mService.setContext(getApplicationContext());
        }

