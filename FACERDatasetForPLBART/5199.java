    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
            case 1:
            case 2:
                return IntroFragment.newInstance(Color.parseColor("#007DD6"), position);
        }
        return null;
    }

