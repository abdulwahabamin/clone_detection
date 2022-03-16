		@Override
		protected Void doInBackground(Void... params) {
			while(in!=null){
				try {
					msg = (String)in.readObject();
					ChatActivity.this.runOnUiThread(new Runnable(){

						@Override
						public void run() {
							TextView chat = (TextView) findViewById(R.id.chat);
							chat.append("\nOther>> "+msg);
						}
						
					});
				} catch (Exception e) {e.printStackTrace();} 
			}
			return null;
		}

