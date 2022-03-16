	protected void onPostExecute(Boolean result) {
		pd.setProgress(100);
		pd.setMessage("Delete successful!!");
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				pd.dismiss();
			}
		}, 2000);
	}

