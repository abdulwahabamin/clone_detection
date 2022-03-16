    public void showFragment(int currentIndex) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (currentIndex == lastIndex) {
            return;
        }
        if (lastIndex != -1) {
            ft.hide(fragments[lastIndex]);
        }
        if (fragments[currentIndex] == null) {
            switch (currentIndex) {
                case 0:
                    fragments[currentIndex] = StartFragment.newInstance();
                    break;
                case 1:
                    fragments[currentIndex] = OptionFragment.newInstance();
                    break;
                case 2:
                    fragments[currentIndex] = MusicFragment.newInstance();
                    break;
                case 3:
                    fragments[currentIndex] = AboutFragment.newInstance();
                    break;
                case 4:
                    fragments[currentIndex] = PlayerFragment.newInstance();
                    break;
                default:
                    break;
            }
            ft.add(R.id.main_fl_container, fragments[currentIndex]);
        } else {
            ft.show(fragments[currentIndex]);
        }
        ft.commit();
        lastIndex = currentIndex;
    }

