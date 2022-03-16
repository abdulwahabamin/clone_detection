    /**
     * Permanently save the font size settings.
     *
     * @param editor Used to save the font size settings.
     */
    public void save(SharedPreferences.Editor editor) {
        editor.putInt(ACCOUNT_NAME, accountName);
        editor.putInt(ACCOUNT_DESCRIPTION, accountDescription);

        editor.putInt(FOLDER_NAME, folderName);
        editor.putInt(FOLDER_STATUS, folderStatus);

        editor.putInt(MESSAGE_LIST_SUBJECT, messageListSubject);
        editor.putInt(MESSAGE_LIST_SENDER, messageListSender);
        editor.putInt(MESSAGE_LIST_DATE, messageListDate);
        editor.putInt(MESSAGE_LIST_PREVIEW, messageListPreview);

        editor.putInt(MESSAGE_VIEW_SENDER, messageViewSender);
        editor.putInt(MESSAGE_VIEW_TO, messageViewTo);
        editor.putInt(MESSAGE_VIEW_CC, messageViewCC);
        editor.putInt(MESSAGE_VIEW_ADDITIONAL_HEADERS, messageViewAdditionalHeaders);
        editor.putInt(MESSAGE_VIEW_SUBJECT, messageViewSubject);
        editor.putInt(MESSAGE_VIEW_DATE, messageViewDate);
        editor.putInt(MESSAGE_VIEW_CONTENT, getMessageViewContentAsInt());

        editor.putInt(MESSAGE_COMPOSE_INPUT, messageComposeInput);
    }

