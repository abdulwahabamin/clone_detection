    private void findClock() {
        try {
            getPackageManager().getResourcesForActivity(componentName1);
            componentName = componentName1;
        } catch (PackageManager.NameNotFoundException e1) {
            try {
                getPackageManager().getResourcesForActivity(componentName2);
                componentName = componentName2;
            } catch (PackageManager.NameNotFoundException e2) {
                try {
                    getPackageManager().getResourcesForActivity(componentName3);
                    componentName = componentName3;
                } catch (PackageManager.NameNotFoundException e3) {
                    try {
                        getPackageManager().getResourcesForActivity(componentName4);
                        componentName = componentName4;
                    } catch (PackageManager.NameNotFoundException e4) {
                        try {
                            getPackageManager().getResourcesForActivity(componentName5);
                            componentName = componentName5;
                        } catch (PackageManager.NameNotFoundException e5) {
                            try {
                                getPackageManager().getResourcesForActivity(componentName6);
                                componentName = componentName6;
                            } catch (PackageManager.NameNotFoundException e6) {
                                e5.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

