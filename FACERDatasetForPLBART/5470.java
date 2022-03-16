     private void checkButtonLayout() {
    	 
    	 // Let's measure how much space we need:
    	 int spec = View.MeasureSpec.UNSPECIFIED;
    	 mDirectoryButtons.measure(spec, spec);
    	 int count = mDirectoryButtons.getChildCount();
    	 
    	 int requiredwidth = mDirectoryButtons.getMeasuredWidth();
    	 int width = getWindowManager().getDefaultDisplay().getWidth();
    	 
    	 if (requiredwidth > width) {
        	 int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
        	 int WRAP_CONTENT = LinearLayout.LayoutParams.WRAP_CONTENT;
        	 
        	 // Create a new button that shows that there is more to the left:
        	 ImageButton ib = new ImageButton(this);
        	 ib.setImageResource(R.drawable.ic_menu_back_small);
    		 ib.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, MATCH_PARENT));
    		 // 
    		 ib.setOnClickListener(new View.OnClickListener() {
    				public void onClick(View view) {
    					// Up one directory.
    					upOneLevel();
    				}
    		 });
    		 mDirectoryButtons.addView(ib, 0);
    		 
    		 // New button needs even more space
    		 ib.measure(spec, spec);
    		 requiredwidth += ib.getMeasuredWidth();

    		 // Need to take away some buttons
    		 // but leave at least "back" button and one directory button.
    		 while (requiredwidth > width && mDirectoryButtons.getChildCount() > 2) {
    			 View view = mDirectoryButtons.getChildAt(1);
    			 requiredwidth -= view.getMeasuredWidth();
    			 
	    		 mDirectoryButtons.removeViewAt(1);
    		 }
    	 }
     }

