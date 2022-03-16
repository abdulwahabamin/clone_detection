	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.about:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("关于").setMessage("本程�?�??供中国大陆�?�港澳�?�地区天气预报，数�?��?�?�自于气象局。\n\nlichao2012@gmail.com").setPositiveButton("知�?�了", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
				}

			}).show();
			break;
		case R.id.set:
			Intent intent = new Intent();
			intent.setClass(WeatherActivity.this, SelectArea.class);
			startActivity(intent);
			break;
		case R.id.update:
			String areano = Func.Check_position_no();
			if (areano.length() > 0) {
				new UpdateData(this).execute(getApplicationContext());
			}
		}

		return false;
	}

