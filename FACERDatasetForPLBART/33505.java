    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getDialogTitle();
        OnClickListener dialogOnClickListener = getDialogOnClickListener();
        CharSequence positiveButtonText = parentActivity.getResources()
                .getString(android.R.string.ok);
        return new AlertDialog.Builder(parentActivity)
                .setIcon(R.drawable.ic_delete)
                .setTitle(title)
                .setPositiveButton(positiveButtonText, dialogOnClickListener)
                .create();
    }

