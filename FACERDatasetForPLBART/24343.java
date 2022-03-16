    private void registerMediaButtonEventReceiverAndRemoteControl() {
        mAudioManager.registerMediaButtonEventReceiver(new ComponentName(getPackageName(),
                MediaButtonIntentReceiver.class.getName()));
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) { // does not work in Lollipop
            mAudioManager.registerRemoteControlClient(mRemoteControlClient);
        }
    }

