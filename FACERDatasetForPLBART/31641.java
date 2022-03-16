		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
			progressDlg = new ProgressDialog(a);
			progressDlg.setMessage("正在设置...");
			progressDlg.setCancelable(false);
			progressDlg.show();
		}

