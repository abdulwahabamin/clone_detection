		@Override
		public void onClick(View v) {
			switch (v.getId()) {

			case R.id.startServerBtn:
				// 打开服务器
				Intent serverIntent = new Intent(MainActivity.this,
						ServerActivity.class);
				serverIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(serverIntent);
				break;

			case R.id.startClientBtn:
				// 打开客户端
				Intent clientIntent = new Intent(MainActivity.this,
						ClientActivity.class);
				clientIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(clientIntent);
				break;
			}
		}

