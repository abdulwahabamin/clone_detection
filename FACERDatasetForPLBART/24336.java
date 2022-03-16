    @Override
    protected void additionalCreate() {
        mAudioManager.registerMediaButtonEventReceiver(new ComponentName(this.getPackageName(),
                MediaButtonIntentReceiver.class.getName()));

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) { // does not work in Lollipop
            setupRemoteControl();
        }
    }

