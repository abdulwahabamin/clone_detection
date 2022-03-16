    /**
     * @hide
     */
    void unmount() {
        PROMPT_DIALOG.umount();
        getKeyProvider().setKey(null);
    }

