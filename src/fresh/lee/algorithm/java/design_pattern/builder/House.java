package fresh.lee.algorithm.java.design_pattern.builder;

public class House {
    private final String wall;
    private final String roof;
    private final String door;
    private final String windows;

    public static class Builder {
        private String wall;
        private String roof;
        private String door;
        private String windows;

        public Builder wall(String wall) {
            this.wall = wall;
            return this;
        }

        public Builder roof(String roof) {
            this.roof = roof;
            return this;
        }

        public Builder door(String door) {
            this.door = door;
            return this;
        }

        public Builder windows(String windows) {
            this.windows = windows;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    private House(Builder builder) {
        this.wall = builder.wall;
        this.roof = builder.roof;
        this.door = builder.door;
        this.windows = builder.windows;
    }

    @Override
    public String toString() {
        return wall + " " + door + " " + windows + " " + roof + "的小屋";
    }
}
