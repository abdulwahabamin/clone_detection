    public static void hideKeyboard(Activity activity) {
     	InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
    	if(imm!=null) {
    		View v = activity.findViewById(R.id.container);
    		if(v!=null)
    			imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    		else
    			BLog.e("keyboard", "fail hide 1");
    	} else
			BLog.e("keyboard", "fail hide 2");
    }

