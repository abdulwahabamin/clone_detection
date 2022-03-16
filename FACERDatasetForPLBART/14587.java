    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.quick_queue, container, false);
        mGridView = (GridView)root.findViewById(R.id.gridview);
        mGridView.setNumColumns(1);

        LinearLayout mQueueHolder = (LinearLayout)root.findViewById(R.id.quick_queue_holder);
        mQueueHolder.setBackgroundColor(getResources().getColor(R.color.transparent_black));
        return root;
    }

