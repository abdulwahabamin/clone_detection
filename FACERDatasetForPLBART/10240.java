    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.inline_autocomplete_button_tab:
                //Complete with current suggestion
                String filter = this.mBackgroundText.getText().toString();
                if (this.mBackgroundText.getVisibility() == View.VISIBLE && filter.length() > 0) {
                    setText(filter);
                } else {
                    post(new Runnable() {
                        @Override
                        public void run() {
                            DialogHelper.showToast(
                                    getContext(),
                                    R.string.inline_autocomplete_tab_nothing_to_complete_msg,
                                    Toast.LENGTH_SHORT);
                        }
                    });
                }
                return true;

            default:
                break;
        }
        return false;
    }

