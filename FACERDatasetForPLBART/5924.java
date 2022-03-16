	public void onListItemClick(ListView l, View v, int position, long id)
	{
		setResult(
			RESULT_OK,
			new Intent(
				null,
				Uri.fromFile(MainActivity.files_found.get(position))
			)
		);
		finish();
	}

