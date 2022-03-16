    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mFragmentView==null){
            mFragmentView=inflater.inflate(R.layout.fragment_layout_1,container,false);
            initWidgets(mFragmentView);
            showWeather();
            refreshData();
        }else{
            if(mActivity.ffc_flag[mPosition].equals("true")) {
                //因为连接网速络刷新数�?�需�?少�?的时间，所以会造�?一定的滞�?�。
                //程�?�?次�?新开�?�的时候如果�?先调用一下showWeather()方法，
                // 则程�?会先将xml文件中定义的�?��?数�?�显示出�?�，而那些�?��?数�?�都是�?真实的，
                //这会给用户造�?�?好的体验。因此宜将上一次更新完的数�?�先显示出�?�，等数�?�更新完�?刷新显示一�??。
                showWeather();
                refreshData();
            }else{
                showWeather();
            }
        }
        return mFragmentView;
    }

