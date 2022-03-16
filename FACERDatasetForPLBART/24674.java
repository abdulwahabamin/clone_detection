		/**
		 * call back method
		 */
		@Override
		public void onReceive(Context context, Intent intent) {
			String lrcMessage=intent.getStringExtra("lrcMessage");
			lrcTextView.setText(lrcMessage);  //after receive the message, update the text view.
		}

