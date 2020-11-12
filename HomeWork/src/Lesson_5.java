public class Lesson_5 {

    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Первый Первович", "Босс", "Boss@head.one", "т. 89001111111", 1000000, 40);
        employees[1] = new Employee("Второй Вторович", "Зам", "NotBoss@head.one", "т. 89002222222", 40000, 30);
        employees[2] = new Employee("Третий Третьевич", "Зам зама", "NotNotBoss@head.one", "т. 89003333333", 30000, 20);
        employees[3] = new Employee("Четвертый Четвертович", "Инженер", "Genius@head.one", "т. 89004444444", 29999, 50);
        employees[4] = new Employee("Пятый Пятович", "Специалист", "Noone@head.one", "т. 89217134975", 15000, 20);

        for (int i = 0; i <= 4; i++) {
            if (employees[i].getAge() > 30) employees[i].getEmployeeCard();
        }
    }
}
