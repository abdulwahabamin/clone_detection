    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        boolean isRemovalModeButton = SharedPrefsHelper.isRemovalModeButton(parentActivity);

        int layoutResourceId = isRemovalModeButton ?
                R.layout.general_drag_sort_list_remove_disabled :
                R.layout.general_drag_sort_list_remove_enabled;

        return inflater.inflate(layoutResourceId, container, false);
    }

