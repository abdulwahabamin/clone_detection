    private void registerScreenListeners() {
        IntentFilter filterScreenOn = new IntentFilter(Intent.ACTION_SCREEN_ON);
        IntentFilter filterScreenOff = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        IntentFilter filterUserUnlocked = new IntentFilter(Intent.ACTION_USER_PRESENT);
        getApplication().registerReceiver(screenOnReceiver, filterScreenOn);
        getApplication().registerReceiver(screenOffReceiver, filterScreenOff);
        getApplication().registerReceiver(userUnlockedReceiver, filterUserUnlocked);
    }

