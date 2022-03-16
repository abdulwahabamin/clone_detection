    /**
     * Shows an alert dialog informing that no cities were found for the query.
     */
    private void showNoCitiesFoundAlertDialog() {
        String dialogTitle = activity.getResources().getString(
                R.string.dialog_title_no_cities_found);
        String dialogMessage = MiscMethods.getNoCitiesFoundDialogMessage(activity.getResources());
        DialogFragment dialogFragment = GeneralDialogFragment.newInstance(dialogTitle,
                dialogMessage);
        dialogFragment.show(activity.getSupportFragmentManager(),
                NO_CITIES_FOUND_DIALOG_FRAGMENT_TAG);
    }

