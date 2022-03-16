    private String getCitySearchResultsDialogTitle() {
        Resources res = getResources();
        String dialogTitle = res.getString(R.string.dialog_title_search_results_part_1);
        dialogTitle += TITLE_TEXT_LINE_SEPARATOR;
        dialogTitle += res.getString(R.string.dialog_title_search_results_part_2);
        return dialogTitle;
    }

