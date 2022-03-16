    public static void clearStateObject(int SECTION_, String STATE_OBJECT_) {
        List<StateObject> objects = S.state.get(Integer.valueOf(SECTION_));
        if(objects!=null && !objects.isEmpty()) {
            for(int i=0; i<objects.size(); i++) {
                if(objects.get(i).getName().equals(STATE_OBJECT_)) {
                    objects.remove(i);
                }
            }
            //S.state.get(Integer.valueOf(SECTION_)).r;
        }
    }

