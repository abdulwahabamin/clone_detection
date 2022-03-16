    /**
     * Shows a Snackbar to undo the deletion of a CityOverviewListItem.
     *
     * @param cityToRestore        The CityToWatch record that was deleted but shall be restored now.
     * @param weatherDataToRestore The CurrentWeatherData record that was deleted but shall be
     *                             restored now.
     * @return Returns the Snackbar to show.
     */
    private Snackbar getUndoSnackbar(final CityToWatch cityToRestore, final CurrentWeatherData weatherDataToRestore) {
        final String MSG = context.getResources().getString(R.string.activity_main_snackbar_undo_info);
        final String BTN_TEXT = context.getResources().getString(R.string.activity_main_snackbar_undo_button);
        return Snackbar
                .make(
                        ((Activity) (context)).findViewById(R.id.main_content),
                        MSG,
                        Snackbar.LENGTH_LONG
                )
                .setAction(BTN_TEXT, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        try {
//                            // TODO Re-Insert
//
//                        } catch (SQLException e) {
//                            e.printStackTrace();
//                            // TODO: Handle the error case
//                        }
                    }
                });
    }

