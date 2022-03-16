            public boolean handleMessage(Message msg) {
                    switch (msg.what) {
                    case COMPLETE:
                    		if(mBitmap!=null) {
                    			mImage.setImageBitmap(mBitmap);
                    		} else {
                    			mImage.setImageDrawable(mDrawable);
                    		}
                            mImage.setVisibility(View.VISIBLE);
                            mSpinner.setVisibility(View.GONE);
                            break;
                    case FAILED:
                    default:
                            mImage.setImageResource(R.drawable.action_help);
                            mImage.setVisibility(View.VISIBLE);
                            mSpinner.setVisibility(View.GONE);
                            // Could change image here to a 'failed' image
                            // otherwise will just keep on spinning
                            break;
                    }
                    return true;
            }               

