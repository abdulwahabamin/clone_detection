    /**
     * Obtains an editable view were the new city name should be typed in.
     *
     * @return an editable view for the new city name
     */
    private EditText getNewCityNameEditText() {
        final EditText cityNameEditText = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        cityNameEditText.setLayoutParams(lp);
        return cityNameEditText;
    }

