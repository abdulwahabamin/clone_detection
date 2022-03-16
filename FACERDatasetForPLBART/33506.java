    /**
     * Obtains the city deletion dialog title.
     *
     * @return text asking for the city deletion confirmation
     */
    private String getDialogTitle() {
        Resources res = parentActivity.getResources();
        final String cityName = getArguments().getString(CITY_NAME);
        return String.format(res.getString(R.string.dialog_title_delete_city), cityName);
    }

