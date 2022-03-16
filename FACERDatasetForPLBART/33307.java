    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        if (position % 2 == 1) {
            view.setBackgroundResource(BACKGROUND_RESOURCE_ODD);
        } else {
            view.setBackgroundResource(BACKGROUND_RESOURCE_EVEN);
        }
        return view;
    }

