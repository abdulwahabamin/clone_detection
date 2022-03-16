    private void initView(View view) {
        final LayoutInflater mInflater = LayoutInflater.from(getActivity());
        final TagFlowLayout flowLayout = (TagFlowLayout) view.findViewById(R.id.id_flowlayout);
        flowLayout.setAdapter(new TagAdapter<String>(tags) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flow_layout,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        });

        flowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent){
                Intent intent = new Intent(getActivity(), WikiResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("keyWord",tags[position]);
                bundle.putString("url",links[position]);
                intent.putExtra("result", bundle);
                startActivity(intent);
                return true;
            }
        });
    }

