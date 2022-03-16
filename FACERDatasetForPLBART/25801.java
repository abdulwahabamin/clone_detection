    public View getTabView(int position, ViewGroup parent) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.weather_tab_view, parent, false);
        ImageView img =  view.findViewById(R.id.tab_icon);
        img.setImageResource(mFragmentList.get(position).second);
        return view;
    }

