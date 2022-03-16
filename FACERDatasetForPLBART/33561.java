    @Override
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        ListAdapter listAdapter = new ArrayAdapter(getContext(),
                R.layout.row_custom_preference_list, getEntries());

        builder.setAdapter(listAdapter, this);
        super.onPrepareDialogBuilder(builder);
    }

