    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set the background color of the root view to the color specified in newInstance()
        View background = view.findViewById(com.singh.multimeet.quicxplo.R.id.intro_background);
        background.setBackgroundColor(mBackgroundColor);
        TextView title=view.findViewById(com.singh.multimeet.quicxplo.R.id.title);
        title.setTypeface(AppController.getTypeface());

        if(mPage==2&& getActivity()!=null){
            Button finish=view.findViewById(com.singh.multimeet.quicxplo.R.id.description);
            finish.setTypeface(AppController.getTypeface());
            finish.setOnClickListener(view1 -> {
                getActivity().getSharedPreferences(Util.DIR_DATA, Context.MODE_PRIVATE)
                    .edit().putString(Util.START_UP_FLAG,"1").apply();
                Intent i=new Intent(getActivity(),Home.class);
                getActivity().startActivity(i);
                getActivity().finish();
            });
        }else{
            TextView des=view.findViewById(com.singh.multimeet.quicxplo.R.id.description);
            des.setTypeface(AppController.getTypeface());

        }
    }

