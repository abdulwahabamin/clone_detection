    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.toggle_list:

                isLinearLayoutEnabled = !isLinearLayoutEnabled;
                toggleMenuItem(item, isLinearLayoutEnabled);
                toggleListGridLayout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

