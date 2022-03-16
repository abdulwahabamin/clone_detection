        @Override
        public void onReceive(Context context, Intent intent) {
            if (AudioManager.ACTION_AUDIO_BECOMING_NOISY.equals(intent.getAction())) {
                Log.d(TAG, "BecomingNoisyReceiver.onReceive()");
                pausePlayer();
            }
        }

