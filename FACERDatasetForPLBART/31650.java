		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();

			progressDlg = new ProgressDialog(weatherActivity);
			progressDlg.setMessage("正在刷新...");
			progressDlg.setCancelable(true);
			progressDlg.show();
		}

