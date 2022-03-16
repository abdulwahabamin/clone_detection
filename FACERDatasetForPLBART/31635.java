	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.putExtra("no", no[arg2]);

		if (Level.equalsIgnoreCase("a")) {
			new AlertDialog.Builder(this)
			.setCancelable(false)
			.setTitle("设置")
			.setMessage("将所属地区设置为 " + name[arg2] + " ？")
			.setPositiveButton("是", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					DB db = DB.GetDB();
					db.execSQL("update settings set setvalue = '" + position_no[arg2] + "' where setkey = 'position_no'");
					db.close();
					Toast.makeText(getApplicationContext(), "正在设置...", Toast.LENGTH_LONG).show();
					String areano = Func.Check_position_no();
					if(areano.length() > 0) {
						new UpdateData(SelectArea.this).execute(getApplicationContext());
					}
					
				}
			})
			.setNegativeButton("�?�", null)
			.show();
		} else {
			intent.putExtra("NewLevel", NewLevel);
			intent.setClass(SelectArea.this, SelectArea.class);
			startActivity(intent);
		}
	}

