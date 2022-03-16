    public static void setKeyboard(Activity activity, View editTextView, boolean showKeyboard) {
        editTextView.requestFocus();
     	InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
    	if(imm!=null) {

    			if(showKeyboard) {
                    imm.showSoftInput(editTextView, 0);
                    //if(getKeyboardHeight(activity)==0) {
                        //GetSetHeight getSetHeight = D.new GetSetHeight();
                        //getSetHeight.setActivity(activity);

                        //getSetHeight.setParentView(parentView);
                        //getSetHeightHandler.removeCallbacks(getSetHeight);
                        //getSetHeightHandler.postDelayed(getSetHeight, 1001);
                    //}

                } else {
                    imm.hideSoftInputFromWindow(editTextView.getWindowToken(), 0);
                }

    	} else
			BLog.e("keuboard", "fail hide 2");
    }

