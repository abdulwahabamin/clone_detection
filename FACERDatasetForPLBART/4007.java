    /**
     * Load the font size settings from permanent storage.
     *
     * @param prefs Used to load the font size settings.
     */
    public void load(SharedPreferences prefs) {
        accountName = prefs.getInt(ACCOUNT_NAME, accountName);
        accountDescription = prefs.getInt(ACCOUNT_DESCRIPTION, accountDescription);

        folderName = prefs.getInt(FOLDER_NAME, folderName);
        folderStatus = prefs.getInt(FOLDER_STATUS, folderStatus);

        messageListSubject = prefs.getInt(MESSAGE_LIST_SUBJECT, messageListSubject);
        messageListSender = prefs.getInt(MESSAGE_LIST_SENDER, messageListSender);
        messageListDate = prefs.getInt(MESSAGE_LIST_DATE, messageListDate);
        messageListPreview = prefs.getInt(MESSAGE_LIST_PREVIEW, messageListPreview);

        messageViewSender = prefs.getInt(MESSAGE_VIEW_SENDER, messageViewSender);
        messageViewTo = prefs.getInt(MESSAGE_VIEW_TO, messageViewTo);
        messageViewCC = prefs.getInt(MESSAGE_VIEW_CC, messageViewCC);
        messageViewAdditionalHeaders = prefs.getInt(MESSAGE_VIEW_ADDITIONAL_HEADERS, messageViewAdditionalHeaders);
        messageViewSubject = prefs.getInt(MESSAGE_VIEW_SUBJECT, messageViewSubject);
        messageViewDate = prefs.getInt(MESSAGE_VIEW_DATE, messageViewDate);
        setMessageViewContent(prefs.getInt(MESSAGE_VIEW_CONTENT, 3));

        messageComposeInput = prefs.getInt(MESSAGE_COMPOSE_INPUT, messageComposeInput);
    }

