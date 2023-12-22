public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        Employee a1 = new Employee("Vasya", 1, 3000);
        Employee a2 = new Employee("Masha", 4, 7000);
        Employee a3 = new Employee("Error", 3, 5000);
        Employee a4 = new Employee("Egor", 2, 6000);
        Employee a5 = new Employee("Misha", 1, 1000);
        employeeBook.addEmployee(a1);
        employeeBook.addEmployee(a2);
        employeeBook.addEmployee(a3);
        employeeBook.addEmployee(a4);
        employeeBook.addEmployee(a5);
        employeeBook.getAllEmployee();
//        employeeBook.deleteEmployee(4);
//        employeeBook.deleteEmployee("Masha");
//        employeeBook.setEmployee("Masha", 2500, 5);
        employeeBook.getAllEmpByDepartment();
    }
}