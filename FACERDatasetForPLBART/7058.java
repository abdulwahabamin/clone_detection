	/**
     *      Tries to do something with the item (Outside of an adapter we don't know how to process it).
     *      But an adapter knows, is it a folder and can be opened (it calls Commander.Navigate() in this case)
     *      or processed as default action (then it calls Commander.Open() )
	 * @param position index of the item to action
	 */
	public void openItem( int position );

