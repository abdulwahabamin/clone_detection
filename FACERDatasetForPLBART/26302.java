    @OnClick({R2.id.action_back, R2.id.action_empty_btn})
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.action_back) {
            finish();

        } else if (i == R.id.action_empty_btn) {
            mSearchTextView.setText("");

        }
    }

