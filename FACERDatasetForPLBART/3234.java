	private void init(Context context) {
		this.setBackgroundResource(R.drawable.btn_general);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		//params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		params.setMargins(1,1,1,1);
		this.setLayoutParams(params);
		this.setTextSize(16);
		//this.setTextColor(context.getResources().getColor(R.color.black));
		this.setPadding(2, 0, 5,0);
		this.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));

	}

