    /**
     * {@inheritDoc}
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.fso_include_in_media_scan:
                onNoMediaCheckedChanged(buttonView, isChecked);
                break;

            default:
                onPermissionsCheckedChanged(buttonView, isChecked);
                break;
        }
    }

