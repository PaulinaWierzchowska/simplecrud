package pl.sda.simplecrud;

public enum Colour {
    RED("czerwony"),
    WHITE("biały"),
    BLACK("czarny"),
    GREEN("zielony");

    private String plName;

    Colour(String plName) {
        this.plName = plName;
    }

    public String getPlName() {
        return plName;
    }
}
