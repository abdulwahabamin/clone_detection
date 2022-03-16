	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode){
		case 100: 
			if(resultCode!=Activity.RESULT_OK){
				Toast.makeText(this, "Blutooth not on", Toast.LENGTH_SHORT).show();
				finish();
			}
			break;
			
		default:
			break;
		}
	}

