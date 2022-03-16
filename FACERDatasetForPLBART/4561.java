		@Override
		protected void onPostExecute(Boolean result) {
			loading.setVisibility(View.GONE);
            if(android.os.Build.VERSION.SDK_INT>= 17) {
                if (!activity.isDestroyed())
                    displayFolder();
            } else {
				displayFolder();
			}
		}

