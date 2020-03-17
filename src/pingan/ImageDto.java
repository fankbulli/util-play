package pingan;

public class ImageDto {
    private String label;

    private String count;

    public ImageDto() {
    }

    @Override
    public String toString() {
        return "ImageDto{" +
                "label='" + label + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public ImageDto(String label, String count) {
        this.label = label;
        this.count = count;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
