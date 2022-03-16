    /**
     * Obtain a listener for dialog button clicks.
     *
     * @param cityId           OpenWeatherMap city ID
     * @param originalName     current city name
     * @param cityNameEditText an editable view for the new city name
     * @return a dialog button clicks listener
     */
    private DialogInterface.OnClickListener getDialogOnClickListener(
            final int cityId, final String originalName,
            final EditText cityNameEditText) {
        DialogInterface.OnClickListener dialogOnClickListener = new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                String newName = cityNameEditText.getText().toString();
                if (newName.length() == 0) {
                    showEmptyNameErrorMessage();
                } else {
                    boolean userNameHasBeenChanged = !newName.equals(originalName);
                    if (userNameHasBeenChanged) {
                        renameCity(cityId, newName);
                    }
                }
            }
        };
        return dialogOnClickListener;
    }

