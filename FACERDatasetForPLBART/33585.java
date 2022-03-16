    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        String title = args.getString(TITLE);
        String message = args.getString(MESSAGE);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        DialogInterface.OnClickListener onClickListener = getDialogOnClickListener();
        builder.setTitle(title);
        if (message != null) {
            builder.setMessage(message);
        }
        builder.setPositiveButton(android.R.string.ok, onClickListener);
        return builder.create();
    }

