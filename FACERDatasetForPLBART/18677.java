    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_done:
                mDoneButtonPressed = true;
                buildApplyToDialog().show();
                return true;
            default:
                //Return false to allow the activity to handle the item click.
                return false;
        }

    }

