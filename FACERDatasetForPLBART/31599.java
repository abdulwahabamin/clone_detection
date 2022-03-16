    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.auto_update_frequency)
                .setItems(R.array.update_frequency_string, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (mListener != null)
                    mListener.onDialogItemClick(which);
            }
        });
        return builder.create();
    }

