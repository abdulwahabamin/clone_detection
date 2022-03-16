    @Override
    public void promptReadKey(Controller<AesCipherParameters> controller, boolean invalid)
            throws UnknownKeyException {
        if (!sResetInProgress && invalid) {
            sUnlockKey = null;
        }
        controller.setKey(getOrPromptForKey(true));
    }

