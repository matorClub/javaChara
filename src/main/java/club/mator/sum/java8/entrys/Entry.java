package club.mator.sum.java8.entrys;


public class Entry {

    private String name;
    private String age;

    public Entry(String name, String age){
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
