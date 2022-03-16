		@Override
		protected Void doInBackground(Context... c) {
			// TODO Auto-generated method stub

			Func.SaveJSON();
			Func.UpdateWidget(c[0]);

			return null;
		}

