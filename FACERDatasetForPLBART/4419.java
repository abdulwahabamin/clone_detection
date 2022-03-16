	public static void openAndroidContactsCreateNew(Activity activity) {
	    //Uri mSelectedContactUri = Contacts.getLookupUri(Sf.toLong(person.getId()), person.getLookupKey());

	    // Creates a new Intent to edit a contact
	    //Intent editIntent = new Intent(Intent.ACTION_);
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra("finishActivityOnSaveCompleted", true);
	    activity.startActivity(intent);
	}

