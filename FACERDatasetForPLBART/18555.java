	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		final DialogFragment dialog = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Set the dialog title.
        builder.setTitle(R.string.google_play_music_no_asterisk);
        builder.setMessage(getResources().getString(R.string.edit_google_play_music_tags_unsupported));
        builder.setNegativeButton(R.string.ok, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				dialog.dismiss();
				
			}
        	
        });
        
        return builder.create();
    }

