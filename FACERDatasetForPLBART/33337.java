    @Override
    public void onCityNameChangeRequested(final int cityId, final String originalName) {
        AlertDialog.Builder cityNameChangeDialog = new AlertDialog.Builder(this);

        String dialogTitle = getDialogTitle(originalName);
        cityNameChangeDialog.setTitle(dialogTitle);

        final EditText cityNameEditText = getNewCityNameEditText();
        cityNameChangeDialog.setView(cityNameEditText);

        DialogInterface.OnClickListener dialogOnClickListener = getDialogOnClickListener(
                cityId, originalName, cityNameEditText);
        cityNameChangeDialog.setPositiveButton(android.R.string.ok, dialogOnClickListener);

        cityNameChangeDialog.show();
    }

