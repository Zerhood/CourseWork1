public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        Employee a1 = new Employee("Vasya", 1, 3000);
        Employee a2 = new Employee("Masha", 4, 7000);
        Employee a3 = new Employee("Freddy", 3, 5000);
        Employee a4 = new Employee("Egor", 2, 6000);
        Employee a5 = new Employee("Misha", 1, 2500);
        Employee a6 = new Employee("Oleg", 4, 5000);
        Employee a7 = new Employee("Ul'yana", 1, 10000);
        Employee a8 = new Employee("Denis", 1, 9800);
        Employee a9 = new Employee("Tor", 4, 6500);

        employeeBook.addEmployee(a1);
        employeeBook.addEmployee(a2);
        employeeBook.addEmployee(a3);
        employeeBook.addEmployee(a4);
        employeeBook.addEmployee(a5);
        employeeBook.addEmployee(a6);
        employeeBook.addEmployee(a7);
        employeeBook.addEmployee(a8);
        employeeBook.addEmployee(a9);

        employeeBook.getAllEmployee();
        System.out.println();
        employeeBook.deleteEmployee(4);
        employeeBook.deleteEmployee("Masha");
        employeeBook.setEmployee("Mash", 2500, 5);

        employeeBook.getAllEmpByDepartment();
    }
}