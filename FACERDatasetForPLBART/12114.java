    /**
     * Method that return or prompt the user for the secure storage key
     *
     * @param read If should return the read or write key
     * @return AesCipherParameters The AES cipher parameters
     */
    private static synchronized AesCipherParameters getOrPromptForKey(boolean read)
            throws UnknownKeyException {
        // Check if we have a cached key
        if (read && sResetInProgress && sOldUnlockKey != null) {
            return sOldUnlockKey;
        }
        if (sUnlockKey != null) {
            return sUnlockKey;
        }

        // Need to prompt the user for the secure storage key, so we open a overlay activity
        // to show the prompt dialog
        Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message inputMessage) {
                Context ctx = FileManagerApplication.getInstance();
                Intent intent = new Intent(ctx, SecureStorageKeyPromptActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        };
        handler.sendEmptyMessage(MSG_REQUEST_UNLOCK_DIALOG);

        // Wait for the response
        synchronized (WAIT_SYNC) {
            try {
                WAIT_SYNC.wait();
            } catch (InterruptedException ex) {
                throw new KeyPromptingInterruptedException(ex);
            }
        }

        // Request for authentication is done. We need to exit from delete status
        sDeleteInProgress = false;

        // Check if the user cancelled the dialog
        if (sUnlockKeyTemp == null) {
            throw new KeyPromptingCancelledException();
        }

        // Move temporary params to real params
        sUnlockKey = sUnlockKeyTemp;
        sOldUnlockKey = sOldUnlockKeyTemp;

        AesCipherParameters key = sUnlockKey;
        if (sResetInProgress && read) {
            key = sOldUnlockKey;
        }
        return key;
    }

