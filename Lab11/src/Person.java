public class Person {
    private final String name;
    private final String surname;
    private final String lastname;
    private final String phoneNumber;
    Person(String name, String surname, String lastname, String phoneNumber){
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString(){
        return String.format("Имя: %s\nФамилия: %s\nОтчество: %s\nНомер телефона: %s\n\n",name,surname,lastname,phoneNumber);
    }
}
