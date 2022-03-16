    /**
     * Method that update a spinner from an {@link AID} reference
     *
     * @param spinner The spinner to update
     * @param aid The {@link AID} reference
     */
    @SuppressWarnings({"unchecked", "boxing"})
    public static void updateSpinnerFromAid(Spinner spinner, AID aid) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>)spinner.getAdapter();
        int position = adapter.getPosition(String.format(AID_FORMAT, aid.getId(), aid.getName()));
        if (position != -1) {
            spinner.setSelection(position);
        }
    }

