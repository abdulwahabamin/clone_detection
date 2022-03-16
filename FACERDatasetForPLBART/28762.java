    public LinkedHashMap<String, List<String>> getDataGeneral() {
        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();
        List<String> general = new ArrayList<String>();
        general.add(context.getResources().getString(R.string.help_whatis_answer));
        expandableListDetail.put(context.getResources().getString(R.string.help_whatis), general);

        List<String> where = new ArrayList<String>();
        where.add(context.getResources().getString(R.string.help_where_from_answer));
        expandableListDetail.put(context.getResources().getString(R.string.help_where_from), where);

        List<String> radius = new ArrayList<String>();
        radius.add(context.getResources().getString(R.string.help_radius_search_text));
        expandableListDetail.put(context.getResources().getString(R.string.help_radius_search_title), radius);

        List<String> privacy = new ArrayList<String>();
        privacy.add(context.getResources().getString(R.string.help_privacy_answer));
        expandableListDetail.put(context.getResources().getString(R.string.help_privacy_heading), privacy);

        List<String> permissions = new ArrayList<String>();
        permissions.add(context.getResources().getString(R.string.help_permission_internet_heading));
        permissions.add(context.getResources().getString(R.string.help_permission_internet_description));
        expandableListDetail.put(context.getResources().getString(R.string.help_permissions_heading), permissions);

        return expandableListDetail;
    }

