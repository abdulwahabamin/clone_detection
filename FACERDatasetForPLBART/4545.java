	    private void setAnimListners(final FileItem curMail) {
	        AnimationListener animListner;
	        animListner = new AnimationListener() {
	 
	            @Override
	            public void onAnimationStart(Animation animation) {
	                if (animation == animation1) {
//
	                    ivFlip.clearAnimation();
	                    ivFlip.setAnimation(animation2);
	                    ivFlip.startAnimation(animation2);
	                } else {
	                    //curMail.setChecked(!curMail.isChecked());
	                    //setCount();
	                    setActionMode();
	                }
	            }
	            // Show/Hide action mode
	            private void setActionMode() {

	            	if (!fm.getSelectedFiles().isEmpty()) {
	                    if (!fileSelectedActionSelecter.isActionModeShowing) {
                            fileSelectedActionSelecter.mMode = ((AppCompatActivity)activity).getSupportActionBar().startActionMode(fileSelectedActionSelecter);
							fileSelectedActionSelecter.isActionModeShowing = true;
	                    }
	                } else if (fileSelectedActionSelecter.mMode != null) {
                        fileSelectedActionSelecter.mMode.finish();
                        fileSelectedActionSelecter.isActionModeShowing = false;
	                }
	 
	                // Set action mode title
	                if (fileSelectedActionSelecter.mMode != null)
                        fileSelectedActionSelecter.mMode.setTitle(fm.getSelectedFiles().size()+" "+activity.getResources().getString(R.string.label_files));
	 
	                notifyDataSetChanged();
	 
	            }
	 
	            @Override
	            public void onAnimationRepeat(Animation arg0) {
	                // TODO Auto-generated method stub
	 
	            }
	 
	            @Override
	            public void onAnimationEnd(Animation arg0) {
	                // TODO Auto-generated method stub
	 
	            }
	        };
	 
	        animation1.setAnimationListener(animListner);
	        animation2.setAnimationListener(animListner);
	 
	    }

