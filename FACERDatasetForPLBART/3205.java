    public FileArrayAdapter(Context activityContext, int idViewResource, List<File> elements) {
        super(activityContext, idViewResource, elements);
        this.activityContext = activityContext;
        this.idViewResource = idViewResource;
        this.elements = elements;
    }

