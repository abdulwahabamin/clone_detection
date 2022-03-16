    @Override
	protected void onProgressUpdate(String... values) {
		super.onProgressUpdate(values);
		
		String message = values[0];
		pd.setMessage(message);
	}

