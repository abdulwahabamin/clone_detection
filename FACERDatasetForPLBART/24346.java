    private void unregisterMediaButtenEventReceiverAndRemoteControl() {
        mAudioManager.unregisterMediaButtonEventReceiver(new ComponentName(this.getPackageName(),
                MediaButtonIntentReceiver.class.getName()));
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) { // does not work in Lollipop
            mAudioManager.unregisterRemoteControlClient(mRemoteControlClient);
        }
    }

