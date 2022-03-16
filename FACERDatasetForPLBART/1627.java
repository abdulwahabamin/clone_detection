	public void selectedSend(View v){
		EditText msg = (EditText) findViewById(R.id.message);
		String message = msg.getText().toString();
		TextView chat = (TextView) findViewById(R.id.chat);
		chat.append("\nMe>> "+message);
		try {
			out.write(message.getBytes());
		} catch (IOException e) {e.printStackTrace();}
	}

