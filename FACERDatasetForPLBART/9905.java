    /**
     * Method that shows a simple message on the spinner (loading, error, ...)
     *
     * @param ctx The current context
     * @param spinner The spinner
     * @param msg The message
     * @hide
     */
    static void setSpinnerMsg(Context ctx, Spinner spinner, String msg) {
        ArrayAdapter<String> loadingAdapter =
                new ArrayAdapter<String>(
                        ctx, R.layout.spinner_item, new String[]{msg});
        loadingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(loadingAdapter);
        spinner.setEnabled(false);
    }

