    @Override
    public void promptWriteKey(Controller<AesCipherParameters> controller)
            throws UnknownKeyException {
        controller.setKey(getOrPromptForKey(false));
        if (sResetInProgress) {
            // Not needed any more. Reads are now done with new key
            sOldUnlockKey = null;
            sResetInProgress = false;
        }
    }

