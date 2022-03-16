    /**
     * Quick scroll indicator implementation.
     */
    @Override
    public String getIndicatorForPosition(int childPosition, int groupPosition) {
    	Cursor c = (Cursor) getItem(childPosition);
    	String title = c.getString(c.getColumnIndex(mDBColumnsMap.get(TITLE_TEXT)));
    	if (title!=null && title.length() > 1)
    		return "  " + title.substring(0, 1) + "  ";
        else
    		return "  N/A  ";
    }

