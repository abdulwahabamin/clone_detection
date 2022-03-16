        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_MEDIA_EJECT)) {
                saveQueue(true);
                mQueueIsSaveable = false;
                closeExternalStorageFiles();
            } else if (action.equals(Intent.ACTION_MEDIA_MOUNTED)) {
                mCardId = fetchCardId();
                reloadQueue();
                mQueueIsSaveable = true;
                notifyChange(QUEUE_CHANGED);
                notifyChange(META_CHANGED);
            }
        }

