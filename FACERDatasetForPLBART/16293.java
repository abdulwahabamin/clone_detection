    @Override
    public void itemClick(int position) {
        MainActivity activity = (MainActivity) getActivity();
        switch (position) {
            case 0: //音�?
                activity.showFragment(2);
                break;
            case 1: //关于
                activity.showFragment(3);
                break;
        }
    }

