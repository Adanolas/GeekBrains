public class Employee {
    private String name;
    private String assignment;
    private String email;
    private String phone;
    private int salary;
    private int age;

    Employee (String v_name, String v_assignment, String v_email, String v_phone, int v_salary, int v_age) {
        if (v_name != null) name = v_name;
        else name = "не указано";

        if (v_assignment != null) assignment = v_assignment;
        else assignment = "не указана";

        if (v_email != null) email = v_email;
        else email = "не указана";

        phone = "";

        for (int i = 0; i < v_phone.length(); i++) {
            switch (v_phone.charAt(i)) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0': phone += v_phone.charAt(i);
                    break;
                default: break;
            }
        }

        if (phone.equals("")) phone = "не указан";

        salary = v_salary;
        age = v_age;
    }

    void getEmployeeCard () {
        String v_name = "Имя: " + name;
        String v_assignment = "Должность: " + assignment;
        String v_email = "Почта: " + email;
        String v_phone = "Телефон: " + phone;
        String v_salary = "Зарплата: " + salary;
        String v_age = "Возраст: " + age;
        int maxLength = Math.max(v_age.length(),v_assignment.length());
        maxLength = Math.max(maxLength,v_email.length());
        maxLength = Math.max(maxLength,v_name.length());
        maxLength = Math.max(maxLength,v_phone.length());
        maxLength = Math.max(maxLength,v_salary.length());
        for (int i = 0; i < maxLength + 4; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println(getOutLine(v_name,maxLength));
        System.out.println(getOutLine(v_assignment,maxLength));
        System.out.println(getOutLine(v_email,maxLength));
        System.out.println(getOutLine(v_phone,maxLength));
        System.out.println(getOutLine(v_salary,maxLength));
        System.out.println(getOutLine(v_age,maxLength));
        for (int i = 0; i < maxLength + 4; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    String getOutLine (String line, int maxLength) {
        String outLine = "| " + line;
        for (int i = 0; i < maxLength - line.length() + 1; i++) outLine += " ";
        return outLine + "|";
    }

    int getAge () {
        return age;
    }
}
