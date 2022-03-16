	private void setAccentColors(int color){
		View shuffleBG = findViewById(R.id.shufflebackground);
		View buttonBG = findViewById(R.id.playpausepreviousbackground);
		View spacer1 = findViewById(R.id.spacer1);
		View spacer2 = findViewById(R.id.spacer2);
		if(shuffleBG != null && buttonBG != null && spacer1 != null && spacer2 != null){
			shuffleBG.setBackgroundColor(color);
			buttonBG.setBackgroundColor(color);
			spacer1.setBackgroundColor(color);
			spacer2.setBackgroundColor(color);
		}
	}

