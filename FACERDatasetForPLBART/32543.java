    public void startVoiceCommand(long incommingMessageTimestamp) {
        appendLog(getBaseContext(), TAG, "startVoiceCommand");

        appendLog(getBaseContext(),
                TAG,
                "weatherByVoiceMessages.size before peek = ", weatherByVoiceMessages);

        WeatherByVoiceRequestDataHolder updateRequest = weatherByVoiceMessages.peek();

        appendLog(getBaseContext(),
                TAG,
                "weatherByVoiceMessages.size after peek = ", weatherByVoiceMessages);

        if ((updateRequest == null) || (updateRequest.getTimestamp() < incommingMessageTimestamp)) {
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
        sayCurrentWeather(
                updateRequest.getWeather(),
                updateRequest.getLocation(),
                updateRequest.getTimeNow(),
                null,
                false);
    }

