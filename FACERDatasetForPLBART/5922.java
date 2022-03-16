	public void onClick(DialogInterface dialog, int which)
	{
		if(dialog == alert_dialog)
		{
			if(which == DialogInterface.BUTTON_POSITIVE)
			{
				returnFile(file);
			}
		}
	}

