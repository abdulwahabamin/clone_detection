    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.inline_autocomplete_button_tab:
                doTab();
                break;
            default:
                break;
        }
    }

