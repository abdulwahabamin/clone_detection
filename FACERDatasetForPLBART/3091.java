     private void onCreateDirectoryInput() {
    	 mDirectoryInput = (LinearLayout) findViewById(R.id.directory_input);
         mEditDirectory = (EditText) findViewById(R.id.directory_text);

         mButtonDirectoryPick = (ImageButton) findViewById(R.id.button_directory_pick);
         
         mButtonDirectoryPick.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					goToDirectoryInEditText();
				}
         });
     }

