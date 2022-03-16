	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		try {
			lv = getListView();
			data.add("Loading...");
			lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, data));

			lv.setTextFilterEnabled(true);
			lv.setOnItemClickListener(this);

			Intent intent = getIntent();
			Level = intent.getStringExtra("NewLevel");
			String strno = intent.getStringExtra("no");

			if (Level == null) {
				Level = "";
			}

			String strSQLCommandText = "";

			if (Level.equalsIgnoreCase("")) {
				NewLevel = "c";
				strSQLCommandText = "select no,name from province";
			} else if (Level.equalsIgnoreCase("c")) {
				NewLevel = "a";
				strSQLCommandText = "select no,name from city where no like '" + strno + "%'";
			} else if (Level.equalsIgnoreCase("a")) {
				strSQLCommandText = "select no,name,position_no from area where no like '" + strno + "%'";
			} else {
				strSQLCommandText = "";
			}

			new AsyncLoader().execute(strSQLCommandText);
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
		}

	}

