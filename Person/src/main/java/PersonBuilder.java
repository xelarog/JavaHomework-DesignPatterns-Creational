public class PersonBuilder implements IPersonBuilder {
    private String address;
    private String name;
    private String surname;
    private Integer age;

    public PersonBuilder() {
    }

    public PersonBuilder(String surname, int age, String address) {
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    @Override
    public PersonBuilder setName(String name) {
        if (this.name == null)
            this.name = name;
        return this;
    }

    @Override
    public PersonBuilder setSurname(String surname) {
        if (this.surname == null)
            this.surname = surname;
        return this;
    }

    @Override
    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Указан неверный возраст!") {
            };
        }
        if (this.age == null)
            this.age = age;
        return this;
    }

    @Override
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() throws IllegalStateException {
        if (name == null)
            throw new IllegalStateException("Не указано имя");
        if (surname == null)
            throw new IllegalStateException("Не указана фамилия");
        if (age == null)
            throw new IllegalStateException("Не указан возраст");
        return new Person(name, surname, age, address);
    }
}
