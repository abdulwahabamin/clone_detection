	public SelectionAdapter(Context context, int resource,
			int textViewResourceId, ArrayList<String> values) {
		super(context, resource, textViewResourceId, values);
		this.context = context;
		this.values = values;
	}

