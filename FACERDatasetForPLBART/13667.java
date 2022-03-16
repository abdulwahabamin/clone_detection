    private void setupNavigationView() {
        List<String> storageList = ((FMApplication) getApplication()).getStorageDirectories();
        // Assuming a device can have max 5 storage paths
        // FIXME: have dynamic storage options w.r.t device storage availability
        if (storageList.size() >= 5) {
            // do nothing, display all 5 storage options
        } else {
            int storageCount = storageList.size();

            Menu navMenu = navigationView.getMenu();

            switch (storageCount - 1) {
                case 0:
                    navMenu.findItem(R.id.nav_sd0).setVisible(true);
                    navMenu.findItem(R.id.nav_sd1).setVisible(false);
                    navMenu.findItem(R.id.nav_sd2).setVisible(false);
                    navMenu.findItem(R.id.nav_sd3).setVisible(false);
                    navMenu.findItem(R.id.nav_sd4).setVisible(false);
                    break;
                case 1:
                    navMenu.findItem(R.id.nav_sd0).setVisible(true);
                    navMenu.findItem(R.id.nav_sd1).setVisible(true);
                    navMenu.findItem(R.id.nav_sd2).setVisible(false);
                    navMenu.findItem(R.id.nav_sd3).setVisible(false);
                    navMenu.findItem(R.id.nav_sd4).setVisible(false);
                    break;
                case 2:
                    navMenu.findItem(R.id.nav_sd0).setVisible(true);
                    navMenu.findItem(R.id.nav_sd1).setVisible(true);
                    navMenu.findItem(R.id.nav_sd2).setVisible(true);
                    navMenu.findItem(R.id.nav_sd3).setVisible(false);
                    navMenu.findItem(R.id.nav_sd4).setVisible(false);
                    break;
                case 3:
                    navMenu.findItem(R.id.nav_sd0).setVisible(true);
                    navMenu.findItem(R.id.nav_sd1).setVisible(true);
                    navMenu.findItem(R.id.nav_sd2).setVisible(true);
                    navMenu.findItem(R.id.nav_sd3).setVisible(true);
                    navMenu.findItem(R.id.nav_sd4).setVisible(false);
                    break;
                case 4: // this case will never be called :D
                default:
                    navMenu.findItem(R.id.nav_sd0).setVisible(true);
                    navMenu.findItem(R.id.nav_sd1).setVisible(true);
                    navMenu.findItem(R.id.nav_sd2).setVisible(true);
                    navMenu.findItem(R.id.nav_sd3).setVisible(true);
                    navMenu.findItem(R.id.nav_sd4).setVisible(true);
                    break;
            }
        }
    }

