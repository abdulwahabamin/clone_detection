		@Override
		protected Boolean doInBackground(Boolean... params) {
			//BLog.e("call refresh");
            fm.refresh(activity);
			//BLog.e("finish call refresh");
			return true;
		}

