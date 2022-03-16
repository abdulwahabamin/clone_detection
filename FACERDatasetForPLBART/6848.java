    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.i("Steps", "onCreateViewHolder");
        view = inflater.inflate(R.layout.custom_row, parent, false);

        holder = new MyViewHolder(view);
        return holder;

    }

