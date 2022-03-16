    @Subscribe
    public void onEvent(ChangeEvent event) {
        switch (event.getEventId()) {
            case ChangeEvent.CHANGE_CONTENT:
                if (BuildConfig.DEBUG)  Log.d(LOG_TAG, "Content Change Event - reload weather data from network");
                updateDataFromNetwork();
                break;
            case ChangeEvent.CHANGE_LANGUAGE:
                recreate();
                break;
        }
    }

