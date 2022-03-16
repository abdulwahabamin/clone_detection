    /**
     * Build key that uniquely identifies this stack. It omits most of the raw
     * details included in {@link #write(DataOutputStream)}, since they change
     * too regularly to be used as a key.
     */
    public String buildKey() {
        final StringBuilder builder = new StringBuilder();
        if (root != null) {
            builder.append(root.authority).append('#');
            builder.append(root.rootId).append('#');
        } else {
            builder.append("[null]").append('#');
        }
        for (DocumentInfo doc : this) {
            builder.append(doc.documentId).append('#');
        }
        return builder.toString();
    }

