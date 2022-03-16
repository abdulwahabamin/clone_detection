    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_storages) {
            new StorageSelectDialog(getActivity())
                    .setDirSelectListener(this)
                    .show();
        }
        return super.onOptionsItemSelected(item);
    }

