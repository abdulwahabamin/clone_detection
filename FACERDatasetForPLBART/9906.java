    /**
     * Method that fills the spinner with the data
     *
     * @param ctx The current context
     * @param spinner The spinner
     * @param data The data
     * @param selection The object to select
     * @hide
     */
    void setSpinnerData(
            Context ctx, Spinner spinner, String[] data, int selection) {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        ctx, R.layout.spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(selection);
        spinner.setEnabled(this.mHasPrivileged);
    }

