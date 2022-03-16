    /**
     * Obtains a listener for dialog's button clicks.
     *
     * @return a listener to handle button clicks
     */
    private OnClickListener getDialogOnClickListener() {
        OnClickListener dialogOnClickListener = new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                onDialogButtonClickedListener
                        .onCityRecordDeletionConfirmed(getArguments().getInt(
                                CityManagementActivity.CITY_ID));
            }
        };
        return dialogOnClickListener;
    }

