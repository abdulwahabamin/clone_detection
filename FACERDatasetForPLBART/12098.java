    /**
     * @hide
     */
    void delete() {
        PROMPT_DIALOG.delete();
        getKeyProvider().setKey(null);
    }

