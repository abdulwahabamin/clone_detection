    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Select a layout based on the current page
        int layoutResId=0;
        switch (mPage) {
            case 0:
                layoutResId = R.layout.intro_frag_1;
                break;

            case 1:
                layoutResId= com.singh.multimeet.quicxplo.R.layout.intro_frag_2;
                break;

            case 2:
                layoutResId = com.singh.multimeet.quicxplo.R.layout.intro_frag_3;
                break;

        }

        // Inflate the layout resource file
        View view = getActivity().getLayoutInflater().inflate(layoutResId, container, false);

        // Set the current page index as the View's tag (useful in the PageTransformer)
        view.setTag(mPage);

        return view;
    }

