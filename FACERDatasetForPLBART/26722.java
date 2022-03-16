    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                AboutDialog exitDialog =
                        (AboutDialog) getFragmentManager().findFragmentByTag(AboutDialog.ABOUT_DIALOG_TAG);
                if (exitDialog == null) exitDialog = AboutDialog.newInstance();
                if (!exitDialog.isAdded()) {
                    exitDialog.show(getFragmentManager().beginTransaction(), AboutDialog.ABOUT_DIALOG_TAG);
                }
                return true;
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

