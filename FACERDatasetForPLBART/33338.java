    /**
     * Creates the dialog's title.
     *
     * @param originalName current city name
     * @return the dialog title, asking to enter a new name for the city
     */
    private String getDialogTitle(final String originalName) {
        Resources res = getResources();
        return String.format(res.getString(R.string.dialog_title_rename_city), originalName);
    }

