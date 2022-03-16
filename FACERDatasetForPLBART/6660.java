     private void onCreateDirectoryInput() {
    	 mDirectoryInput = (LinearLayout) findViewById(R.id.directory_input);
         mEditDirectory = (EditText) findViewById(R.id.directory_text);


		 mEditDirectory.setOnKeyListener(new OnKeyListener() {
			 public boolean onKey(View v, int keyCode, KeyEvent event) {
				 // If the event is a key-down event on the "enter" button
				 if ((event.getAction() == KeyEvent.ACTION_DOWN)
						&& (keyCode == KeyEvent.KEYCODE_ENTER)){
					 
					 goToDirectoryInEditText();
					 
					 return true;
				 }
				 return false;
			 }
		 });

         mButtonDirectoryPick = (ImageButton) findViewById(R.id.button_directory_pick);
         
         mButtonDirectoryPick.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					goToDirectoryInEditText();
				}
         });
     }

