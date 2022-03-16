	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if (requestCode == REQUEST_BT)
		{
			if (resultCode == Activity.RESULT_OK)
			{
				
				goDiscoverable();	
			}
		}else if (requestCode == REQUEST_DISCOVER)
		{
			if (resultCode != Activity.RESULT_CANCELED)
			{
				Intent i = new Intent(context, hostChat.class);
				i.putExtra("un", roomName.getText().toString());
				startActivity(i);
			}
		}
	}

