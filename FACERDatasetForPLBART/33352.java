    /**
     * Replaces the default dialog's title with the custom one.
     *
     * @param view custom dialog fragment's view
     */
    private void createCustomDialogTitle(View view) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        TextView customDialogTitle = (TextView) view.findViewById(R.id.city_search_dialog_title);
        String citySearchResultsDialogTitle = getCitySearchResultsDialogTitle();
        customDialogTitle.setText(citySearchResultsDialogTitle);
    }

