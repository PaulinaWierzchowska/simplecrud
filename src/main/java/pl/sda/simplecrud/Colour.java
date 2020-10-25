package pl.sda.simplecrud;

public enum Colour {
    RED("czerwony"),
    BLACK("czarny"),
    WHITE("biały"),
    GREEN("zielony");

    private String plName;

    Colour(String plName) {
        this.plName = plName;
    }

    public String getPlName() {
        return plName;
    }
}
