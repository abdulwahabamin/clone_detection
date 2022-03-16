    private void showInitialGuidePage(int pageNumber) {
        final AlertDialog.Builder settingsAlert = new AlertDialog.Builder(MainActivity.this);
        switch (pageNumber) {
            case 1:
                settingsAlert.setTitle(R.string.alertDialog_voice_disclaimer_title);
                settingsAlert.setMessage(R.string.alertDialog_voice_disclaimer_message);
                setNextButton(settingsAlert, R.string.initial_guide_next);
                break;
            case 2:
                settingsAlert.setTitle(R.string.initial_guide_title_1);
                settingsAlert.setMessage(R.string.initial_guide_paragraph_1);
                setNextButton(settingsAlert, R.string.initial_guide_next);
                setPreviousButton(settingsAlert, R.string.initial_guide_close);
                break;
            case 3:
                settingsAlert.setTitle(R.string.initial_guide_title_2);
                selectedUpdateLocationStrategy = 1;
                settingsAlert.setSingleChoiceItems(R.array.location_update_strategy, selectedUpdateLocationStrategy,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedOption) {
                                selectedUpdateLocationStrategy = selectedOption;
                                if (selectedOption == 0) {
                                    initialGuidePage = 8; //skip to the last page
                                }
                            }
                        });
                setNextButton(settingsAlert, R.string.initial_guide_next);
                setPreviousButton(settingsAlert, R.string.initial_guide_previous);
                break;
            case 4:
                settingsAlert.setTitle(R.string.initial_guide_title_3);
                settingsAlert.setMessage(R.string.initial_guide_paragraph_3);
                setNextButton(settingsAlert, R.string.initial_guide_next);
                setPreviousButton(settingsAlert, R.string.initial_guide_previous);
                break;
            case 5:
                settingsAlert.setTitle(R.string.initial_guide_title_4);
                selectedLocationAndAddressSourceStrategy = 0;
                settingsAlert.setSingleChoiceItems(R.array.location_geocoder_source_entries, selectedLocationAndAddressSourceStrategy,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedOption) {
                                selectedLocationAndAddressSourceStrategy = selectedOption;
                            }
                        });
                setNextButton(settingsAlert, R.string.initial_guide_next);
                setPreviousButton(settingsAlert, R.string.initial_guide_previous);
                break;
            case 6:
                settingsAlert.setTitle(R.string.initial_guide_title_5);
                settingsAlert.setMessage(R.string.initial_guide_paragraph_5);
                setNextButton(settingsAlert, R.string.initial_guide_next);
                setPreviousButton(settingsAlert, R.string.initial_guide_previous);
                break;
            case 7:
                settingsAlert.setTitle(R.string.initial_guide_title_6);
                selectedWakeupStrategyStrategy = 2;
                settingsAlert.setSingleChoiceItems(R.array.wake_up_strategy_entries, selectedWakeupStrategyStrategy,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedOption) {
                                selectedWakeupStrategyStrategy = selectedOption;
                            }
                        });
                setNextButton(settingsAlert, R.string.initial_guide_next);
                setPreviousButton(settingsAlert, R.string.initial_guide_previous);
                break;
            case 8:
                settingsAlert.setTitle(R.string.initial_guide_title_7);
                settingsAlert.setMessage(R.string.initial_guide_paragraph_7);
                setNextButton(settingsAlert, R.string.initial_guide_next);
                setPreviousButton(settingsAlert, R.string.initial_guide_previous);
                break;
            case 9:
                settingsAlert.setTitle(R.string.initial_guide_title_8);
                selectedCacheLocationStrategy = 1;
                settingsAlert.setSingleChoiceItems(R.array.location_cache_entries, selectedCacheLocationStrategy,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedOption) {
                                selectedCacheLocationStrategy = selectedOption;
                            }
                        });
                setNextButton(settingsAlert, R.string.initial_guide_next);
                setPreviousButton(settingsAlert, R.string.initial_guide_previous);
                break;
            case 10:
                settingsAlert.setTitle(R.string.initial_guide_title_9);
                settingsAlert.setMessage(R.string.initial_guide_paragraph_9);
                setNextButton(settingsAlert, R.string.initial_guide_finish);
                setPreviousButton(settingsAlert, R.string.initial_guide_previous);
                break;
        }
        settingsAlert.show();
    }

