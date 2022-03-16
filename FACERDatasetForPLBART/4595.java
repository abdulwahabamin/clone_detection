    public void updateTitle() {
        if(fm!=null) {
            title=fm.getSelectedFiles().size()+"";
            mMode.setTitle(title);
        }

    }

