		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			lv.setAdapter(new ArrayAdapter<String>(SelectArea.this, R.layout.list_item, newdata));
			if (ErrMSG.length() > 0) {
				Toast.makeText(getApplicationContext(), ErrMSG, Toast.LENGTH_LONG).show();
			}
		}

