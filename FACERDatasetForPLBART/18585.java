		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			pd.dismiss();
			
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//Delete all the contents of the ArrayLists.
			clearArrayLists();
			dialogFragment.dismiss();
			Toast.makeText(parentActivity, R.string.changes_saved, Toast.LENGTH_SHORT).show();
			
		}

