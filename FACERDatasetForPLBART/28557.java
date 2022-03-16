    private void enableOkButton(Boolean enabled) {
        btnSearch.setEnabled(enabled);
        if (enabled) {
            btnSearch.setBackground(getResources().getDrawable(R.drawable.button_fullwidth));
        } else  {
            btnSearch.setBackground(getResources().getDrawable(R.drawable.button_disabled));
        }
    }

