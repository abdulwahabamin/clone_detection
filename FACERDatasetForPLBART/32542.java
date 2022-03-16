    public void startAllLocationsVoiceCommand(long incomingMessageTimestamp,
                                              Long voiceSettingId) {
        appendLog(getBaseContext(), TAG, "startVoiceCommand");

        appendLog(getBaseContext(),
                TAG,
                "weatherByVoiceMessages.size before peek = ", weatherByVoiceMessages);

        WeatherByVoiceRequestDataHolder updateRequest = weatherByVoiceMessages.peek();

        appendLog(getBaseContext(),
                TAG,
                "weatherByVoiceMessages.size after peek = ", weatherByVoiceMessages);

        if ((updateRequest == null) || (updateRequest.getTimestamp() < incomingMessageTimestamp)) {
            if (updateRequest != null) {
                appendLog(getBaseContext(),
                        TAG,
                        "updateRequest is older than current");
            } else {
                appendLog(getBaseContext(),
                        TAG,
                        "updateRequest is null");
            }
            appendLog(getBaseContext(),
                    TAG,
                    "weatherByVoiceMessages.size when request is old or null = ", weatherByVoiceMessages);
            return;
        }
        sayForLocation(voiceSettingId, true);
    }

