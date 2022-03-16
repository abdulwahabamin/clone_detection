	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		switch(requestCode)
		{
			case R.id.mainactivity_menu_search_results:
				if(resultCode == RESULT_OK)
				{
					File f = new File(data.getData().getPath());
					if(f.exists())
					{
						File pf = f.getParentFile();
						if(pf != null)
							setCurrentDir(pf);
						else
							setCurrentDir(root_dir);

						goToItem(f);
					}
					else showToast(R.string.doesnt_exist);
				}
				break;
		}
	}

