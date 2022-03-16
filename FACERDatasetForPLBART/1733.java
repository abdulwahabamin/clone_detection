    	@Override
        public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
            // If the action is a key-up event on the return key, send the message
        	try{
	            if(actionId == EditorInfo.IME_ACTION_SEND) {
	            	/*
	            	InputMethodManager imm = (InputMethodManager)getSystemService(
	            		      Context.INPUT_METHOD_SERVICE);
	            		imm.hideSoftInputFromWindow(mOutEditText.getWindowToken(), 0);
	            		*/
	                String message = view.getText().toString();
	                sendMessage(message);
	            }
	            if(Constants.D) Log.i(Constants.TAG, "END onEditorAction");
	            return true;
        	}catch(Exception e){
        		if(Constants.D) Log.e(Constants.TAG, "END onEditorAction");
        		e.printStackTrace();
        	}
    		return false;
        }

