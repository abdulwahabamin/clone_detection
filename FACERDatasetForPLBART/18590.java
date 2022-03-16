	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

		fileName = getArguments().getString("FILE_NAME");
		
		final DialogFragment dialog = this;
		
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Set the dialog title.
        builder.setTitle(R.string.error);
        builder.setMessage(fileName + " " + getResources().getString(R.string.invalid_file_message));
        builder.setNegativeButton(R.string.ok, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				dialog.dismiss();
				
			}
        	
        });
        
        return builder.create();
    }

